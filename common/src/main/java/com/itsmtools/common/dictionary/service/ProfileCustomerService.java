package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileCustomer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileCustomerService implements ProfileService<ProfileCustomer, Account> {

    @Autowired
    Session session;

    public Optional<ProfileCustomer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileCustomer> getByAccount(Account account) {
        session.clear();
        return session.createCriteria(ProfileCustomer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileCustomer entity) {
        session.clear();
        session.save(entity);
        session.flush();
    }

    public void update(ProfileCustomer entity) {
        ProfileCustomer ua  = (ProfileCustomer) session.get(ProfileCustomer.class, entity.getId());
        ua.setContractor(entity.getContractor());
        ua.setEnable(entity.getEnable());
        ua.setPosition(entity.getPosition());

        session.clear();
        session.save(ua);
        session.flush();
    }

    public List<ProfileCustomer> list() {
        return null;
    }
}
