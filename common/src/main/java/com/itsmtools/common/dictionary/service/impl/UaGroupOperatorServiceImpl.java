package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupOperator;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGroupOperatorServiceImpl implements BaseUaSlaveService<UaGroupOperator> {

    @Autowired
    Session session;

    @Override
    public Optional<UaGroupOperator> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGroupOperator> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupOperator.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGroupOperator entity) {}

    @Override
    public void update(UaGroupOperator entity) {}

    @Override
    public List<UaGroupOperator> list() {
        return null;
    }
}
