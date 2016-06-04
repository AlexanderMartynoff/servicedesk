angular.module('customer.ticket')
  .controller('TicketFormController', function ($scope, $uibModalInstance, $rootScope,
                                                ticket, ticketService, supportLevelService,
                                                logged$user, ticketPriorityService) {

    $scope.covered = false;
    $scope.ticket = ticket;
    $scope.customer = logged$user.data.customer;
    $scope.ticket.contractor = $scope.customer.contractor;

    function setSupportLevel(ticket) {
      if (ticket.supportLevel) return;
      supportLevelService.list().then(function (response) {
        response.filter(function (e) {
          return e.number === 1;
        }).forEach(function (e) {
          ticket.supportLevel = e;
        })
      });
    }

    $scope.close = function () {
      $uibModalInstance.close();
    };

    $scope.new = function (ticket) {
      ticket.initiator = logged$user.getAccount();
      $scope.covered = true;
      ticketService.new(ticket).then(function (response) {
        $scope.covered = false;
        $scope.close();
        $rootScope.$broadcast("ticket::change");
      });
    };

    $scope.update = function (data) {
      $scope.covered = true;
      ticketService.update(data).then(function (response) {
        $scope.close();
        $scope.covered = false;
      });
    };

    function updateTicketPriorityStore(){
      ticketPriorityService.list().then(function(response){
        $scope.priorityStore = response;
      });
    }

    updateTicketPriorityStore();
    setSupportLevel(ticket);
  });