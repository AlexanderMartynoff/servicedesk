package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGlobalService {

    @Autowired
    private Session session;

    public Optional<UaGlobal> get(Integer id) {
        return null;
    }

    public Optional<UaGlobal> getByUaGlobal(UaGlobal uaGlobal) {
        return null;
    }

    public void save(UaGlobal entity) {
        session.save(entity);
        session.flush();
    }

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

    public List<UaGlobal> list() {
        return null;
    }
}
