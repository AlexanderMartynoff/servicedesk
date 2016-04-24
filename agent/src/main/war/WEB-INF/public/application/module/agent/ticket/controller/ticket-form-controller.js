angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $rootScope, $uibModalInstance,
                                                ticketService, contractorService,
                                                ticket, uaPerformerService,
                                                supportLevelService, TicketSupportLevelModel) {


    $scope.covered = true;
    $scope.ticket = ticket;
    $scope.contractorStore = [];
    $scope.performerStore = [];
    $scope.supportLevelStore = [];
    $scope.progressStates = [];

    (function(state, step, limit){
      while(state <= limit){
        $scope.progressStates.push(state);
        state += step;
      }
    })(0, 10, 100);

    if(!ticket.supportLevel){
      ticket.supportLevel = new TicketSupportLevelModel();
    }

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

    $scope.updateContractorStore = function(){
      contractorService.list().then(function(response){
        $scope.contractorStore = response;
      });
    };

    $scope.updatePerformerStore = function(){
      uaPerformerService.listAsUaGlobal().then(function(response){
        $scope.performerStore = response;
      });
    };

    $scope.updateSupportLevelStore = function(){
      supportLevelService.list().then(function(data){
        $scope.supportLevelStore = data;
      });
    };

    $scope.updateSupportLevelStore();
    $scope.updatePerformerStore();
    $scope.updateContractorStore();
  });