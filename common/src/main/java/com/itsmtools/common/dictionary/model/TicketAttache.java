package com.itsmtools.common.dictionary.model;


import javax.persistence.*;


@Entity
@Table(name = "ticket_attache")
public class TicketAttache {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String title;

    @Column
    public String mime;

    @Column
    public String base64;
}
