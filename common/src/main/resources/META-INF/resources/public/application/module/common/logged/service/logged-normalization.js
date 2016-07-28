export default () => loggedData => {
  loggedData.account = loggedData.account || {};
  loggedData.agent = loggedData.agent || {};
  loggedData.agentAdmin = loggedData.agentAdmin || {};
  loggedData.agentManager = loggedData.agentManager || {};
  loggedData.agentOperator = loggedData.agentOperator || {};
  loggedData.agentPerformer = loggedData.agentPerformer || {};
  loggedData.customerCustomer = loggedData.customerCustomer || {};
  loggedData.customer = loggedData.customer || {};
  return loggedData;
}