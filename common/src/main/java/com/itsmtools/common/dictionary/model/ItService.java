package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "it_service")
public class ItService {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

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
}
