package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "it_service_group")
public class ItServiceGroup {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String description;
}
