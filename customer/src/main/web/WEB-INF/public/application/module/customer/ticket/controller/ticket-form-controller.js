export default ($scope, $uibModalInstance, $rootScope, ticket, ticketService,
                supportLevelService, logged, ticketPriorityService) => {

  $scope.covered = false;
  $scope.ticket = ticket;
  $scope.customer = logged.logged.customer;
  $scope.ticket.contractor = $scope.customer.contractor;

  function setSupportLevel(ticket) {
    if (ticket.supportLevel)
      return;
    supportLevelService.list().then(response => {
      response.filter(e => e.number === 1).forEach(e => ticket.supportLevel = e);
    });
  }

  $scope.close = () => $uibModalInstance.close();

  $scope.new = ticket => {
    ticket.initiator = logged.getAccount();
    $scope.covered = true;
    ticketService.new(ticket).then(function (response) {
      $scope.covered = false;
      $scope.close();
      $rootScope.$broadcast("ticket::change");
    });
  };

  $scope.update = data => {
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
}