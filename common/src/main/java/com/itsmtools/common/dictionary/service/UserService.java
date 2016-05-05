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
public class UserService {
    @Autowired
    private Session session;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProfileAgentService contextBackendService;
    @Autowired
    private ProfileCustomerCustomerService customerService;
    @Autowired
    private ProfileCustomerService contextFrontendService;
    @Autowired
    private ProfileAgentAdminService groupAdminService;
    @Autowired
    private ProfileAgentManagerService groupManagerService;
    @Autowired
    private ProfileAgentOperatorService groupOperatorService;
    @Autowired
    private ProfileAgentPerformerService groupPerformerService;

    @SuppressWarnings("unchecked")
    public List<User> list() {
        return (List<User>) session.createCriteria(Account.class)
            .addOrder(Order.desc("id"))
            .list()
            .stream()
            .map(e -> buildByUaGlobal((Account) e))
            .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public Optional<User> getByLogin(String login) {
        return session.createCriteria(Account.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst()
            .map(e -> buildByUaGlobal((Account) e));
    }

    @SuppressWarnings("unchecked")
    public void save(User complexUa) {
        Map<Profile, ProfileService> uaServiceMap = buildUaServiceMap(complexUa);
        accountService.save(complexUa.getAccount());

        uaServiceMap.entrySet().stream()
            .filter(e -> e.getKey() != null)
            .forEach(e -> {
                e.getKey().setAccount(complexUa.getAccount());
                e.getValue().save(e.getKey());
            });
    }

    @SuppressWarnings("unchecked")
    public void update(User complexUa){
        Map<Profile, ProfileService> uaServiceMap = buildUaServiceMap(complexUa);
        accountService.update(complexUa.getAccount());

        uaServiceMap.entrySet().stream()
            .filter(e -> e.getKey() != null)
            .forEach(e -> {
                if(e.getKey().getId() == null){
                    e.getKey().setAccount(complexUa.getAccount());
                    e.getValue().save(e.getKey());
                }else{
                    e.getValue().update(e.getKey());
                }
            });
    }

    private Map<Profile, ProfileService> buildUaServiceMap(User complexUa){
        Map<Profile, ProfileService> uaServiceMap = new HashMap<>();

        uaServiceMap.put(complexUa.getCustomerCustomer(), customerService);
        uaServiceMap.put(complexUa.getAgent(), contextBackendService);
        uaServiceMap.put(complexUa.getCustomer(), contextFrontendService);
        uaServiceMap.put(complexUa.getAgentAdmin(), groupAdminService);
        uaServiceMap.put(complexUa.getAgentManager(), groupManagerService);
        uaServiceMap.put(complexUa.getAgentOperator(), groupOperatorService);
        uaServiceMap.put(complexUa.getAgentPerformer(), groupPerformerService);

        return uaServiceMap;
    }

    // builder ComplexUa object
    private User buildByUaGlobal(Account global) {
        User complexUa = new User();
        complexUa.setAccount(global);

        customerService.getByAccount(global).ifPresent(complexUa::setCustomerCustomer);
        contextBackendService.getByAccount(global).ifPresent(complexUa::setAgent);
        contextFrontendService.getByAccount(global).ifPresent(complexUa::setCustomer);
        groupAdminService.getByAccount(global).ifPresent(complexUa::setAgentAdmin);
        groupManagerService.getByAccount(global).ifPresent(complexUa::setAgentManager);
        groupManagerService.getByAccount(global).ifPresent(complexUa::setAgentManager);
        groupOperatorService.getByAccount(global).ifPresent(complexUa::setAgentOperator);
        groupPerformerService.getByAccount(global).ifPresent(complexUa::setAgentPerformer);

        return complexUa;
    }
}