angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, ticketForm, TicketModel, ticketService, $timeout, Paginator) {

    $scope.filter = {};
    $scope.paginator = new Paginator();

    $scope.edit = function (ticket) {
      ticketForm.open(ticket);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel());
    };

    $scope.updateTicketList = function () {
      ticketService.list($scope.filter).then(function (response) {
        $scope.paginator.load(response);
      });
    };

    $scope.$on('ticket::change', function(){
      $scope.updateTicketList();
    });

    $scope.updateTicketList();
  });