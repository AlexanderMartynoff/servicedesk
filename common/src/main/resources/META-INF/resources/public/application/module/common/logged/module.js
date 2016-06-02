angular.module("common.logged", []).factory('logged$user', function (logged$data, UaCommonStub) {

  // user model with all business authorization logic
  function User(){
    var data = this.data = prepare$logged$data(logged$data);

    this.getId = function(){
      return data.account.id;
    };

    this.getAccount = function(){
      return data.account;
    };

    // admin logic
    this.isAdmin = function(){
      return data.agentAdmin.enable;
    };

    this.isOnlyAdmin = function(){};

    // performer logic
    this.isPerformer = function(){
      return data.agentPerformer.enable;
    };

    this.isOnlyPerformer = function(){
      return data.agentPerformer.enable && !data.agentOperator.enable && !data.agentManager.enable;
    };

    // operator logic
    this.isOperator = function(){};
    this.isOnlyOperator = function(){};

    // manager logic
    this.isManager = function(){
      return data.agentManager.enable;
    };

    // common logic
    this.isCanEscalation = function(toNumber, limitOfNumber){

    };

    this.isCanEditTicket = function(){
      return data.agentOperator.enable || data.agentManager.enable;
    };

    this.isServiceDeskPersonal = function(){
      return data.agentOperator.enable || data.agentManager.enable || data.agentPerformer.enable;
    };
  }

  // helpers
  function prepare$logged$data(logged$data){
    logged$data.account = logged$data.account || new UaCommonStub();
    logged$data.agent = logged$data.agent || new UaCommonStub();
    logged$data.agentAdmin = logged$data.agentAdmin || new UaCommonStub();
    logged$data.agentManager = logged$data.agentManager || new UaCommonStub();
    logged$data.agentOperator = logged$data.agentOperator || new UaCommonStub();
    logged$data.agentPerformer = logged$data.agentPerformer || new UaCommonStub();
    logged$data.customerCustomer = logged$data.customerCustomer || new UaCommonStub();
    logged$data.customer = logged$data.customer || new UaCommonStub();

    return logged$data;
  }

  return new User();
});