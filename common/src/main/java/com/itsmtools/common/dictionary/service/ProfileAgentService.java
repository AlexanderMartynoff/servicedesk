package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgent;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentService implements ProfileService<ProfileAgent, Account> {

    @Autowired
    private Session session;

    public Optional<ProfileAgent> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgent> getByAccount(Account account) {
        return session.createCriteria(ProfileAgent.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileAgent entity) {
        session.save(entity);
        session.flush();
    }

    public void update(ProfileAgent entity) {
        ProfileAgent ua = (ProfileAgent) session.get(ProfileAgent.class, entity.getId());
        ua.setEnable(entity.getEnable());
        ua.setPosition(entity.getPosition());
        session.save(ua);
        session.flush();
    }

    public List<ProfileAgent> list() {
        return null;
    }
}
