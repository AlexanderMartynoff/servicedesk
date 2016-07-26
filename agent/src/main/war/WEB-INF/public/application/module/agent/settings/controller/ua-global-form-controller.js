export default ($scope, UaCommonStub) => {
  $scope.user.uaGlobal = $scope.user.uaGlobal || new UaCommonStub();
  $scope.user.uaGlobal.enable = true;
}