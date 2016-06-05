angular.module("common.logged", []).factory('logged$user', function (logged$data, UaCommonStub) {

  // user model with all business authorization logic
  function User(){
    var data = this.data = logged$data;

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
    this.isOperator = function(){
      return data.agentOperator.enable;
    };
    this.isOnlyOperator = function(){};

    // manager logic
    this.isManager = function(){
      return data.agentManager.enable;
    };

    // common logic
    this.isCanEscalation = function(ticket, direction, limitOfNumber){
      if(!ticket.supportLevel){
        return false;
      }
      if(direction > 0){
        return (ticket.supportLevel.number < limitOfNumber) && this.isCanEditTicket();
      } else if (direction < 0){
        return (ticket.supportLevel.number > 1) && this.isCanEditTicket();
      }
    };

    this.isCanAssignToMe = function(ticket){
      return (data.agentOperator.enable || data.agentOperator.enable) && data.agentPerformer.enable;
    };

    this.isCanEditTicket = function(){
      return data.agentOperator.enable || data.agentManager.enable;
    };

    this.isCanSetTicketProgress  = function(ticket){
      if(!(ticket.performer && ticket.performer.id)) {
        return false;
      }
      return this.isPerformer() && (ticket.performer.id == this.getAccount().id);
    };

    this.isServiceDeskPersonal = function(){
      return data.agentOperator.enable || data.agentManager.enable || data.agentPerformer.enable;
    };

    this.isCanFilterLine = function(){
      return data.agentOperator.enable || data.agentManager.enable;
    };
  }

  return new User();
});