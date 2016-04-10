angular.module("common.ui.xinputfile")
  .controller("XInputFileListController", function ($scope, $uibModalInstance, files) {
    $scope.files = files;

    $scope.cancel = function(){
      $uibModalInstance.close();
    };
  });