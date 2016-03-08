package com.itsmtools.common.dictionary.service.spec;


import com.itsmtools.common.dictionary.model.Ticket;
import java.util.List;


public interface TicketService extends BaseService{
    Ticket item(Integer id);
    void save(Ticket entity);
    void update(Ticket entity);
    void delete(Integer id);
    List<Ticket> list();
}