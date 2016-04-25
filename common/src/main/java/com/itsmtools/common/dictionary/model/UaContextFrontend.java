package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
public class UaContextFrontend implements SlaveUserAccount{

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private Boolean enable;

    @ManyToOne
    @JoinColumn(
        name = "uaContractorId",
        referencedColumnName = "id"
    )
    private Contractor contractor;

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public UaGlobal getUaGlobal() {
        return uaGlobal;
    }

    public void setUaGlobal(UaGlobal uaGlobal) {
        this.uaGlobal = uaGlobal;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
