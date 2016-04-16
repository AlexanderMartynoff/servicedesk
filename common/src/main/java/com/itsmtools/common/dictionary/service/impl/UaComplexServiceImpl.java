package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.*;
import com.itsmtools.common.dictionary.service.spec.UaComplexService;
import com.itsmtools.common.dictionary.service.spec.UaSlaveService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;


@Service
public class UaComplexServiceImpl implements UaComplexService<ComplexUa> {
    @Autowired
    private Session session;
    @Autowired
    private UaSlaveService<UaGlobal> uaGlobalService;
    @Autowired
    private UaSlaveService<UaContextBackend> uaContextBackendService;
    @Autowired
    private UaSlaveService<UaContextFrontend> uaContextFrontendService;
    @Autowired
    private UaSlaveService<UaGroupAdmin> uaGroupAdminService;
    @Autowired
    private UaSlaveService<UaGroupManager> uaGroupManagerService;
    @Autowired
    private UaSlaveService<UaGroupOperator> uaGroupOperatorService;
    @Autowired
    private UaSlaveService<UaGroupPerformer> uaGroupPerformerService;

    @Override
    @SuppressWarnings("unchecked")
    public List<ComplexUa> list() {
        return (List<ComplexUa>) session.createCriteria(UaGlobal.class)
            .list()
            .stream()
            .map((e) -> buildByUaGlobal((UaGlobal) e))
            .collect(toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<ComplexUa> getByLogin(String login) {
        return session.createCriteria(UaGlobal.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst()
            .map((e) -> buildByUaGlobal((UaGlobal) e));
    }

    protected ComplexUa buildByUaGlobal(UaGlobal ua) {
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
    public void save(ComplexUa entity) {

        if (entity.getUaGlobal() == null) {
            throw new NullPointerException();
        }

        Transaction transaction = session.beginTransaction();

        try {
            uaGlobalService.save(entity.getUaGlobal());

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
}
