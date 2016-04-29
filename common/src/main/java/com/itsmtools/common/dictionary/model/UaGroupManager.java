package com.itsmtools.common.dictionary.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class UaGroupManager implements SlaveUserAccount{

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ConcatUaGroupManagerSupportLevels",
        joinColumns = @JoinColumn(name = "uaGroupManagerId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "supportLevelId", referencedColumnName = "id")
    )
    private Set<SupportLevel> supportLevels;

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

    public Set<SupportLevel> getSupportLevels() {
        return supportLevels;
    }

    public void setSupportLevels(Set<SupportLevel> supportLevels) {
        this.supportLevels = supportLevels;
    }
}
