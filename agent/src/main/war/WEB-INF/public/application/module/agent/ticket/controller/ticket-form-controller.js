angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $rootScope, $uibModalInstance,
                                                ticketService, contractorService,
                                                ticket, uaPerformerService, supportLevelService) {

    $scope.covered = true;
    $scope.ticket = ticket;
    $scope.contractorStore = [];
    $scope.performerStore = [];
    $scope.supportLevelStore = [];
    $scope.progressStates = [];
    $scope.levelNumber = 1;

    (function (state, step, limit) {
      while (state <= limit) {
        $scope.progressStates.push(state);
        state += step;
      }
    })(0, 10, 100);

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

    $scope.updatePerformerStore = function () {
      uaPerformerService.listAsUaGlobal().then(function (response) {
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