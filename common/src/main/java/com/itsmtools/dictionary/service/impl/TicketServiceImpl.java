package com.itsmtools.dictionary.service.impl;

import com.itsmtools.dictionary.model.Ticket;
import com.itsmtools.dictionary.service.spec.TicketService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    Session session;

    @Override
    public Ticket item(Integer id) {
        return (Ticket) session.get(Ticket.class, id);
    }

    @Override
    public void save(Ticket request) {
        if(request.getProgress() != null){
            request.setProgress(request.getProgress() >= 0 && request.getProgress() <= 100 ? request.getProgress() : 100);
        }else{
            request.setProgress((byte)0);
        }
        session.save(request);
        session.flush();
    }

    @Override
    public void update(Ticket request) {
        Ticket ticket = (Ticket) session.get(Ticket.class, request.getId());

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setDateOpen(request.getDateOpen());

        if(request.getProgress() != null){
            ticket.setProgress(request.getProgress() >= 0 && request.getProgress() <= 100 ? request.getProgress() : 100);
        }else{
            ticket.setProgress((byte)0);
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
        return (List<Ticket>)session.createCriteria(Ticket.class).list();
    }
}
