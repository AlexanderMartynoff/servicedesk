angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $rootScope, $uibModalInstance,
                                                logged$user, ticketService, contractorService,
                                                ticket, agentPerformerService, uaService, supportLevelService) {

    $scope.covered = true;
    $scope.ticket = ticket;
    $scope.levelNumber = 1;
    $scope.progressStates = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100];


    $scope.isJustPerformer = function(){
      return logged$user.isOnlyPerformer();
    };

    $scope.isHasPerformer = function(){
      return logged$user.isPerformer();
    };

    $uibModalInstance.opened.then(function (reason) {
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

    $scope.updateContractorStore = function () {
      contractorService.list().then(function (response) {
        $scope.contractorStore = response;
      });
    };

    $scope.updateInitiatorStore = function () {
      uaService.listAccount().then(function (response) {
        $scope.initialStore = response;
      });
    };


    $scope.updatePerformerStore = function () {
      agentPerformerService.listAccount().then(function (response) {
        $scope.performerStore = response;
      });
    };

    $scope.setTicketLevelSupport = function (store) {
      if (ticket.supportLevel)
        return;

      store.filter(function (level) {
        return level.number === $scope.levelNumber;
      }).forEach(function (level) {
        ticket.supportLevel = level;
      });

    };

    $scope.updateSupportLevelStore = function () {
      supportLevelService.list().then(function (data) {
        $scope.setTicketLevelSupport(data);
        $scope.supportLevelStore = data;
      });
    };

    $scope.updateSupportLevelStore();
    $scope.updatePerformerStore();
    $scope.updateContractorStore();
  });