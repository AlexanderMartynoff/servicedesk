package com.itsmtools.common.dictionary.dto;

// name convention
// [type][name]

public class User {
    private Account account;
    // user profiles
    private ProfileApplicationAgent applicationAgent;
    private ProfileApplicationCustomer applicationCustomer;
    private ProfileRoleAgentAdmin roleAgentAdmin;
    private ProfileRoleAgentManager roleAgentManager;
    private ProfileRoleAgentOperator roleAgentOperator;
    private ProfileRoleAgentPerformer roleAgentPerformer;
    private ProfileRoleCustomerCustomer roleCustomerCustomer;
}





class Account{}
class ProfileApplicationAgent {}
class ProfileApplicationCustomer {}
class ProfileRoleAgentAdmin {}
class ProfileRoleAgentPerformer {}
class ProfileRoleAgentManager {}
class ProfileRoleAgentOperator {}
class ProfileRoleCustomerCustomer {}