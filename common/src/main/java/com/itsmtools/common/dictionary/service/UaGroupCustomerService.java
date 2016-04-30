package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupCustomer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UaGroupCustomerService implements UserAccountService<UaGroupCustomer, UaGlobal> {

    @Autowired
    private Session session;

    public Optional<UaGroupCustomer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaGroupCustomer> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupCustomer.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaGroupCustomer entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaGroupCustomer request) {
        UaGroupCustomer record = (UaGroupCustomer) session.get(UaGroupCustomer.class, request.getId());
        record.setEnable(request.getEnable());

        session.save(record);
        session.flush();
    }

    public List<UaGroupCustomer> list() {
        return null;
    }
}
