angular.module("backend.ticket")
    .controller("DateTicketController", function ($scope) {
        $scope.opened = false;

        $scope.open = function ($event) {
            $scope.opened = true;
        };
    });