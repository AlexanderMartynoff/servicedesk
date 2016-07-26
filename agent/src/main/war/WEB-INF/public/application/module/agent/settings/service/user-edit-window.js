export default function ($uibModal) {
  return {
    open: function (uaComplex, $scope) {
      $uibModal.open({
        scope: $scope ? $scope.$new(false) : undefined,
        controller: 'UserEditWindowController',
        resolve: {uaComplex: uaComplex},
        size: "lg",
        templateUrl: '/public/application/template/agent/settings/window/user.html'
      });
    }
  }
}