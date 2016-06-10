package com.itsmtools.common.dictionary.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "profile_agent_manager")
public class ProfileAgentManager implements Profile {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private Boolean enable;

    @OneToOne
    @JoinColumn(
        name = "account_id",
        referencedColumnName = "id"
    )
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "profile_role_agent_manager_support_level",
        joinColumns = @JoinColumn(name = "profile_role_agent_manager_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "support_level_id", referencedColumnName = "id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private Set<SupportLevel> supportLevels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<SupportLevel> getSupportLevels() {
        return supportLevels;
    }

    public void setSupportLevels(Set<SupportLevel> supportLevels) {
        this.supportLevels = supportLevels;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
