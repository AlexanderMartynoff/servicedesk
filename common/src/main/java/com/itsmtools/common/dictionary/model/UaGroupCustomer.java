package com.itsmtools.common.dictionary.model;


import javax.persistence.*;


@Entity
public class UaGroupCustomer implements SlaveUserAccount{

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(
        name = "uaGlobalId",
        referencedColumnName = "id"
    )
    private UaGlobal uaGlobal;

    @Column
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public UaGlobal getUaGlobal() {
        return uaGlobal;
    }

    @Override
    public void setUaGlobal(UaGlobal uaGlobal) {
        this.uaGlobal = uaGlobal;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
