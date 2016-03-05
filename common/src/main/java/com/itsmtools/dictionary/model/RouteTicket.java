package com.itsmtools.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class RouteTicket {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public String ticketId;

    @Column
    public String supportLevelId;

    @Column
    public Integer timeRecord;

    @Column
    public Integer authorId;
}
