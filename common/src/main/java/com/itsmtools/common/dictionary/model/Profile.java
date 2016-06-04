package com.itsmtools.common.dictionary.model;


import java.io.Serializable;


public interface Profile extends Serializable {
    Integer getId();
    Account getAccount();
    Boolean getEnable();
    void setAccount(Account account);
}
