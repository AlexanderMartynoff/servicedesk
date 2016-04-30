package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.*;
import org.hibernate.Session;
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
    private UaGroupCustomerService customerService;
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
            .map(e -> buildByUaGlobal((UaGlobal) e))
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
        globalService.save(complexUa.getUaGlobal());

        uaServiceMap.entrySet().stream()
            .filter(e -> e.getKey() != null)
            .forEach(e -> {
                e.getKey().setUaGlobal(complexUa.getUaGlobal());
                e.getValue().save(e.getKey());
            });
    }

    @SuppressWarnings("unchecked")
    public void update(ComplexUa complexUa){
        Map<SlaveUserAccount, UserAccountService> uaServiceMap = buildUaServiceMap(complexUa);
        globalService.update(complexUa.getUaGlobal());

        uaServiceMap.entrySet().stream()
            .filter(e -> e.getKey() != null)
            .forEach(e -> {
                if(e.getKey().getId() == null){
                    e.getKey().setUaGlobal(complexUa.getUaGlobal());
                    e.getValue().save(e.getKey());
                }else{
                    e.getValue().update(e.getKey());
                }
            });
    }

    private Map<SlaveUserAccount, UserAccountService> buildUaServiceMap(ComplexUa complexUa){
        Map<SlaveUserAccount, UserAccountService> uaServiceMap = new HashMap<>();

        uaServiceMap.put(complexUa.getUaGroupCustomer(), customerService);
        uaServiceMap.put(complexUa.getUaContextBackend(), contextBackendService);
        uaServiceMap.put(complexUa.getUaContextFrontend(), contextFrontendService);
        uaServiceMap.put(complexUa.getUaGroupAdmin(), groupAdminService);
        uaServiceMap.put(complexUa.getUaGroupManager(), groupManagerService);
        uaServiceMap.put(complexUa.getUaGroupOperator(), groupOperatorService);
        uaServiceMap.put(complexUa.getUaGroupPerformer(), groupPerformerService);

        return uaServiceMap;
    }

    // builder ComplexUa object
    private ComplexUa buildByUaGlobal(UaGlobal global) {
        ComplexUa complexUa = new ComplexUa();
        complexUa.setUaGlobal(global);

        customerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupCustomer);
        contextBackendService.getByUaGlobal(global).ifPresent(complexUa::setUaContextBackend);
        contextFrontendService.getByUaGlobal(global).ifPresent(complexUa::setUaContextFrontend);
        groupAdminService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupAdmin);
        groupManagerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupManager);
        groupManagerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupManager);
        groupOperatorService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupOperator);
        groupPerformerService.getByUaGlobal(global).ifPresent(complexUa::setUaGroupPerformer);

        return complexUa;
    }
}