package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.SupportLevel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class SupportLevelRepository extends AbstractRepository<SupportLevel, Integer, String> {

    @Autowired
    private SessionFactory factory;

    @Override
    public SupportLevel get(Integer id) {
        return null;
    }

    @Override
    public void create(SupportLevel entity) {

    }

    @Override
    public void update(SupportLevel entity) {

    }

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<SupportLevel> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        Session session = factory.openSession();
        List<SupportLevel> collection = session.createCriteria(SupportLevel.class).list();
        session.close();
        return collection;
    }
}