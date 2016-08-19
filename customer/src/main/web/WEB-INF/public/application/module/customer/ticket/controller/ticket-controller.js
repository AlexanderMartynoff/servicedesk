export default ($scope, $rootScope, logged, ticketForm,
                ticketService, Paginator, TicketModel, ellipsis) => {

  $scope.paginator = new Paginator();
  $scope.ellipsis = ellipsis;

  $scope.$on('ticket::data::change', () => $scope.updateTickets());

  $scope.updateTickets = (silent=false) => {
    if(!silent){
      $scope.covered = true;
    }
    return ticketService.list({initiatorId: logged.getId()}).then(data => {
      $scope.paginator.load(data);
      if(!silent){
        $scope.covered = false;
      }
    });
  };

  $scope.form = (ticket=new TicketModel()) => ticketForm.open(ticket);
  $scope.updateTickets();
}