package com.itsmtools.common.dictionary.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;


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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "contractor_it_service",
        joinColumns = @JoinColumn(name = "contractor_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "it_service_id", referencedColumnName = "id")
    )
    private Set<Service> services;

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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
