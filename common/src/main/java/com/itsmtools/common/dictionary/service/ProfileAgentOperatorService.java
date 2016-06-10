package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentOperator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentOperatorService implements ProfileService<ProfileAgentOperator, Account> {

    @Autowired
    SessionFactory factory;

    public Optional<ProfileAgentOperator> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentOperator> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileAgentOperator> instance = session.createCriteria(ProfileAgentOperator.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();
        return instance;
    }

    public void save(ProfileAgentOperator input) {
        Session session = factory.openSession();
        session.save(input);
        session.flush();
        session.close();
    }

    public void update(ProfileAgentOperator input) {
        Session session = factory.openSession();

        ProfileAgentOperator profile = (ProfileAgentOperator) session.get(ProfileAgentOperator.class, input.getId());
        profile.setEnable(input.getEnable());
        session.update(profile);
        session.flush();
        session.close();
    }

    public List<ProfileAgentOperator> list() {
        return null;
    }
}
