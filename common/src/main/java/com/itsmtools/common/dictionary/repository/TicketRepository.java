package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Ticket;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class TicketRepository extends AbstractRepository<Ticket, Integer> {

    @Autowired
    private Session session;

    public Ticket get(Integer id) {
        return (Ticket) session.get(Ticket.class, id);
    }

    public void create(Ticket request) {
        if (request.getProgress() == null || request.getProgress() < 0) {
            request.setProgress(0);
        } else if (request.getProgress() > 100) {
            request.setProgress(100);
        }

        request.setAuthor(getPrincipal().getUa().getUaGlobal());
        session.save(request);
        session.flush();
    }

    public void update(Ticket request) {
        Ticket ticket = (Ticket) session.get(Ticket.class, request.getId());

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setDateOpen(request.getDateOpen());
        ticket.setContractor(request.getContractor());
        ticket.setPerformer(request.getPerformer());

        if (request.getProgress() == null || request.getProgress() < 0) {
            ticket.setProgress(0);
        } else if (request.getProgress() > 100) {
            ticket.setProgress(100);
        } else {
            ticket.setProgress(request.getProgress());
        }

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
    public List<Ticket> list(Map<String, ?> filter) {
        Criteria criteria = session.createCriteria(Ticket.class);

        if (filter.containsKey("title")) {
            criteria.add(Restrictions.like("title", filter.get("title").toString(), MatchMode.ANYWHERE));
        }

        if (filter.containsKey("performer")) {
            criteria.createAlias("performer", "performer")
                .add(Restrictions.or(
                    Restrictions.like("performer.firstName", filter.get("performer").toString(), MatchMode.ANYWHERE),
                    Restrictions.like("performer.secondName", filter.get("performer").toString(), MatchMode.ANYWHERE),
                    Restrictions.like("performer.thirdName", filter.get("performer").toString(), MatchMode.ANYWHERE)
                ));
        }

        criteria.addOrder(Order.desc("id"));

        return criteria.list();
    }
}
