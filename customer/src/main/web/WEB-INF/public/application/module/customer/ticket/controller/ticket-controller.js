angular.module('customer.ticket')
  .controller('TicketController', function ($scope, logged$user, ticketForm,
                                            ticketService, Paginator, TicketModel, ellipsis) {

    $scope.paginator = new Paginator();
    $scope.ellipsis = ellipsis;

    $scope.updateTickets = function () {
      ticketService.list({initiatorId: logged$user.getId()}).then(function (data) {
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