package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "priority")
public class TicketPriority {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String description;
}
