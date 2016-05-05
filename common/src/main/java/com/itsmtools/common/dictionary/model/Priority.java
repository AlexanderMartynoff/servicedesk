package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String description;
}
