function __application_bootstrap(applicationModule) {
  angular.element(document).ready(function (e) {
    var $http = angular.injector(['ng']).get('$http');

    $http.get('/logged', {}).then(function (response) {
      angular.module('$$bootstrap', []).constant('logged$data', angular.fromJson(response.data));
      angular.bootstrap(document, [applicationModule, '$$bootstrap']);
    });

  });
}
