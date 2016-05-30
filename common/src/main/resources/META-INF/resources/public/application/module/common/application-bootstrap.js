function __application_bootstrap(applicationModule, loggedModule) {

  function User() {
    this.agentPerformer = this.agentPerformer || {};
    this.agentManager = this.agentManager || {};
    this.agentOperator = this.agentOperator || {};
    this.agentAdmin = this.agentAdmin || {};
    this.customerCustomer = this.customerCustomer || {};

    this.isHasPerformer = function () {
      return !!this.agentPerformer.enable;
    };

    this.isJustPerformer = function () {
      return this.agentPerformer.enable && !this.agentOperator.enable && !this.agentManager.enable;
    };

    this.isAdmin = function () {
      return this.agentAdmin.enable;
    }
  }

  angular.element(document).ready(function (e) {
    var injector, $http, $log;

    injector = angular.injector(['ng']);
    $http = injector.get('$http');
    $log = injector.get('$log');

    $http.get('/logged', {}).then(function (response) {
      try {
        User.prototype = angular.fromJson(response.data);
        angular.module(loggedModule, []).constant('logged', new User());
        angular.bootstrap(document, [applicationModule, loggedModule]);
      } catch (e) {
        angular.bootstrap(document, [applicationModule]);
        $log.info("user not logged");
      }
    }, function () {
      angular.bootstrap(document, [applicationModule]);
      $log.info("user not logged");
    });
  });
}
