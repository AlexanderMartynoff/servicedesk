package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentOperator;
import com.itsmtools.common.dictionary.model.ProfileAgentPerformer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentPerformerService implements ProfileService<ProfileAgentPerformer, Account> {

    @Autowired
    SessionFactory factory;

    public Optional<ProfileAgentPerformer> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentPerformer> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileAgentPerformer> instance = session.createCriteria(ProfileAgentPerformer.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();
        return instance;
    }

    public void save(ProfileAgentPerformer entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(ProfileAgentPerformer input) {
        Session session = factory.openSession();
        ProfileAgentPerformer profile = (ProfileAgentPerformer) session.get(
            ProfileAgentPerformer.class,
            input.getId()
        );

        profile.setSupportLevels(input.getSupportLevels());
        profile.setEnable(input.getEnable());

        session.update(profile);
        session.flush();
        session.close();
    }

    public List<ProfileAgentPerformer> list() {
        return null;
    }
}
