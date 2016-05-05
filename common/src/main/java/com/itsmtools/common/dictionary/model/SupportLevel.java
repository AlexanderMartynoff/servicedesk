package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "support_level")
public class SupportLevel {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @Column
    public Integer number;

    @Column
    public String title;

    @Column
    public String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
