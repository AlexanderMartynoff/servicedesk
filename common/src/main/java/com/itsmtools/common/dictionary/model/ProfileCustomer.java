package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
@Table(name = "profile_customer")
public class ProfileCustomer implements Profile {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private Boolean enable;

    @Column
    String position;

    @ManyToOne
    @JoinColumn(
        name = "contractor_id",
        referencedColumnName = "id"
    )
    private Contractor contractor;

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
