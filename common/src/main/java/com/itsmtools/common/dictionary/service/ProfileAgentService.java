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
        return Optional.ofNullable((ProfileAgent) session.get(ProfileAgent.class, id));
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

    public void update(ProfileAgent input) {
        ProfileAgent profile = (ProfileAgent) session.get(ProfileAgent.class, input.getId());
        profile.setEnable(input.getEnable());
        profile.setPosition(input.getPosition());
        session.save(profile);
        session.flush();
    }

    public List<ProfileAgent> list() {
        return null;
    }
}
