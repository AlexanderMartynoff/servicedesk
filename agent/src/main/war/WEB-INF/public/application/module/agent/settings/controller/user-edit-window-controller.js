angular.module("backend.settings")
  .controller("UserEditWindowController", function ($scope, $rootScope, uaComplex, UaCommonStub,
                                                    $uibModalInstance, UaComplexModel, uaService,
                                                    supportLevelService) {

    var tplRootUrl = '/public/application/template/agent/settings/form/';

    $scope.complexUa = uaComplex || new UaComplexModel();
    $scope.complexUa.uaContextFrontend = $scope.complexUa.uaContextFrontend || new UaCommonStub();
    $scope.complexUa.uaContextBackend = $scope.complexUa.uaContextBackend || new UaCommonStub();
    $scope.complexUa.uaGroupManager = $scope.complexUa.uaGroupManager || new UaCommonStub();
    $scope.covered = false;

    $scope.tpl = {
      uaGlobal: tplRootUrl + 'ua-global.html',
      uaContextCustomer: tplRootUrl + 'ua-context-customer.html',
      uaContextAgent: tplRootUrl + 'ua-context-agent.html',
      uaGroupOperator: tplRootUrl + 'ua-group-operator.html',
      uaGroupManager: tplRootUrl + 'ua-group-manager.html',
      uaGroupPerformer: tplRootUrl + 'ua-group-performer.html',
      uaGroupCustomer: tplRootUrl + 'ua-group-customer.html',
      uaGroupAdmin: tplRootUrl + 'ua-group-admin.html',
      offOnToolbar: tplRootUrl + '../toolbar/off-on.html'
    };

    $scope.cancel = function () {
      $scope.covered = false;
      $uibModalInstance.close();
    };

    $scope.updateSupportLevelStore = function(){
      supportLevelService.list().then(function(response){
        $scope.supportLevelStore = response;
      });
    };

    $scope.save = function(complexUa){
      $scope.covered = true;
      uaService.saveComplex(complexUa).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.update = function(complexUa){
      $scope.covered = true;
      uaService.updateComplex(complexUa).then(function(response){
        $rootScope.$broadcast('ua::change');
        $scope.cancel();
      });
    };

    $scope.updateSupportLevelStore();
  });