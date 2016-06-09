package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import com.itsmtools.common.dictionary.model.ProfileAgentOperator;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileAgentOperatorService implements ProfileService<ProfileAgentOperator, Account> {

    @Autowired
    Session session;

    public Optional<ProfileAgentOperator> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<ProfileAgentOperator> getByAccount(Account account) {
        return session.createCriteria(ProfileAgentOperator.class)
            .add(Restrictions.eq("account", account))
            .list()
            .stream()
            .findFirst()
            .map(e -> {
                session.refresh(e);
                return e;
            });
    }

    public void save(ProfileAgentOperator input) {
        session.save(input);
        session.flush();
    }

    public void update(ProfileAgentOperator input) {
        ProfileAgentOperator profile = (ProfileAgentOperator) session.get(ProfileAgentOperator.class, input.getId());
        profile.setEnable(input.getEnable());

        session.save(profile);
        session.flush();
    }

    public List<ProfileAgentOperator> list() {
        return null;
    }
}
