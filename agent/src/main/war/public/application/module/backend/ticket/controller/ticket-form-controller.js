angular.module("backend.ticket")
  .controller("TicketFormController", function ($scope, $uibModalInstance, ticketService, record) {
    $scope.covered = true;
    $scope.ticket = record;
    $scope.ticket.supportLevelId = 1;

    $uibModalInstance.opened.then(function(reason){
      $scope.covered = false;
    });

    $scope.close = function (){
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
        $scope.$parent.updateTicketList();
      });
    };

    $scope.delete = function (id) {
      $scope.covered = true;
      ticketService.delete(id).then(function (response) {
        $scope.close();
        $scope.$parent.updateTicketList();
      });
    };

    $scope.openCalendar = function ($event) {
      $scope.calendarIsOpen = true;
    };

    $scope.doEscalation = function (q) {
      ticketService.doEscalation(record, q);
    };
  });