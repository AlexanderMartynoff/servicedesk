package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProfileAgentManagerService implements ProfileService<ProfileAgentManager, Account> {

    @Autowired
    Session session;

    public Optional<ProfileAgentManager> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentManager> getByAccount(Account account) {
        session.clear();
        return session.createCriteria(ProfileAgentManager.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileAgentManager entity) {
        session.clear();
        session.save(entity);
        session.flush();
    }

    public void update(ProfileAgentManager entity) {
        ProfileAgentManager profileRoleAgentManager = (ProfileAgentManager) session.get(ProfileAgentManager.class, entity.getId());
        profileRoleAgentManager.setSupportLevels(entity.getSupportLevels());
        profileRoleAgentManager.setEnable(entity.getEnable());

        session.clear();
        session.save(profileRoleAgentManager);
        session.flush();
    }

    public List<ProfileAgentManager> list() {
        return null;
    }
}
