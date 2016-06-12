function _application$bootstrap(applicationModule) {

  function mask(){
    var id = "bootstrap-mask";
    angular.element(document.body).append("<div id=" + id + "></div>");
    return id;
  }

  function unmask (id){
    angular.element(document.getElementById(id)).remove();
  }

  angular.element(document).ready(function () {
    var injector = angular.injector(['ng']),
      $http = injector.get('$http'),
      $q = injector.get('$q'),
      loggedPromise;

    // logged
    loggedPromise = $http.get('/logged', {}).then(function (response) {
      // helpers
      function prepare$logged$data(logged$data) {
        logged$data.account = logged$data.account || {};
        logged$data.agent = logged$data.agent || {};
        logged$data.agentAdmin = logged$data.agentAdmin || {};
        logged$data.agentManager = logged$data.agentManager || {};
        logged$data.agentOperator = logged$data.agentOperator || {};
        logged$data.agentPerformer = logged$data.agentPerformer || {};
        logged$data.customerCustomer = logged$data.customerCustomer || {};
        logged$data.customer = logged$data.customer || {};

        return logged$data;
      }

      // register logged data
      angular.module('$$bootstrap', []).factory('logged$data', function () {
        return prepare$logged$data(angular.fromJson(response.data));
      });
    });

    // when all our promises is resolve
    $q.all([loggedPromise]).then(function () {
      angular.bootstrap(document, [applicationModule, '$$bootstrap']);
    })
  });
}
