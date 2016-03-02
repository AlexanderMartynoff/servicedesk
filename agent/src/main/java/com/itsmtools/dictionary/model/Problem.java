package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Problem {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public Integer dateOpen;

    @Column
    public Integer dateClose;

    @Column
    public Integer authorId;

    @Column
    public Integer performerId;

    @Column
    public String description;

    @Column
    public String resolution;
}
