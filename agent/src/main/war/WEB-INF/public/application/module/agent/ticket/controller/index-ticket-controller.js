angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, logged$user, supportLevelService, ticketForm,
                                                 TicketModel, ticketService, $timeout, Paginator, ellipsis,
                                                 agentPerformerService) {

    $scope.filter = {};
    $scope.fullFilter = {};
    $scope.paginator = new Paginator();
    $scope.pageSize = 10;
    $scope.covered = true;
    $scope.selectedLevels = [];
    $scope.logged$user = $scope.l$u = logged$user;
    $scope.ellipsis = ellipsis;

    // do filter
    function prepareFilter(){

      if($scope.fullFilter.performer) {
        $scope.filter.performerId = $scope.fullFilter.performer.id;
      }

      if(logged$user.isOnlyPerformer()){
        $scope.filter.performerId = logged$user.getId();
      }

      $scope.filter.levelIds = $scope.selectedLevels.map(function(e){ return e.id });
    }

    function forTypeHead(collection){
      return collection.map(function(account){
        return {
          title: account.firstName + ' ' + account.secondName,
          id: account.id
        }
      });
    }

    $scope.edit = function (ticket) {
      ticketForm.open(ticket);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel());
    };

    $scope.updateTicketList = function (silent) {
      $scope.covered = true;
      prepareFilter();
      ticketService.list($scope.filter).then(function (response) {
        $scope.paginator.load(response, $scope.pageSize);
        $scope.covered = false;
      });
    };

    $scope.updateLevels = function(){
      supportLevelService.list().then(function(result){
        $scope.levels = result;
      });
    };

    $scope.whereImPerformer = function(){
      $scope.fullFilter.performer = forTypeHead([$scope.l$u.getAccount()])[0];
    };

    function updatePerformerStore() {
      agentPerformerService.listAccount().then(function (response) {
        $scope.performers = forTypeHead(response);
      });
    }

    $scope.$on('ticket::change', function(){
      $scope.updateTicketList();
    });

    updatePerformerStore();
    $scope.updateLevels();
    $scope.updateTicketList();
  });