package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("all")
public class Principal extends User {

    private UaGlobal uaGlobal;
    private Optional<UaContextBackend> uaContextBackend;
    private Optional<UaContextFrontend> uaContextFrontend;
    private Optional<UaGroupAdmin> uaGroupAdmin;
    private Optional<UaGroupManager> uaGroupManager;
    private Optional<UaGroupOperator> uaGroupOperator;
    private Optional<UaGroupPerformer> uaGroupPerformer;

    public Principal(UaGlobal uaGlobal,
                     Optional<UaContextBackend> uaContextBackend,
                     Optional<UaContextFrontend> uaContextFrontend, Optional<UaGroupAdmin> uaGroupAdmin,
                     Optional<UaGroupManager> uaGroupManager, Optional<UaGroupOperator> uaGroupOperator,
                     Optional<UaGroupPerformer> uaGroupPerformer,
                     List<SimpleGrantedAuthority> grantedAuthorities) {

        super(uaGlobal.getLogin(), uaGlobal.getPassword(), grantedAuthorities);

        this.uaGlobal = uaGlobal;
        this.uaContextBackend = uaContextBackend;
        this.uaContextFrontend = uaContextFrontend;
        this.uaGroupAdmin = uaGroupAdmin;
        this.uaGroupManager = uaGroupManager;
        this.uaGroupOperator = uaGroupOperator;
        this.uaGroupPerformer = uaGroupPerformer;
    }

    public UaGlobal getUaGlobal() {
        return uaGlobal;
    }

    public Optional<UaContextBackend> getUaContextBackend() {
        return uaContextBackend;
    }

    public Optional<UaContextFrontend> getUaContextFrontend() {
        return uaContextFrontend;
    }

    public Optional<UaGroupAdmin> getUaGroupAdmin() {
        return uaGroupAdmin;
    }

    public Optional<UaGroupManager> getUaGroupManager() {
        return uaGroupManager;
    }

    public Optional<UaGroupOperator> getUaGroupOperator() {
        return uaGroupOperator;
    }

    public Optional<UaGroupPerformer> getUaGroupPerformer() {
        return uaGroupPerformer;
    }
}
