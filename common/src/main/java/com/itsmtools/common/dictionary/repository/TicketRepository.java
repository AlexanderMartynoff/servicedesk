package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Ticket;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


@Repository
public class TicketRepository extends AbstractRepository<Ticket, Integer, String> {

    @Autowired
    private Session session;

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Ticket get(Integer id) {
        return (Ticket) session.get(Ticket.class, id);
    }

    public void create(Ticket request) {
        if (request.getProgress() == null || request.getProgress() < 0) {
            request.setProgress(0);
        } else if (request.getProgress() > 100) {
            request.setProgress(100);
        }

        request.setAuthor(getPrincipal().getUser().getAccount());
        session.save(request);
        session.flush();
    }

    public void update(Ticket ticket) {
        session.save(ticket);
        session.flush();
    }

    public void delete(Integer id) {
        Ticket instance = (Ticket) session.load(Ticket.class, id);

        if (instance != null) {
            session.delete(instance);
            session.flush();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> list(Map<String, String> params) {
        Criteria criteria = session.createCriteria(Ticket.class);

        if (params.containsKey("title")) {
            criteria.add(Restrictions.like("title", params.get("title"), MatchMode.ANYWHERE));
        }

        if (params.containsKey("performer")) {
            criteria.createAlias("performer", "performer")
                .add(Restrictions.or(
                    Restrictions.like("performer.firstName", params.get("performer"), MatchMode.ANYWHERE),
                    Restrictions.like("performer.secondName", params.get("performer"), MatchMode.ANYWHERE),
                    Restrictions.like("performer.thirdName", params.get("performer"), MatchMode.ANYWHERE)
                ));
        }

        try {
            if (params.containsKey("dateOpenFrom") && params.containsKey("dateOpenUntil")) {
                // if both
                criteria.add(Restrictions.between(
                    "dateOpen",
                    format.parse(params.get("dateOpenFrom")).getTime(),
                    format.parse(params.get("dateOpenUntil")).getTime()
                ));
            } else if (params.containsKey("dateOpenFrom")) {
                // if just from
                criteria.add(Restrictions.ge(
                    "dateOpen",
                    format.parse(params.get("dateOpenFrom")).getTime()
                ));
            } else if (params.containsKey("dateOpenUntil")) {
                // if just until
                criteria.add(Restrictions.le(
                    "dateOpen",
                    format.parse(params.get("dateOpenUntil")).getTime()
                ));
            }
        } catch (ParseException e) {
            throw (RuntimeException) new RuntimeException(e).initCause(e);
        }

        criteria.addOrder(Order.desc("id"));

        return criteria.list();
    }
}