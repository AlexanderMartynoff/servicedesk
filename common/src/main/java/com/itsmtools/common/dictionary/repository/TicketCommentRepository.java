package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.TicketComment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public class TicketCommentRepository extends AbstractRepository<TicketComment, Integer, String> {

    @Autowired
    private Session session;

    @Override
    public TicketComment get(Integer id) {
        return null;
    }

    @Override
    public void create(TicketComment input) {
        input.setAuthor(getAccount());
        session.save(input);
        session.flush();
    }

    @Override
    public void update(TicketComment input) {}

    @Override
    public void delete(Integer id) {}

    @Override
    @SuppressWarnings("unchecked")
    public List<TicketComment> list(Map<String, String> single, Map<String, List<String>> multi) {
        Criteria query = session.createCriteria(TicketComment.class);

        if(single.containsKey("ticketId")){
            query.createAlias("ticket", "ticket")
                .add(Restrictions.eq("ticket.id", Integer.valueOf(single.get("ticketId"))));
        }

        return query.list();
    }
}