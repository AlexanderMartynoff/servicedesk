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
        return session.createCriteria(ProfileCustomer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileCustomer entity) {
        session.save(entity);
        session.flush();
    }

    public void update(ProfileCustomer entity) {
        ProfileCustomer profile  = (ProfileCustomer) session.get(ProfileCustomer.class, entity.getId());
        profile.setContractor(entity.getContractor());
        profile.setEnable(entity.getEnable());
        profile.setPosition(entity.getPosition());

        session.save(profile);
        session.flush();
    }

    public List<ProfileCustomer> list() {
        return null;
    }
}
