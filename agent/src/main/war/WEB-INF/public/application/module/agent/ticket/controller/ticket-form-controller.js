angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $rootScope, $uibModalInstance,
                                                ticketService, contractorService,
                                                record, uaPerformerService) {
    $scope.covered = true;
    $scope.ticket = record;
    $scope.ticket.supportLevelId = 1;
    $scope.contractorStore = [];
    $scope.performerStore = [];

    $uibModalInstance.opened.then(function (reason) {
      $scope.covered = false;
    });

    $scope.close = function () {
      $uibModalInstance.close();
      $scope.covered = false;
    };

    $scope.update = function (record) {
      $scope.covered = true;
      ticketService.update(record).then(function (response) {
        $scope.close();
      });
    };

    $scope.new = function (record) {
      $scope.covered = true;
      ticketService.new(record).then(function (response) {
        $scope.close();
        $rootScope.$broadcast('onTicketEdit');
      });
    };

    $scope.delete = function (id) {
      $scope.covered = true;
      ticketService.delete(id).then(function (response) {
        $scope.close();
        $rootScope.$broadcast('onTicketEdit');
      });
    };

    $scope.openCalendar = function ($event) {
      $scope.calendarIsOpen = true;
    };

    $scope.doEscalation = function (q) {
      ticketService.doEscalation(record, q);
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

    $scope.updatePerformerStore();
    $scope.updateContractorStore();
  });