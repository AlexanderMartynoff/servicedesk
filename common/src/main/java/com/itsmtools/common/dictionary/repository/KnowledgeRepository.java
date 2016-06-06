package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Knowledge;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class KnowledgeRepository extends AbstractRepository<Knowledge, Integer, String> {

    @Autowired
    private Session session;

    @Override
    public Knowledge get(Integer id) { return null; }

    @Override
    public void create(Knowledge entity) {
        session.save(entity);
        session.flush();
    }

    @Override
    public void update(Knowledge entity) {}

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Knowledge> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        return session.createCriteria(Knowledge.class).list();
    }
}