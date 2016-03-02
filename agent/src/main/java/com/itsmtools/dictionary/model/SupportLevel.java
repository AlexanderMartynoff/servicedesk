package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class SupportLevel {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public Integer number;

    @Column
    public String title;

    @Column
    public String description;
}
