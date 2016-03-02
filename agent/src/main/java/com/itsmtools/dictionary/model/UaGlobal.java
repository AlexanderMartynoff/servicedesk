package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UaGlobal {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String login;

    @Column
    public String password;

    public UaGlobal(String login, String password){
        this.login = login;
        this.password = password;
    }

    public UaGlobal(){}
}
