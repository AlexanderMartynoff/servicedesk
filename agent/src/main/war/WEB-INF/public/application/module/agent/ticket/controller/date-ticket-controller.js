export default function ($scope) {
  $scope.opened = false;

  $scope.open = function ($event) {
    $scope.opened = true;
  };
}