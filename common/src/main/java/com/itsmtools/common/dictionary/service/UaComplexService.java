package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


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
            .addOrder(Order.desc("id"))
            .list()
            .stream()
            .map((e) -> buildByUaGlobal((UaGlobal) e))
            .collect(Collectors.toList());
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

    @SuppressWarnings("unchecked")
    public void save(ComplexUa complexUa) {
        Map<SlaveUserAccount, UserAccountService> uaServiceMap = buildUaServiceMap(complexUa);

        Transaction transaction = session.beginTransaction();

        try {
            // global UA is another
            globalService.save(complexUa.getUaGlobal());

            uaServiceMap.entrySet()
                .stream()
                .filter((e) -> e.getKey() != null)
                .forEach((e) -> {
                    e.getKey().setUaGlobal(complexUa.getUaGlobal());
                    e.getValue().save(e.getKey());
                });

            transaction.commit();

        } catch (RuntimeException e) {
            transaction.rollback();
            throw e;
        }
    }

    private Map<SlaveUserAccount, UserAccountService> buildUaServiceMap(ComplexUa complexUa){
        Map<SlaveUserAccount, UserAccountService> uaServiceMap = new HashMap<>();

        uaServiceMap.put(complexUa.getUaContextBackend(), contextBackendService);
        uaServiceMap.put(complexUa.getUaContextFrontend(), contextFrontendService);
        uaServiceMap.put(complexUa.getUaGroupAdmin(), groupAdminService);
        uaServiceMap.put(complexUa.getUaGroupManager(), groupManagerService);
        uaServiceMap.put(complexUa.getUaGroupOperator(), groupOperatorService);
        uaServiceMap.put(complexUa.getUaGroupPerformer(), groupPerformerService);

        return uaServiceMap;
    }

    // builder ComplexUa object
    private ComplexUa buildByUaGlobal(UaGlobal ua) {
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
}