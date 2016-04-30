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
        angular.module('customer.logged', []).constant('logged', angular.fromJson(response.data));
        bootstrap(['customer.application', 'customer.logged']);
      }catch(e){
        bootstrap(['customer.application']);
        // for info
        $log.info('current user not authorized');
      }
    }, function(){
      bootstrap(['customer.application']);
    });
  });
})(angular, document, window);