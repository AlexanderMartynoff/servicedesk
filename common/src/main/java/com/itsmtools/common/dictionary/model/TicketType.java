package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String description;
}
