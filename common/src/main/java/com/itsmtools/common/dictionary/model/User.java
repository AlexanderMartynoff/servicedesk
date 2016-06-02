package com.itsmtools.common.dictionary.model;


import java.io.Serializable;


public class User implements Serializable{
    private Account account;

    // agent application
    private ProfileAgent agent;
    private ProfileAgentAdmin agentAdmin;
    private ProfileAgentManager agentManager;
    private ProfileAgentOperator agentOperator;
    private ProfileAgentPerformer agentPerformer;

    // customer application
    private ProfileCustomer customer;
    private ProfileCustomerCustomer customerCustomer;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ProfileAgent getAgent() {
        return agent;
    }

    public void setAgent(ProfileAgent agent) {
        this.agent = agent;
    }

    public ProfileCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ProfileCustomer customer) {
        this.customer = customer;
    }

    public ProfileAgentAdmin getAgentAdmin() {
        return agentAdmin;
    }

    public void setAgentAdmin(ProfileAgentAdmin agentAdmin) {
        this.agentAdmin = agentAdmin;
    }

    public ProfileAgentManager getAgentManager() {
        return agentManager;
    }

    public void setAgentManager(ProfileAgentManager agentManager) {
        this.agentManager = agentManager;
    }

    public ProfileAgentOperator getAgentOperator() {
        return agentOperator;
    }

    public void setAgentOperator(ProfileAgentOperator agentOperator) {
        this.agentOperator = agentOperator;
    }

    public ProfileAgentPerformer getAgentPerformer() {
        return agentPerformer;
    }

    public void setAgentPerformer(ProfileAgentPerformer agentPerformer) {
        this.agentPerformer = agentPerformer;
    }

    public ProfileCustomerCustomer getCustomerCustomer() {
        return customerCustomer;
    }

    public void setCustomerCustomer(ProfileCustomerCustomer customerCustomer) {
        this.customerCustomer = customerCustomer;
    }
}
