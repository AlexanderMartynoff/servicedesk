export default ($scope, $uibModalInstance, $rootScope, ticket, ticketService,
                supportLevelService, logged, ticketPriorityService) => {

  $scope.covered = false;
  $scope.ticket = ticket;
  $scope.customer = logged.logged.customer;
  $scope.ticket.contractor = $scope.customer.contractor;

  var setSupportLevel = ticket => {
    if (ticket.supportLevel){
      return;
    }
    supportLevelService.list().then(response => {
      response.filter(e => e.number === 1).forEach(e => ticket.supportLevel = e);
    });
  };

  var updateTicketPriorityStore = () => {
    ticketPriorityService.list().then(response => $scope.priorityStore = response);
  };

  $scope.close = () => $uibModalInstance.close();

  $scope.create = ticket => {
    ticket.initiator = logged.getAccount();
    $scope.covered = true;
    ticketService.new(ticket).then(response => {
      $scope.covered = false;
      $scope.close();
    });
  };

  $scope.update = data => {
    $scope.covered = true;
    ticketService.update(data).then(response => $scope.covered = false);
  };

  updateTicketPriorityStore();
  setSupportLevel(ticket);
}