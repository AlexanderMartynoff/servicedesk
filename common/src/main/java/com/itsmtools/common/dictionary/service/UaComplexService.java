package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @SuppressWarnings("unchecked")
    public void save(ComplexUa complexUa) {
        Map<SlaveUserAccount, UserAccountService<SlaveUserAccount, UaGlobal>> map = new HashMap<>();

        map.put(complexUa.getUaContextBackend(), (UserAccountService) contextBackendService);
        map.put(complexUa.getUaContextFrontend(), (UserAccountService) contextFrontendService);
        map.put(complexUa.getUaGroupAdmin(), (UserAccountService) groupAdminService);
        map.put(complexUa.getUaGroupManager(), (UserAccountService) groupManagerService);
        map.put(complexUa.getUaGroupOperator(), (UserAccountService) groupOperatorService);
        map.put(complexUa.getUaGroupPerformer(), (UserAccountService) groupPerformerService);

        Transaction transaction = session.beginTransaction();

        try {
            globalService.save(complexUa.getUaGlobal());
            map.entrySet()
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
