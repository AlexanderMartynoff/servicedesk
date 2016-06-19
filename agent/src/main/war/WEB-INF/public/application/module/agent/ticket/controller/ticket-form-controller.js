angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $rootScope, $uibModalInstance,
                                                logged, ticketService, contractorService,
                                                ticket, agentPerformerService, uaService, ticketForm,
                                                supportLevelService, ticketTypeService,
                                                ticketPriorityService, knowledgeDetail) {

    $scope.covered = true;
    $scope.ticket = ticket;
    $scope.levelNumber = 1;
    $scope.progressStates = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
    $scope.ticket.progress = $scope.ticket.progress || 0;
    $scope.l$u = logged;

    $uibModalInstance.opened.then(function(){
      $scope.covered = false;
    });

    $scope.close = function () {
      $uibModalInstance.close();
      $scope.covered = false;
    };

    $scope.update = function (data) {
      $scope.covered = true;
      ticketService.update(data).then(function (response) {
        $scope.close();
      });
    };

    $scope.new = function (data) {
      $scope.covered = true;
      ticketService.new(data).then(function (response) {
        $scope.close();
        $rootScope.$broadcast('ticket::change');
      });
    };

    $scope.delete = function (id) {
      $scope.covered = true;
      ticketService.delete(id).then(function (response) {
        $scope.close();
        $rootScope.$broadcast('ticket::change');
      });
    };

    $scope.doEscalation = function (offset) {
      ticketService.doEscalation(ticket, offset, $scope.supportLevelStore);
    };

    $scope.assignToMe = function(){
      ticket.performer = logged.getAccount();
    };

    // this show new modal window and close current
    // but after closed children window we comeback parent
    $scope.showKnowledgeDetail = function(){
      $scope.close();
      knowledgeDetail.open(ticket).closed.then(function(){
        ticketForm.open(ticket);
      });
    };

    $scope.onRead = function($files){
      $scope.covered = true;
    };

    $scope.onCompete = function($files){
      $scope.covered = false;
    };

    // updaters
    function updateContractorStore() {
      contractorService.list().then(function (response) {
        $scope.contractorStore = response;
      });
    }

    function updateInitiatorStore() {
      uaService.listAccount().then(function (response) {
        $scope.initiatorStore = response;
      });
    }

    function updatePerformerStore() {
      agentPerformerService.listAccount().then(function (response) {
        $scope.performerStore = response;
      });
    }

    function setTicketLevelSupport(store) {
      if (ticket.supportLevel)
        return;

      store.filter(function (level) {
        return level.number === $scope.levelNumber;
      }).forEach(function (level) {
        ticket.supportLevel = level;
      });
    }

    function updateSupportLevelStore() {
      supportLevelService.list().then(function (data) {
        setTicketLevelSupport(data);
        $scope.supportLevelStore = data;
      });
    }

    function updateTicketTypeStore(){
      ticketTypeService.list().then(function(response){
        $scope.typeStore = response;
      });
    }

    function updateTicketPriorityStore(){
      ticketPriorityService.list().then(function(response){
        $scope.priorityStore = response;
      });
    }

    updateTicketTypeStore();
    updateTicketPriorityStore();
    updateSupportLevelStore();
    updatePerformerStore();
    updateContractorStore();
    updateInitiatorStore();
  });