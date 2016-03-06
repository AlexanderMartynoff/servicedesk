angular.module("backend.settings")
    .controller("UsersController", function ($scope, userForm, uaService) {
        $scope.users = [{
            uaGlobal: {
                login: null,
                password: null
            }
        }];

        uaService.listComplex().then(function(response){
            $scope.users = response;
        });

        $scope.openUser = function(record){
            userForm.open(record);
        };
    });