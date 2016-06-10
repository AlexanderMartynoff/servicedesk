package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class ServiceRepository extends AbstractRepository<Service, Integer, String> {

    @Autowired
    private SessionFactory factory;

    @Override
    public Service get(Integer id) {
        return null;
    }

    @Override
    public void create(Service input) {
        Session session = factory.openSession();
        session.save(input);
        session.flush();
        session.close();
    }

    @Override
    public void update(Service input) {
        Session session = factory.openSession();
        Service service = (Service) session.get(Service.class, input.getId());
        service.setTitle(input.getTitle());
        service.setDescription(input.getDescription());
        session.update(service);
        session.flush();
    }

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Service> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        Session session = factory.openSession();
        List<Service> collection = session.createCriteria(Service.class).list();
        session.close();
        return collection;
    }
}