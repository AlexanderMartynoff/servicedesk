package com.itsmtools.common.dictionary.model;


import org.hibernate.annotations.Type;
import javax.persistence.*;


@Entity
public class Ticket {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    @Type(type = "text")
    private String title;

    @Column
    private Long dateOpen;

    @Column
    private Long dateClose;

    @Column
    @Type(type = "text")
    private String description;

    @Column
    private Byte progress;

    @ManyToOne
    @JoinColumn(
        name = "consumerId",
        referencedColumnName = "id"
    )
    private UaGlobal consumer;

    @ManyToOne
    @JoinColumn(
        name = "authorId",
        referencedColumnName = "id"
    )
    private UaGlobal author;

    @ManyToOne
    @JoinColumn(
        name = "performerId",
        referencedColumnName = "id"
    )
    private UaGlobal performer;

    @ManyToOne
    @JoinColumn(
        name = "ticketTypeId",
        referencedColumnName = "id"
    )
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(
        name = "itServiceId",
        referencedColumnName = "id"
    )
    private ItService itService;

    @ManyToOne
    @JoinColumn(
        name = "urgencyId",
        referencedColumnName = "id"
    )
    private Urgency urgency;

    @ManyToOne
    @JoinColumn(
        name = "priorityId",
        referencedColumnName = "id"
    )
    private Priority priority;

    @ManyToOne
    @JoinColumn(
        name = "supportLevelId",
        referencedColumnName = "id"
    )
    private SupportLevel supportLevel;

    // getters and setters

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

    public Long getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Long dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Long getDateClose() {
        return dateClose;
    }

    public void setDateClose(Long dateClose) {
        this.dateClose = dateClose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getProgress() {
        return progress;
    }

    public void setProgress(Byte progress) {
        this.progress = progress;
    }

    public UaGlobal getConsumer() {
        return consumer;
    }

    public void setConsumer(UaGlobal consumer) {
        this.consumer = consumer;
    }

    public UaGlobal getAuthor() {
        return author;
    }

    public void setAuthor(UaGlobal author) {
        this.author = author;
    }

    public UaGlobal getPerformer() {
        return performer;
    }

    public void setPerformer(UaGlobal performer) {
        this.performer = performer;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public ItService getItService() {
        return itService;
    }

    public void setItService(ItService itService) {
        this.itService = itService;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public SupportLevel getSupportLevel() {
        return supportLevel;
    }

    public void setSupportLevel(SupportLevel supportLevel) {
        this.supportLevel = supportLevel;
    }
}
