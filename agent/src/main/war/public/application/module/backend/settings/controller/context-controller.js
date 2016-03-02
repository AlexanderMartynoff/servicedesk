angular.module("backend.settings")
  .controller("ContextController", function ($scope, $http) {

    var updateContextList = function () {
      $http.get("/context", {}).then(function (response) {
        $scope.contextList = response.data;
      });
    };

    updateContextList();
  });