package com.itsmtools.common.dictionary.model;


import javax.persistence.*;


@Entity
@Table(name = "profile_agent_operator")
public class ProfileAgentOperator implements Profile {

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
