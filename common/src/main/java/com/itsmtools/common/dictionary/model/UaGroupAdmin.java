package com.itsmtools.common.dictionary.model;


import javax.persistence.*;


@Entity
public class UaGroupAdmin implements SlaveUserAccount{

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
}
