package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentAdminService implements ProfileService<ProfileAgentAdmin, Account> {

    @Autowired
    private SessionFactory factory;

    public Optional<ProfileAgentAdmin> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentAdmin> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileAgentAdmin> instance = session.createCriteria(ProfileAgentAdmin.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();
        return instance;
    }

    public void save(ProfileAgentAdmin entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(ProfileAgentAdmin entity) {
        Session session = factory.openSession();
        ProfileAgentAdmin profileRoleAgentAdmin = (ProfileAgentAdmin) session.get(ProfileAgentAdmin.class, entity.getId());
        profileRoleAgentAdmin.setEnable(entity.getEnable());
        session.save(profileRoleAgentAdmin);
        session.flush();
        session.close();
    }

    public List<ProfileAgentAdmin> list() {
        return null;
    }
}
