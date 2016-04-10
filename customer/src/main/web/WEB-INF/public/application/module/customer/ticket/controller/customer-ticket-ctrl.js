angular.module('customer.ticket')
  .controller('CustomerTicketCtrl', function(ticketService){
    ticketService.list();
  });