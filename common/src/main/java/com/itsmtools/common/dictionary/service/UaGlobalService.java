package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGlobalService implements UserAccountService<UaGlobal, UaGlobal> {

    @Autowired
    private Session session;

    @Override
    public Optional<UaGlobal> get(Integer id) {
        return null;
    }

    @Override
    public Optional<UaGlobal> getByUaGlobal(UaGlobal uaGlobal) {
        return Optional.of(uaGlobal);
    }

    @Override
    public void save(UaGlobal entity) {
        session.save(entity);
        session.flush();
    }

    @Override
    public void update(UaGlobal entity) {
        UaGlobal uaGlobal = (UaGlobal) session.get(UaGlobal.class, entity.getId());

        uaGlobal.setLogin(entity.getLogin());
        uaGlobal.setFirstName(entity.getFirstName());
        uaGlobal.setSecondName(entity.getSecondName());
        uaGlobal.setPassword(entity.getPassword());
        uaGlobal.setEnable(entity.getEnable());

        session.save(uaGlobal);
        session.flush();
    }

    @Override
    public List<UaGlobal> list() {
        return null;
    }
}
