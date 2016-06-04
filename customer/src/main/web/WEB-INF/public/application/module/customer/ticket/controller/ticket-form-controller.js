angular.module('customer.ticket')
  .controller('TicketFormController', function($scope, $uibModalInstance, $rootScope,
                                               ticket, ticketService, logged$user){

    $scope.covered = false;
    $scope.ticket = ticket;
    $scope.customer = logged$user.data.customer;
    $scope.ticket.contractor = $scope.customer.contractor;

    $scope.close = function(){
      $uibModalInstance.close();
    };

    $scope.new = function(data){
      data.initiator = logged$user.getAccount();

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