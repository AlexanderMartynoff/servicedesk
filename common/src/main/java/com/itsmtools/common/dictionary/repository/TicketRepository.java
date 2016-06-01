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
import java.util.stream.Collectors;


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
    public List<Ticket> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        Criteria criteria = session.createCriteria(Ticket.class);

        if (singleParams.containsKey("title")) {
            criteria.add(Restrictions.like("title", singleParams.get("title"), MatchMode.ANYWHERE));
        }

        if(singleParams.containsKey("performerId")){
            criteria.add(Restrictions.eq(
                "performer.id",
                Integer.valueOf(singleParams.get("performerId"))
            ));
        }

        if(singleParams.containsKey("initiatorId")){
            criteria.createAlias("initiator", "initiator")
                .add(Restrictions.eq("initiator.id", Integer.valueOf(singleParams.get("initiatorId"))));
        }

        try {
            if (singleParams.containsKey("dateOpenFrom") && singleParams.containsKey("dateOpenUntil")) {
                // if both
                criteria.add(Restrictions.between(
                    "dateOpen",
                    format.parse(singleParams.get("dateOpenFrom")).getTime(),
                    format.parse(singleParams.get("dateOpenUntil")).getTime()
                ));
            } else if (singleParams.containsKey("dateOpenFrom")) {
                // if just from
                criteria.add(Restrictions.ge(
                    "dateOpen",
                    format.parse(singleParams.get("dateOpenFrom")).getTime()
                ));
            } else if (singleParams.containsKey("dateOpenUntil")) {
                // if just until
                criteria.add(Restrictions.le(
                    "dateOpen",
                    format.parse(singleParams.get("dateOpenUntil")).getTime()
                ));
            }
        } catch (ParseException e) {
            throw (RuntimeException) new RuntimeException(e).initCause(e);
        }

        if(multiParams.containsKey("levelIds") && multiParams.get("levelIds").size() > 0){
            criteria.add(Restrictions.in(
                "supportLevel.id",
                multiParams.get("levelIds").stream().map(Integer::valueOf).collect(Collectors.toList())
            ));
        }

        criteria.addOrder(Order.desc("id"));

        return criteria.list();
    }
}