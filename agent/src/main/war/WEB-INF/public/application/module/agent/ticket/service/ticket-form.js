angular.module("backend.ticket")
  .factory("ticketForm", function ($uibModal) {
    return {
      open: function (ticket) {
        return $uibModal.open({
          controller: 'TicketFormController',
          resolve: {
            ticket: ticket
          },
          size: 'lg',
          backdrop: 'static',
          templateUrl: '/public/application/template/agent/ticket/form/ticket.html'
        });
      }
    };
  });