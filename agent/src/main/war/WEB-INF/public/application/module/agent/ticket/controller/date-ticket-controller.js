export default $scope => {
  $scope.opened = false;

  $scope.open = $event => {
    $scope.opened = true;
  };
}