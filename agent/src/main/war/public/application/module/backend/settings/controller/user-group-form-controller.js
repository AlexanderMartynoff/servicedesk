angular.module('backend.settings')
  .controller("UserGroupFormController", function ($scope, $http, $uibModalInstance, record, userGroupService) {
    $scope.group = record;

    // just for idea
    var field = {
      uaFieldType: null
    };

    $scope.cancel = function () {
      $scope.covered = false;
      $uibModalInstance.close();
    };

    $scope.addNewField = function () {
      $scope.group.uaGroupFields.push({
        isNew: true,
        id: 3,
        label: 'Новое поле',
        userGroup: {
          id: 2,
          title: 'Клиенты',
          description: 'Клиенты'
        },
        uaFieldType: {
          id: 1,
          title: 'String',
          "description": 'String'
        }
      });
    };

    $scope.commitChanges = function ($event) {
      $scope.covered = true;
      if ($scope.group.id) {
        userGroupService.update($scope.group).then(function(response){
          $scope.covered = false;
          $scope.refreshGroupList();
          $scope.cancel();
        });
      } else {
        $http.post('/user-group/new', $scope.group)
          .then(function (response) {
            $scope.covered = false;
            $scope.refreshGroupList();
            $scope.cancel();
          });
      }
    };

    $scope.refreshGroupList = function () {
      $scope.updateGroupList();
    };

    // scope data
    $scope.userGroupFieldsTypeList = [];
    $scope.group.uaGroupFields = $scope.group.uaGroupFields || [];
  });