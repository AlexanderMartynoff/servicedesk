export default ($scope, $rootScope, logged, ticketForm, ticketService,
                Paginator, TicketModel, ellipsis, Monitor) => {

  const monitor = Monitor.instance();

  $scope.paginator = new Paginator();
  $scope.ellipsis = ellipsis;

  $scope.$on("ticket::form:close", () => monitor.start());
  $scope.$on("ticket:form::open", () => monitor.stop());

  $scope.updateTickets = (silent) => {
    if(!silent){
      $scope.covered = true;
    }
    return ticketService.list({initiatorId: logged.getId()}).then(function (data) {
      $scope.paginator.load(data);
      if(!silent){
        $scope.covered = false;
      }
    });
  };

  $scope.form = (ticket=new TicketModel()) => {
    $scope.$broadcast('ticket:form::open');
    ticketForm.open(ticket).closed.then(() => monitor.start());
  };

  monitor.configure({
    service: () => $scope.updateTickets(true),
    timeout: 3000
  });

  $scope.updateTickets().then(() => monitor.start());
}