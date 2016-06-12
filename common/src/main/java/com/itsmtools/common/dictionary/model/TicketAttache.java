package com.itsmtools.common.dictionary.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
@Table(name = "ticket_attache")
public class TicketAttache {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private String mime;


    @Column(length=16777215)
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
        name = "ticket_id",
        referencedColumnName = "id"
    )
    private Ticket ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
