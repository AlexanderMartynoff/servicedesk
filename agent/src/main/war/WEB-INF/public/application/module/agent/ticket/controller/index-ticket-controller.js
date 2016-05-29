angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, logged, ticketForm, TicketModel, ticketService, $timeout, Paginator) {

    $scope.filter = {};
    $scope.paginator = new Paginator();
    $scope.pageSize = 10;
    $scope.covered = true;

    $scope.isJustPerformer = function(){
      logged.agentPerformer = logged.agentPerformer || {};
      logged.agentOperator = logged.agentOperator || {};

      return logged.agentPerformer.enable && !logged.agentOperator.enable;
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
        $scope.filter.performer = logged.account.firstName;
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