package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentPerformer;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentPerformerService implements ProfileService<ProfileAgentPerformer, Account> {

    @Autowired
    Session session;

    public Optional<ProfileAgentPerformer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentPerformer> getByAccount(Account account) {
        return session.createCriteria(ProfileAgentPerformer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
    }

    public void save(ProfileAgentPerformer entity) {
        session.save(entity);
        session.flush();
    }

    public void update(ProfileAgentPerformer input) {
        ProfileAgentPerformer profile = (ProfileAgentPerformer) session.get(
            ProfileAgentPerformer.class,
            input.getId()
        );

        profile.setSupportLevels(input.getSupportLevels());
        profile.setEnable(input.getEnable());

        session.save(profile);
        session.flush();
    }

    public List<ProfileAgentPerformer> list() {
        return null;
    }
}