package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.TicketComment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class TicketCommentRepository extends AbstractRepository<TicketComment, Integer, String> {

    @Autowired
    private SessionFactory factory;

    @Override
    public TicketComment get(Integer id) {
        return null;
    }

    @Override
    public void create(TicketComment input) {
        Session session = factory.openSession();
        input.setAuthor(getAccount());
        session.save(input);
        session.flush();
        session.close();
    }

    @Override
    public void update(TicketComment input) {
        throw new RuntimeException("Not supported operation");
    }

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<TicketComment> list(Map<String, String> single, Map<String, List<String>> multi) {
        Session session = factory.openSession();
        Criteria query = session.createCriteria(TicketComment.class);
        query.addOrder(Order.desc("id"));

        if(single.containsKey("ticketId")){
            query.createAlias("ticket", "ticket")
                .add(Restrictions.eq("ticket.id", Integer.valueOf(single.get("ticketId"))));
        }

        List<TicketComment> list = query.list();
        session.close();

        return list;
    }
}