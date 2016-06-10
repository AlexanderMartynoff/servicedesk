package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentService implements ProfileService<ProfileAgent, Account> {

    @Autowired
    private SessionFactory factory;

    public Optional<ProfileAgent> get(Integer id) {
        Session session = factory.openSession();
        ProfileAgent instance = (ProfileAgent) session.get(ProfileAgent.class, id);
        session.close();
        return Optional.ofNullable(instance);
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgent> getByAccount(Account account) {
        Session session = factory.openSession();
        Optional<ProfileAgent> instance = session.createCriteria(ProfileAgent.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst();
        session.close();

        return instance;
    }

    public void save(ProfileAgent entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(ProfileAgent input) {
        Session session = factory.openSession();
        ProfileAgent profile = (ProfileAgent) session.get(ProfileAgent.class, input.getId());
        profile.setEnable(input.getEnable());
        profile.setPosition(input.getPosition());
        session.update(profile);
        session.flush();
        session.close();
    }

    public List<ProfileAgent> list() {
        return null;
    }
}
