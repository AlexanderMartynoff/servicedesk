package com.itsmtools.dictionary.dto;


import com.itsmtools.dictionary.model.*;
import java.util.Optional;


public class UaComplex {
    private UaGlobal uaGlobal;
    private Optional<UaContextBackend> uaContextBackend;
    private Optional<UaContextFrontend> uaContextFrontend;
    private Optional<UaGroupAdmin> uaGroupAdmin;
    private Optional<UaGroupManager> uaGroupManager;
    private Optional<UaGroupOperator> uaGroupOperator;
    private Optional<UaGroupPerformer> uaGroupPerformer;

    public UaGlobal getUaGlobal() {
        return uaGlobal;
    }

    public void setUaGlobal(UaGlobal uaGlobal) {
        this.uaGlobal = uaGlobal;
    }

    public Optional<UaContextBackend> getUaContextBackend() {
        return uaContextBackend;
    }

    public void setUaContextBackend(Optional<UaContextBackend> uaContextBackend) {
        this.uaContextBackend = uaContextBackend;
    }

    public Optional<UaContextFrontend> getUaContextFrontend() {
        return uaContextFrontend;
    }

    public void setUaContextFrontend(Optional<UaContextFrontend> uaContextFrontend) {
        this.uaContextFrontend = uaContextFrontend;
    }

    public Optional<UaGroupAdmin> getUaGroupAdmin() {
        return uaGroupAdmin;
    }

    public void setUaGroupAdmin(Optional<UaGroupAdmin> uaGroupAdmin) {
        this.uaGroupAdmin = uaGroupAdmin;
    }

    public Optional<UaGroupManager> getUaGroupManager() {
        return uaGroupManager;
    }

    public void setUaGroupManager(Optional<UaGroupManager> uaGroupManager) {
        this.uaGroupManager = uaGroupManager;
    }

    public Optional<UaGroupOperator> getUaGroupOperator() {
        return uaGroupOperator;
    }

    public void setUaGroupOperator(Optional<UaGroupOperator> uaGroupOperator) {
        this.uaGroupOperator = uaGroupOperator;
    }

    public Optional<UaGroupPerformer> getUaGroupPerformer() {
        return uaGroupPerformer;
    }

    public void setUaGroupPerformer(Optional<UaGroupPerformer> uaGroupPerformer) {
        this.uaGroupPerformer = uaGroupPerformer;
    }
}