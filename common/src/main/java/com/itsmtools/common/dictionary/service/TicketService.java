package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class TicketService{

    @Autowired
    TicketRepository repository;

    public Ticket item(Integer id) {
        return repository.get(id);
    }

    public void save(Ticket request) {
        repository.create(request);
    }

    public void update(Ticket input) {
        Ticket ticket = repository.get(input.getId());

        ticket.setTitle(input.getTitle());
        ticket.setDescription(input.getDescription());
        ticket.setDateOpen(input.getDateOpen());
        ticket.setInitiator(input.getInitiator());
        ticket.setContractor(input.getContractor());
        ticket.setPerformer(input.getPerformer());
        ticket.setProgress(input.getProgress());
        ticket.setSupportLevel(input.getSupportLevel());
        ticket.setService(input.getService());
        ticket.setTicketType(input.getTicketType());
        ticket.setPriority(input.getPriority());
        ticket.setAttaches(input.getAttaches());

        repository.update(ticket);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public List<Ticket> list(Map<String, String> singleParams, Map<String, List<String>> multiParams) {
        return repository.list(singleParams, multiParams);
    }
}
