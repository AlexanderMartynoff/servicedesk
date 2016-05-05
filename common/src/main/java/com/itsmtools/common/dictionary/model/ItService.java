package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "it_service")
public class ItService {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String description;
}
