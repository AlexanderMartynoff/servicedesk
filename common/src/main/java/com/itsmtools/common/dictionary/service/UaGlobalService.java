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
        Optional.ofNullable((UaGlobal) session.get(UaGlobal.class, entity.getId()))
            .ifPresent((value) -> {
                value.setFirstName(entity.getFirstName());
                value.setSecondName(entity.getSecondName());
                value.setPassword(entity.getPassword());
                value.setEnable(entity.getEnable());
                session.update(value);
                session.flush();
            });
    }

    @Override
    public List<UaGlobal> list() {
        return null;
    }
}
