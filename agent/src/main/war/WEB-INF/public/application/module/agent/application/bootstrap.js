(function(angular, document, window){
  angular.element(document).ready(function(event){
    var injector, $http, $log, logged;

    function bootstrap (modules){
      angular.bootstrap(document, modules);
    }

    injector = angular.injector(['ng']);

    $http = injector.get('$http');
    $log = injector.get('$log');

    $http.get('/logged', {}).then(function(response){
      try{

        logged = angular.extend(angular.fromJson(response.data), {
          isJustPerformer: function(){
            this.agentPerformer = this.agentPerformer || {};
            this.agentOperator = this.agentOperator || {};
            this.agentManager = this.agentManager || {};

            return this.agentPerformer.enable && !this.agentOperator.enable && !this.agentManager.enable;
          },

          isAdmin: function(){
            this.agentAdmin = this.agentAdmin || {};

            return this.agentAdmin.enable;
          }
        });

        angular.module('backend.logged', []).constant('logged', logged);
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