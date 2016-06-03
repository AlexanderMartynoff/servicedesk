angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, logged$user, supportLevelService, ticketForm,
                                                 TicketModel, ticketService, $timeout, Paginator) {

    $scope.filter = {};
    $scope.paginator = new Paginator();
    $scope.pageSize = 10;
    $scope.covered = true;
    $scope.selectedLevels = [];
    $scope.logged$user = $scope.l$u = logged$user;

    function prepareFilter(){
      if(logged$user.isOnlyPerformer()){
        $scope.filter.performerId = logged$user.getId();
      }
      if(logged$user.isManager()){
        $scope.filter.levelIds = $scope.selectedLevels.map(function(e){ return e.id });
      }
    }

    $scope.edit = function (ticket) {
      ticketForm.open(ticket);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel());
    };

    $scope.updateTicketList = function () {
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

    $scope.$on('ticket::change', function(){
      $scope.updateTicketList();
    });

    $scope.updateLevels();
    $scope.updateTicketList();
  });