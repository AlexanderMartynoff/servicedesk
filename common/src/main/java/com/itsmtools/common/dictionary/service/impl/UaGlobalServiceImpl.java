package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.dto.ComplexUa;
import com.itsmtools.common.dictionary.model.*;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UaGlobalServiceImpl implements BaseUaMasterService<UaGlobal, ComplexUa> {
    @Autowired
    Session session;
    @Autowired
    BaseUaSlaveService<UaContextBackend> uaContextBackendService;
    @Autowired
    BaseUaSlaveService<UaContextFrontend> uaContextFrontendService;
    @Autowired
    BaseUaSlaveService<UaGroupAdmin> uaGroupAdminService;
    @Autowired
    BaseUaSlaveService<UaGroupManager> uaGroupManagerService;
    @Autowired
    BaseUaSlaveService<UaGroupOperator> uaGroupOperatorService;
    @Autowired
    BaseUaSlaveService<UaGroupPerformer> uaGroupPerformerService;

    @Override
    public Optional<UaGlobal> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGlobal> getByLogin(String login) {
        return session.createCriteria(UaGlobal.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ComplexUa> listComplex() {
        return (List<ComplexUa>)session.createCriteria(UaGlobal.class)
            .list()
            .stream()
            .map((uaGlobal) -> buildByUaGlobal((UaGlobal) uaGlobal))
            .collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<ComplexUa> getComplexByUaGlobalLogin(String login) {
        return session.createCriteria(UaGlobal.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst()
            .map((e) -> buildByUaGlobal((UaGlobal)e));
    }

    public ComplexUa buildByUaGlobal(UaGlobal global){
        ComplexUa complexUa = new ComplexUa();
        complexUa.setUaGlobal(global);
        uaContextBackendService.getByUaGlobal(global).ifPresent(complexUa::setUaContextBackend);
        uaContextFrontendService.getByUaGlobal(global).ifPresent(complexUa::setUaContextFrontend);
        uaGroupAdminService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupAdmin);
        uaGroupManagerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupManager);
        uaGroupManagerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupManager);
        uaGroupOperatorService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupOperator);
        uaGroupPerformerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupPerformer);
        return complexUa;
    }

    @Override
    public void save(UaGlobal entity) {}

    @Override
    public void update(UaGlobal entity) {}

    @Override
    public List<UaGlobal> list() {
        return null;
    }

}
