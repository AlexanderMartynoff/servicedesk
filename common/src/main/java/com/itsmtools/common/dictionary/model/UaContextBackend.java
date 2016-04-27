package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
public class UaContextBackend implements SlaveUserAccount{

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private Boolean enable;

    @Column
    String position;

    @OneToOne
    @JoinColumn(
        name = "uaGlobalId",
        referencedColumnName = "id"
    )
    private UaGlobal uaGlobal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UaGlobal getUaGlobal() {
        return uaGlobal;
    }

    public void setUaGlobal(UaGlobal uaGlobal) {
        this.uaGlobal = uaGlobal;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
