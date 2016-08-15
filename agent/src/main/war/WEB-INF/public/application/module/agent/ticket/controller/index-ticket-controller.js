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

    filter.levelIds = $scope.selectedLevels.map(e => e.id);
  };

  var updateSupportLevels = () => {
    supportLevelService.list().then(result => {
      $scope.levels = result;
    });
  };

  var updatePerformerStore = () => {
    agentPerformerService.listAccount().then(response => {
      $scope.performers = response.map(e => {
        return {id: e.id, title: `${e.firstName} ${e.secondName}`}
      });
    });
  };

  var updateTicketList = silent => {
    prepareFilter();

    if (!silent) {
      $scope.covered = true;
    }

    return ticketService.list($scope.filter).then(response => {
      $scope.paginator.load(response, $scope.pageSize);
      if (!silent) {
        $scope.covered = false;
      }
    });
  };

  $scope.form = (ticket=new TicketModel()) => {
    $scope.$broadcast('ticket::form::open');
    ticketForm.open(angular.copy(ticket));
  };

  $scope.whereImPerformer = () => {
    let account = logged.getAccount();
    $scope.modelFilter.performer = {
      id: account.id,
      title: `${account.firstName} ${account.secondName}`
    };
  };

  monitor.configure({
    service: () => updateTicketList(true),
    timeout: 3000
  });

  $scope.updateTicketList = updateTicketList;

  updatePerformerStore();
  updateSupportLevels();
  updateTicketList().then(() => monitor.start());
}