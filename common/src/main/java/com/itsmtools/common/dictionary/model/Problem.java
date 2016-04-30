package com.itsmtools.common.dictionary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Problem {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private Integer dateOpen;

    @Column
    private Integer dateClose;

    @Column
    private Integer authorId;

    @Column
    private Integer performerId;

    @Column
    private String description;

    @Column
    private String resolution;

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

    public Integer getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Integer dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Integer getDateClose() {
        return dateClose;
    }

    public void setDateClose(Integer dateClose) {
        this.dateClose = dateClose;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
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
}
