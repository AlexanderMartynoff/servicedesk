package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;


@Service
public class UaComplexService {
    @Autowired
    private Session session;
    @Autowired
    private UaGlobalService globalService;
    @Autowired
    private UaContextBackendService contextBackendService;
    @Autowired
    private UaContextFrontendService contextFrontendService;
    @Autowired
    private UaGroupAdminService groupAdminService;
    @Autowired
    private UaGroupManagerService groupManagerService;
    @Autowired
    private UaGroupOperatorService groupOperatorService;
    @Autowired
    private UaGroupPerformerService groupPerformerService;

    @SuppressWarnings("unchecked")
    public List<ComplexUa> list() {
        return (List<ComplexUa>) session.createCriteria(UaGlobal.class)
            .list()
            .stream()
            .map((e) -> buildByUaGlobal((UaGlobal) e))
            .collect(toList());
    }

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

        contextBackendService.getByUaGlobal(ua).ifPresent(complexUa::setUaContextBackend);
        contextFrontendService.getByUaGlobal(ua).ifPresent(complexUa::setUaContextFrontend);
        groupAdminService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupAdmin);
        groupManagerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupManager);
        groupManagerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupManager);
        groupOperatorService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupOperator);
        groupPerformerService.getByUaGlobal(ua).ifPresent(complexUa::setUaGroupPerformer);

        return complexUa;
    }

    public void save(ComplexUa entity) {

        if (entity.getUaGlobal() == null) {
            throw new NullPointerException("Global UA must be set");
        }

        Transaction transaction = session.beginTransaction();

        try {
            globalService.save(entity.getUaGlobal());

            if(entity.getUaContextBackend() != null){
                entity.getUaContextBackend().setUaGlobal(entity.getUaGlobal());
                contextBackendService.save(entity.getUaContextBackend());
            }

            if(entity.getUaContextFrontend() != null){
                entity.getUaContextFrontend().setUaGlobal(entity.getUaGlobal());
                contextFrontendService.save(entity.getUaContextFrontend());
            }

            if(entity.getUaGroupAdmin() != null){
                entity.getUaGroupAdmin().setUaGlobal(entity.getUaGlobal());
                groupAdminService.save(entity.getUaGroupAdmin());
            }

            if(entity.getUaGroupManager() != null){
                entity.getUaGroupManager().setUaGlobal(entity.getUaGlobal());
                groupManagerService.save(entity.getUaGroupManager());
            }

            if(entity.getUaGroupOperator() != null){
                entity.getUaGroupOperator().setUaGlobal(entity.getUaGlobal());
                groupOperatorService.save(entity.getUaGroupOperator());
            }

            if(entity.getUaGroupPerformer() != null){
                entity.getUaGroupPerformer().setUaGlobal(entity.getUaGlobal());
                groupPerformerService.save(entity.getUaGroupPerformer());
            }

            transaction.commit();

        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        }
    }
}
