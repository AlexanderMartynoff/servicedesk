package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String shortName;

    @Column
    private String fullName;

    @Column
    private Integer uniqueName;

    @Column
    private String metaInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(Integer uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo) {
        this.metaInfo = metaInfo;
    }
}
