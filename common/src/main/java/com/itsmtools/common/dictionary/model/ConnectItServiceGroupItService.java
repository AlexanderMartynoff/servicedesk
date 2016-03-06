package com.itsmtools.common.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConnectItServiceGroupItService {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public Integer itServiceId;

    @Column
    public Integer itServiceGroup;
}
