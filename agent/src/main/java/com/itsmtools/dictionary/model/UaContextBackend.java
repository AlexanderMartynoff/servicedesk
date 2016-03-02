package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UaContextBackend {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String login;

    @Column
    public String password;
}
