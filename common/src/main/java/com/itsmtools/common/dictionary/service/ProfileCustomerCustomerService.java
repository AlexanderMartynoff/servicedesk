package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentPerformer;
import com.itsmtools.common.dictionary.model.ProfileCustomerCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileCustomerCustomerService implements ProfileService<ProfileCustomerCustomer, Account> {

    @Autowired
    private SessionFactory factory;

    public Optional<ProfileCustomerCustomer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileCustomerCustomer> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileCustomerCustomer> instance = session.createCriteria(ProfileCustomerCustomer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();
        return instance;
    }

    public void save(ProfileCustomerCustomer entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(ProfileCustomerCustomer request) {
        Session session = factory.openSession();
        ProfileCustomerCustomer record = (ProfileCustomerCustomer) session.get(
            ProfileCustomerCustomer.class,
            request.getId()
        );
        record.setEnable(request.getEnable());
        session.update(record);
        session.flush();
        session.close();
    }

    public List<ProfileCustomerCustomer> list() {
        return null;
    }
}
