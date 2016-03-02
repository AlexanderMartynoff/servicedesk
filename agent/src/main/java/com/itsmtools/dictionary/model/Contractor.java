package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Contractor {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String shortName;

    @Column
    public String fullName;

    @Column
    public Integer uniqueName;

    @Column
    public String metaInfo;
}
