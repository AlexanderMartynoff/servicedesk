angular.module('customer.ticket')
  .controller('TicketController', function ($scope, logged, ticketForm,
                                            ticketService, Paginator, TicketModel, ellipsis) {

    $scope.paginator = new Paginator();
    $scope.ellipsis = ellipsis;

    $scope.updateTickets = function () {
      $scope.covered = true;
      ticketService.list({initiatorId: logged.getId()}).then(function (data) {
        $scope.paginator.load(data);
        $scope.covered = false;
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