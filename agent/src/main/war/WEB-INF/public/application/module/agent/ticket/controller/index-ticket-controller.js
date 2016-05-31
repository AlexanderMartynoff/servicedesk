angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, logged$user, ticketForm, TicketModel, ticketService, $timeout, Paginator) {

    $scope.filter = {};
    $scope.paginator = new Paginator();
    $scope.pageSize = 10;
    $scope.covered = true;

    $scope.isJustPerformer = function(){
      return logged$user.isOnlyPerformer();
    };

    $scope.edit = function (ticket) {
      ticketForm.open(ticket);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel());
    };

    $scope.updateTicketList = function () {
      $scope.covered = true;

      if($scope.isJustPerformer()){
        $scope.filter.performer = logged$user.data.account.firstName;
      }

      ticketService.list($scope.filter).then(function (response) {
        $scope.paginator.load(response, $scope.pageSize);
        $scope.covered = false;
      });
    };

    $scope.$on('ticket::change', function(){
      $scope.updateTicketList();
    });

    $scope.updateTicketList();
  });