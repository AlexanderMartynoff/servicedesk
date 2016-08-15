export default $uibModal => {
  return {
    open: ticket => {
      return $uibModal.open({
        controller: 'TicketFormController',
        resolve: { ticket: ticket },
        size: 'lg',
        backdrop: 'static',
        templateUrl: '/public/application/template/customer/ticket/form/ticket.html'
      });
    }
  };
}