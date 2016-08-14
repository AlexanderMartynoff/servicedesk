import angular from 'angular';


export default ($scope, logged, supportLevelService, ticketForm,
                TicketModel, ticketService, $timeout, Paginator,
                ellipsis, agentPerformerService, Monitor) => {

  var monitor = Monitor.instance();

  $scope.filter = {};
  $scope.modelFilter = {};
  $scope.paginator = new Paginator();
  $scope.pageSize = 10;
  $scope.covered = true;
  $scope.selectedLevels = [];
  $scope.logged = logged;
  $scope.ellipsis = ellipsis;

  // event handing
  $scope.$on('ticket::form::close', () => monitor.start());
  $scope.$on('ticket::form::open', () => monitor.stop());
  $scope.$on('$$destroy', () => monitor.stop());

  // do filter
  var prepareFilter = () => {
    var modelFilter = $scope.modelFilter, filter = $scope.filter;

    filter.performerId = $scope.modelFilter.performer ? modelFilter.performer.id : null;

    if (logged.isOnlyPerformer()) {
      filter.performerId = logged.getId();
    }

    filter.levelIds = $scope.selectedLevels.map(function (e) {
      return e.id
    });
  };

  var forTypeHead = collection => {
    var isSingle = false,
      result;

    if (!Array.isArray(collection)) {
      collection = [collection];
      isSingle = true;
    }

    result = collection.map(account => {
      return {
        title: account.firstName + ' ' + account.secondName,
        id: account.id
      }
    });

    return isSingle ? result[0] : result;
  };

  var updateSupportLevels = () => {
    supportLevelService.list().then(function (result) {
      $scope.levels = result;
    });
  };

  var updatePerformerStore = () => {
    agentPerformerService.listAccount().then(function (response) {
      $scope.performers = forTypeHead(response);
    });
  };

  var updateTicketList = silentMode => {
    prepareFilter();

    if (!silentMode) {
      $scope.covered = true;
    }

    return ticketService.list($scope.filter).then(response => {
      $scope.paginator.load(response, $scope.pageSize);
      if (!silentMode) {
        $scope.covered = false;
      }
    });
  };

  $scope.updateTicketList = updateTicketList;

  $scope.form = (ticket=new TicketModel()) => {
    $scope.$broadcast('ticket::form::open');
    ticketForm.open(angular.copy(ticket));
  };

  $scope.whereImPerformer = function () {
    $scope.modelFilter.performer = forTypeHead(logged.getAccount());
  };

  monitor.configure({
    service: () => updateTicketList(true),
    timeout: 7000
  });

  updatePerformerStore();
  updateSupportLevels();
  updateTicketList().then(() => monitor.start());
}