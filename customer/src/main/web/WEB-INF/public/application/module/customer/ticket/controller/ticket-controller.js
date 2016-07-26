export default ($scope, logged, ticketForm, ticketService, Paginator, TicketModel, ellipsis) => {

  $scope.paginator = new Paginator();
  $scope.ellipsis = ellipsis;

  $scope.updateTickets = () => {
    $scope.covered = true;
    ticketService.list({initiatorId: logged.getId()}).then(function (data) {
      $scope.paginator.load(data);
      $scope.covered = false;
    });
  };

  $scope.open = ticket => ticketForm.open(ticket);

  $scope.new = () => ticketForm.open(new TicketModel());

  $scope.$on("ticket::change", () => $scope.updateTickets());

  $scope.updateTickets();
}