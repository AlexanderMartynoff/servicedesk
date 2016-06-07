package com.itsmtools.common.dictionary.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "knowledge")
public class Knowledge {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    @Type(type = "text")
    private String description;

    @Column
    @Type(type = "text")
    private String resolution;

    @ManyToOne
    @JoinColumn(
        name = "author_id",
        referencedColumnName = "id"
    )
    private Account author;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }
}
