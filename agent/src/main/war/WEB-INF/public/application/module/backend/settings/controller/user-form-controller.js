angular.module("backend.settings")
    .controller("UserFormController", function ($scope, $uibModalInstance) {
        $scope.cancel = function(){
            $uibModalInstance.close();
        };
    });