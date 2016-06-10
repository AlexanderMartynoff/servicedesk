package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileCustomerService implements ProfileService<ProfileCustomer, Account> {

    @Autowired
    SessionFactory factory;

    public Optional<ProfileCustomer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileCustomer> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileCustomer> instance = session.createCriteria(ProfileCustomer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();

        return instance;
    }

    public void save(ProfileCustomer entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(ProfileCustomer entity) {
        Session session = factory.openSession();
        ProfileCustomer profile  = (ProfileCustomer) session.get(ProfileCustomer.class, entity.getId());

        profile.setContractor(entity.getContractor());
        profile.setEnable(entity.getEnable());
        profile.setPosition(entity.getPosition());

        session.update(profile);
        session.flush();
        session.close();
    }

    public List<ProfileCustomer> list() {
        return null;
    }
}
