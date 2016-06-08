package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentAdmin;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentAdminService implements ProfileService<ProfileAgentAdmin, Account> {

    @Autowired
    private Session session;

    public Optional<ProfileAgentAdmin> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentAdmin> getByAccount(Account account) {
        session.clear();
        return session.createCriteria(ProfileAgentAdmin.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileAgentAdmin entity) {
        session.clear();
        session.save(entity);
        session.flush();
    }

    public void update(ProfileAgentAdmin entity) {
        ProfileAgentAdmin profileRoleAgentAdmin = (ProfileAgentAdmin) session.get(ProfileAgentAdmin.class, entity.getId());
        profileRoleAgentAdmin.setEnable(entity.getEnable());

        session.clear();
        session.save(profileRoleAgentAdmin);
        session.flush();
    }

    public List<ProfileAgentAdmin> list() {
        return null;
    }
}
