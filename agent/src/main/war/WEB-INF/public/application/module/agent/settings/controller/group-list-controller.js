angular.module('backend.settings')
  .controller('GroupListController', function ($scope, userGroupForm, userGroupService) {
    $scope.updateGroupList = function () {
      userGroupService.list().then(function(response){
        $scope.userGroupList = response;
      });
    };

    $scope.openForm = function (group) {
      userGroupForm.open(group, $scope);
    };

    $scope.updateGroupList();
  });