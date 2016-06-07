package com.itsmtools.common.dictionary.model;


import org.hibernate.annotations.Type;
import javax.persistence.*;


@Entity
@Table(name = "ticket_comment")
public class TicketComment {
    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    @Type(type="text")
    public String topic;

    @ManyToOne
    @JoinColumn(
        name = "author_id",
        referencedColumnName = "id"
    )
    private Account author;

    @Column
    @Type(type="text")
    public String text;

    @ManyToOne
    @JoinColumn(
        name = "ticket_id",
        referencedColumnName = "id"
    )
    public Ticket ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
