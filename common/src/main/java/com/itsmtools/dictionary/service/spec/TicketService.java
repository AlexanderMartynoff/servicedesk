package com.itsmtools.dictionary.service.spec;


import com.itsmtools.dictionary.model.Ticket;
import java.util.List;

public interface TicketService{
    public Ticket item(Integer id);
    public void save(Ticket entity);
    public void update(Ticket entity);
    public void delete(Integer id);
    public List<Ticket> list();
}