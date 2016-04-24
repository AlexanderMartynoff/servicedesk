angular.module('customer.ticket')
  .controller('TicketFormController', function($scope, ticket){
    $scope.ticket = ticket;
    $scope.ticket.supportLevelId = 1;
  });