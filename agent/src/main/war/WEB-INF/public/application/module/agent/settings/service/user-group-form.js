angular.module("backend.settings")
  .factory("userGroupForm", function ($uibModal) {
    return {
      open: function(record, $scope){
        $uibModal.open({
          scope: $scope.$new(false),
          controller: 'UserGroupFormController',
          resolve: {record: record},
          size: "lg",
          templateUrl: '/public/application/template/agent/settings/form/user-group.html'
        });
      }
    }
  });