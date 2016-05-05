package com.itsmtools.common.dictionary.model;


import javax.persistence.*;


@Entity
@Table(name = "profile_agent_admin")
public class ProfileAgentAdmin implements Profile {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(
        name = "account_id",
        referencedColumnName = "id"
    )
    private Account account;

    @Column
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
