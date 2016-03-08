angular.module("backend.settings")
    .factory("userEditWindow", function ($uibModal) {
        return {
            open: function (record, $scope) {
                $uibModal.open({
                    scope: $scope ? $scope.$new(false) : undefined,
                    controller: 'UserEditWindowController',
                    resolve: {record: record},
                    size: "lg",
                    templateUrl: '/public/application/template/agent/settings/window/user.html'
                });
            }
        }
    });