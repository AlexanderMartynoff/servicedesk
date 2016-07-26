export default ($scope, $window, authentication) => {
  /** @namespace response.data.redirectUrl */

  $scope.covered = false;
  $scope.response = {
    status: 200,
    statusText: null
  };

  var responseSuccessHandler = function (response) {
    $scope.response = response;
    if (response.data.redirectUrl) {
      $window.location.href = response.data.redirectUrl;
    }
  };

  var responseFailureHandler = function (response) {
    $scope.covered = false;
    $scope.response = response;
  };

  $scope.submit = function () {
    $scope.covered = true;
    authentication($scope.username, $scope.password).then(responseSuccessHandler, responseFailureHandler);
  };

}