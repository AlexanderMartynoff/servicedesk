angular.module('customer.ticket')
  .controller('TicketController', ['$scope', 'ticketForm', 'ticketService', 'Paginator',
    function ($scope, form, ticketService, Paginator) {
      $scope.paginator = new Paginator();

      $scope.updateTickets = function () {
        ticketService.list({contractorId: 0}).then(function (data) {
          $scope.paginator.load(data);
        });
      };

      $scope.open = function (ticket) {
        form.open(ticket);
      };

      $scope.updateTickets();
    }]);