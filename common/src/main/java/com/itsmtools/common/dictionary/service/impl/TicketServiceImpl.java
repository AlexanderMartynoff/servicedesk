package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.service.spec.TicketService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private Session session;

    @Override
    public Ticket item(Integer id) {
        return (Ticket) session.get(Ticket.class, id);
    }

    @Override
    public void save(Ticket request) {
        if (request.getProgress() == null || request.getProgress() < 0) {
            request.setProgress(0);
        } else if (request.getProgress() > 100) {
            request.setProgress(100);
        }

        request.setAuthor(getPrincipal().getUa().getUaGlobal());
        session.save(request);
        session.flush();
    }

    @Override
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

    @Override
    public void delete(Integer id) {
        Object instance = session.load(Ticket.class, id);

        if (instance != null) {
            session.delete(instance);
            session.flush();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> list() {
        return (List<Ticket>) session.createCriteria(Ticket.class).list();
    }
}
