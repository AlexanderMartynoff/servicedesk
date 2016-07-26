export default function () {
  return function (){
    this.account = {
      enable: true
    };
    this.agent = null;
    this.customer = null;
    this.agentAdmin = null;
    this.agentManager = null;
    this.agentOperator = null;
    this.agentPerformer = null;
    this.customerCustomer = null;
  }
}