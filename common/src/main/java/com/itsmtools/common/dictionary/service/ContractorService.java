package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Contractor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContractorService{

    @Autowired
    private SessionFactory factory;

    public Contractor item(Integer id) {
        return null;
    }

    public void save(Contractor entity) {
        Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    public void update(Contractor input) {
        Session session = factory.openSession();
        Contractor contractor = (Contractor) session.get(Contractor.class, input.getId());
        contractor.setServices(input.getServices());
        contractor.setFullName(input.getFullName());
        contractor.setMetaInfo(input.getMetaInfo());
        session.update(contractor);
        session.flush();
        session.close();
    }

    public void delete(Integer id) {
        Session session = factory.openSession();
        Optional.ofNullable(session.get(Contractor.class, id)).ifPresent(i -> {
            session.delete(i);
            session.flush();
        });
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Contractor> list() {
        Session session = factory.openSession();
        List<Contractor> collection = (List<Contractor>) session.createCriteria(Contractor.class).list();
        session.close();
        return collection;
    }
}