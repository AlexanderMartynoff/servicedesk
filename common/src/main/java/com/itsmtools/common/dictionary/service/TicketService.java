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

    public void update(Ticket request) {
        repository.update(request);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public List<Ticket> list(Map filter) {
        return repository.list(filter);
    }
}
