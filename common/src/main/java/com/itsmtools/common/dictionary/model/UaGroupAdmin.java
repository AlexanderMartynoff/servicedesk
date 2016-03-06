package com.itsmtools.common.dictionary.model;

import javax.persistence.*;


@Entity
public class UaGroupAdmin {

    @Id
    @Column
    @GeneratedValue
    public Integer id;

    @OneToOne
    @JoinColumn(
        name = "uaGlobalId",
        referencedColumnName = "id"
    )
    UaGlobal uaGlobal;
}
