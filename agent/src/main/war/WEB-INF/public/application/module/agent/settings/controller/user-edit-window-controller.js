angular.module("backend.settings")
  .controller("UserEditWindowController", function ($scope, $uibModalInstance) {
    var tplRootUrl = '/public/application/template/agent/settings/form/';

    $scope.positions = [
      {name: "Бухгалтер"},
      {name: "Менеджер по продажам"},
      {name: "Технический директор"},
      {name: "Операто ПК"},
      {name: "Товаровед"}
    ];

    $scope.tpl = {
      uaGlobal: tplRootUrl + 'ua-global.html',
      uaContextCustomer: tplRootUrl + 'ua-context-customer.html',
      uaContextAgent: tplRootUrl + 'ua-context-agent.html',
      uaGroupOperator: tplRootUrl + 'ua-group-operator.html',
      uaGroupManager: tplRootUrl + 'ua-group-manager.html',
      uaGroupPerformer: tplRootUrl + 'ua-group-performer.html',
      uaGroupCustomer: tplRootUrl + 'ua-group-customer.html',
      uaGroupAdmin: tplRootUrl + 'ua-group-admin.html'
    };

    $scope.cancel = function () {
      $uibModalInstance.close();
    };
  });