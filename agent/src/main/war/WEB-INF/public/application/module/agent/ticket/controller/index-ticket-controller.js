angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, ticketForm, TicketModel,
                                                 ticketService, $timeout, Paginator) {
    $scope.paginator = new Paginator();

    $scope.edit = function (ticket) {
      ticketForm.open(ticket, $scope);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel(), $scope);
    };

    $scope.updateTicketList = function () {
      ticketService.list().then(function (response) {
        $scope.paginator.load(response);
      });
    };

    $scope.updateTicketList();
  });