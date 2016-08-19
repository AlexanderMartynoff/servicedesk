export default ($scope, $rootScope, $uibModalInstance, logged,
                ticketService, contractorService, ticket, agentPerformerService,
                uaService, ticketForm, supportLevelService, ticketTypeService,
                ticketPriorityService, knowledgeDetail) => {

  $scope.covered = true;
  $scope.ticket = ticket;
  $scope.levelNumber = 1;
  $scope.progressStates = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
  $scope.ticket.progress = $scope.ticket.progress || 0;
  $scope.logged = logged;

  $uibModalInstance.opened.then(() => $scope.covered = false);

  var closeInstance = (throwEvent=false) => {
    $scope.covered = false;
    $uibModalInstance.close();
    if(throwEvent){
      $rootScope.$broadcast('ticket::form::close');
    }
  };

  $scope.close = closeInstance;

  $scope.update = data => {
    $scope.covered = true;
    ticketService.update(data).then(() => $scope.covered = false);
  };

  $scope.create = data => {
    $scope.covered = true;
    ticketService.new(data).then(() => closeInstance(true));
  };

  $scope.remove = id => {
    $scope.covered = true;
    ticketService.delete(id).then(() => closeInstance(true));
  };

  $scope.doEscalation = offset => ticketService.doEscalation(
    ticket,
    offset,
    $scope.supportLevelStore
  );

  $scope.assignToMe = () => ticket.performer = logged.getAccount();

  // this show new modal window and close current
  // but after closed children window we comeback parent
  $scope.showKnowledgeDetail = () => {
    closeInstance();
    knowledgeDetail.open(ticket).closed.then(() => {
      ticketForm.open(ticket);
    });
  };

  $scope.onRead = $files => $scope.covered = true;
  $scope.onCompete = $files => $scope.covered = false;

  // updaters
  var  updateContractorStore = () => {
    contractorService.list().then(response => $scope.contractorStore = response);
  };

  var updateInitiatorStore = () => {
    uaService.listAccount().then(response => $scope.initiatorStore = response);
  };

  var updatePerformerStore = () => {
    agentPerformerService.listAccount().then(response => $scope.performerStore = response);
  };

  var setTicketLevelSupport = store => {
    if (ticket.supportLevel) {
      return;
    }

    store.filter(level => level.number === $scope.levelNumber)
      .forEach(level => ticket.supportLevel = level);
  };

  var updateSupportLevelStore = () => {
    supportLevelService.list().then(data => {
      setTicketLevelSupport(data);
      $scope.supportLevelStore = data;
    });
  };

  var updateTicketTypeStore = () => {
    ticketTypeService.list().then(response => $scope.typeStore = response);
  };

  var updateTicketPriorityStore = () => {
    ticketPriorityService.list().then(response => $scope.priorityStore = response);
  };

  updateTicketTypeStore();
  updateTicketPriorityStore();
  updateSupportLevelStore();
  updatePerformerStore();
  updateContractorStore();
  updateInitiatorStore();
}