angular.module('customer.ticket')
  .controller('TicketController', function ($scope, ticketForm, ticketService, Paginator, TicketModel) {

    $scope.paginator = new Paginator();

    $scope.updateTickets = function () {
      ticketService.list().then(function (data) {
        $scope.paginator.load(data);
      });
    };

    $scope.open = function (ticket) {
      ticketForm.open(ticket);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel());
    };

    $scope.$on("ticket::change", function(){
      $scope.updateTickets();
    });

    $scope.updateTickets();
  });