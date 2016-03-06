package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupAdmin;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGroupAdminServiceImpl implements BaseUaSlaveService<UaGroupAdmin> {

    @Autowired
    Session session;

    @Override
    public Optional<UaGroupAdmin> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGroupAdmin> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupAdmin.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGroupAdmin entity) {}

    @Override
    public void update(UaGroupAdmin entity) {}

    @Override
    public List<UaGroupAdmin> list() {
        return null;
    }
}
