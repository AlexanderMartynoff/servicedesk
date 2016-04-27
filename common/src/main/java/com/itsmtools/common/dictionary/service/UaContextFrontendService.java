package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaContextFrontend;
import com.itsmtools.common.dictionary.model.UaGlobal;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaContextFrontendService implements UserAccountService<UaContextFrontend, UaGlobal> {

    @Autowired
    Session session;

    public Optional<UaContextFrontend> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaContextFrontend> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaContextFrontend.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaContextFrontend entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaContextFrontend entity) {
        UaContextFrontend ua  = (UaContextFrontend) session.get(UaContextFrontend.class, entity.getId());
        ua.setContractor(entity.getContractor());
        ua.setEnable(entity.getEnable());
        ua.setPosition(entity.getPosition());

        session.save(ua);
        session.flush();
    }

    public List<UaContextFrontend> list() {
        return null;
    }
}
