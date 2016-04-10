package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.*;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UaComplexServiceImpl implements BaseUaMasterService<UaGlobal, ComplexUa> {
    @Autowired
    private Session session;
    @Autowired
    private BaseUaSlaveService<UaContextBackend> uaContextBackendService;
    @Autowired
    private BaseUaSlaveService<UaContextFrontend> uaContextFrontendService;
    @Autowired
    private BaseUaSlaveService<UaGroupAdmin> uaGroupAdminService;
    @Autowired
    private BaseUaSlaveService<UaGroupManager> uaGroupManagerService;
    @Autowired
    private BaseUaSlaveService<UaGroupOperator> uaGroupOperatorService;
    @Autowired
    private BaseUaSlaveService<UaGroupPerformer> uaGroupPerformerService;

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
        return (List<ComplexUa>) session.createCriteria(UaGlobal.class)
            .list()
            .stream()
            .map((e) -> buildComplexByUaGlobal((UaGlobal) e))
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
            .map((e) -> buildComplexByUaGlobal((UaGlobal) e));
    }

    public ComplexUa buildComplexByUaGlobal(UaGlobal ua) {
        ComplexUa complexUa = new ComplexUa();
        complexUa.setUaGlobal(ua);

        uaContextBackendService.getByUaGlobal(ua).ifPresent(complexUa::setUaContextBackend);
        uaContextFrontendService.getByUaGlobal(ua).ifPresent(complexUa::setUaContextFrontend);
        uaGroupAdminService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupAdmin);
        uaGroupManagerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupManager);
        uaGroupManagerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupManager);
        uaGroupOperatorService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupOperator);
        uaGroupPerformerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupPerformer);

        return complexUa;
    }

    @Override
    public void save(UaGlobal entity) {
        session.save(entity);
        session.flush();
    }

    @Override
    public void saveByComplexUa(ComplexUa entity) {

        if (entity.getUaGlobal() == null) {
            throw new NullPointerException();
        }

        Transaction transaction = session.beginTransaction();

        try {
            session.save(entity.getUaGlobal());

            if(entity.getUaContextBackend() != null){
                entity.getUaContextBackend().setUaGlobal(entity.getUaGlobal());
                uaContextBackendService.save(entity.getUaContextBackend());
            }

            if(entity.getUaContextFrontend() != null){
                entity.getUaContextFrontend().setUaGlobal(entity.getUaGlobal());
                uaContextFrontendService.save(entity.getUaContextFrontend());
            }

            if(entity.getUaGroupAdmin() != null){
                entity.getUaGroupAdmin().setUaGlobal(entity.getUaGlobal());
                uaGroupAdminService.save(entity.getUaGroupAdmin());
            }

            if(entity.getUaGroupManager() != null){
                entity.getUaGroupManager().setUaGlobal(entity.getUaGlobal());
                uaGroupManagerService.save(entity.getUaGroupManager());
            }

            if(entity.getUaGroupOperator() != null){
                entity.getUaGroupOperator().setUaGlobal(entity.getUaGlobal());
                uaGroupOperatorService.save(entity.getUaGroupOperator());
            }

            if(entity.getUaGroupPerformer() != null){
                entity.getUaGroupPerformer().setUaGlobal(entity.getUaGlobal());
                uaGroupPerformerService.save(entity.getUaGroupPerformer());
            }

            transaction.commit();

        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void updateByComplexUa(ComplexUa entity) {
        update(entity.getUaGlobal());
    }

    @Override
    public void update(UaGlobal entity) {
        Optional.ofNullable((UaGlobal) session.get(UaGlobal.class, entity.getId()))
            .ifPresent((value) -> {
                value.setFirstName(entity.getFirstName());
                value.setSecondName(entity.getSecondName());
                value.setPassword(entity.getPassword());
                value.setEnable(entity.getEnable());
                session.update(value);
                session.flush();
            });
    }

    @Override
    public List<UaGlobal> list() {
        return null;
    }
}
