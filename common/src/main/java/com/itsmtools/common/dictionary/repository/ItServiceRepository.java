package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.ItService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class ItServiceRepository extends AbstractRepository<ItService, Integer, String> {

    @Autowired
    private Session session;

    @Override
    public ItService get(Integer id) {
        return null;
    }

    @Override
    public void create(ItService input) {
        session.save(input);
        session.flush();
    }

    @Override
    public void update(ItService input) {}

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<ItService> list(Map<String, String> filter) {
        return session.createCriteria(ItService.class).list();
    }
}