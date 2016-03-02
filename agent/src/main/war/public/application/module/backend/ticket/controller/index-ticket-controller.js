angular.module("backend.ticket")
  .controller("IndexTicketController", function ($scope, ticketForm, TicketModel, ticketService, $timeout) {

    $scope.edit = function (ticket) {
      ticketForm.open(ticket, $scope);
    };

    $scope.new = function () {
      ticketForm.open(new TicketModel(), $scope);
    };

    $scope.updateTicketList = function () {
      ticketService.list().then(function (response) {

        $scope.list = response.map(function (i) {
          i._progress = i.progress;
          i.progress = 0;
          return i;
        });

        $timeout(function () {
          $scope.list.forEach(function (i) {
            i.progress = i._progress;
          });
        }, 100);
      });
    };

    $scope.updateTicketList();
  });