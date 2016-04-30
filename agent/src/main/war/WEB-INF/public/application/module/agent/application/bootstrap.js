(function(angular, document, window){
  angular.element(document).ready(function(event){
    var injector, $http, $log, bootstrap, logged;

    bootstrap = function(modules){
      angular.bootstrap(document, modules);
    };

    injector = angular.injector(['ng']);

    $http = injector.get('$http');
    $log = injector.get('$log');

    $http.get('/logged', {}).then(function(response){
      try{
        angular.module('backend.logged', []).constant('logged', angular.fromJson(response.data));
        bootstrap(['backend.application', 'backend.logged']);
      }catch(e){
        bootstrap(['backend.application']);
        // for info
        $log.info('current user not authorized');
      }
    }, function(){
      bootstrap(['backend.application']);
    });
  });
})(angular, document, window);