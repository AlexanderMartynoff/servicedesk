angular.module("backend.ticket")
    .factory("ticketForm", function ($uibModal) {
        return {
            open: function (ticket, $scope) {
                $uibModal.open({
                    scope: $scope,
                    controller: 'TicketFormController',
                    resolve: {record: ticket},
                    size: 'lg',
                    backdrop: 'static',
                    templateUrl: '/public/application/template/agent/ticket/form/ticket.html'
                });
            }
        };
    });