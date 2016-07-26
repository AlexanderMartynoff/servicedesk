import angular from 'angular';


export default (applicationModule) => {

  angular.element(document).ready(function () {
    var injector = angular.injector(['ng']),
      $http = injector.get('$http'),
      $q = injector.get('$q'),
      loggedPromise;

    // logged
    loggedPromise = $http.get('/logged', {}).then(function (response) {
      // register logged data
      angular.module('$$bootstrap', []).factory('loggedData', function () {
        return angular.fromJson(response.data);
      });
    });

    // when all our promises is resolve
    $q.all([loggedPromise]).then(function () {
      angular.bootstrap(window.document, [applicationModule, '$$bootstrap']);
    })
  });
};
