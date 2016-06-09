package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileCustomerCustomer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileCustomerCustomerService implements ProfileService<ProfileCustomerCustomer, Account> {

    @Autowired
    private Session session;

    public Optional<ProfileCustomerCustomer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileCustomerCustomer> getByAccount(Account account) {

        return session.createCriteria(ProfileCustomerCustomer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileCustomerCustomer entity) {

        session.save(entity);
        session.flush();
    }

    public void update(ProfileCustomerCustomer request) {
        ProfileCustomerCustomer record = (ProfileCustomerCustomer) session.get(ProfileCustomerCustomer.class, request.getId());
        record.setEnable(request.getEnable());

        session.save(record);
        session.flush();
    }

    public List<ProfileCustomerCustomer> list() {
        return null;
    }
}
