angular.module('customer.ticket')
  .controller('TicketFormController', function($scope, $uibModalInstance, $rootScope, ticket, ticketService){

    $scope.covered = false;
    $scope.ticket = ticket;

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.new = function(data){
      $scope.covered = true;
      ticketService.new(data).then(function(response){
        $scope.covered = false;
        $scope.close();
        $rootScope.$broadcast("ticket::change");
      });
    };

    $scope.update = function(data){
      $scope.covered = true;
      ticketService.update(data).then(function(response){
        $scope.close();
        $scope.covered = false;
      });
    };
  });