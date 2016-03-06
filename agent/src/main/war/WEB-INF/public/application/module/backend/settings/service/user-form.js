angular.module("backend.settings")
    .factory("userForm", function ($uibModal) {
        return {
            open: function (record, $scope) {
                $uibModal.open({
                    scope: $scope ? $scope.$new(false) : undefined,
                    controller: 'UserFormController',
                    resolve: {record: record},
                    size: "lg",
                    templateUrl: '/public/application/module/backend/settings/template/form/user.html'
                });
            }
        }
    });