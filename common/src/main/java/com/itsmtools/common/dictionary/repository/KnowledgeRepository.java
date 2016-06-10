package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Knowledge;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class KnowledgeRepository extends AbstractRepository<Knowledge, Integer, String> {

    @Autowired
    private SessionFactory factory;

    @Override
    public Knowledge get(Integer id) { return null; }

    @Override
    public void create(Knowledge entity) {
        final Session session = factory.openSession();
        session.save(entity);
        session.flush();
        session.close();
    }

    @Override
    public void update(Knowledge input) {
        final Session session = factory.openSession();
        Knowledge knowledge = (Knowledge) session.get(Knowledge.class, input.getId());
        knowledge.setTitle(input.getTitle());
        knowledge.setDescription(input.getDescription());
        knowledge.setResolution(input.getResolution());
        session.update(knowledge);
        session.flush();
        session.close();
    }

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Knowledge> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        final Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Knowledge.class);

        if(singleParams.containsKey("anywhere")){
            criteria.add(Restrictions.or(
                Restrictions.like("title", singleParams.get("anywhere"), MatchMode.ANYWHERE),
                Restrictions.like("description", singleParams.get("anywhere"), MatchMode.ANYWHERE),
                Restrictions.like("resolution", singleParams.get("anywhere"), MatchMode.ANYWHERE)
            ));
        }

        List<Knowledge> collection = criteria.list();
        session.close();
        return  collection;
    }
}