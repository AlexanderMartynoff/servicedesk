package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private SessionFactory factory;

    public Optional<Account> get(Integer id) {
        return null;
    }

    public void save(Account input) {
        Session session = factory.openSession();
        session.save(input);
        session.flush();
        session.close();
    }

    public void update(Account input) {
        Session session = factory.openSession();
        Account account = (Account) session.get(Account.class, input.getId());

        account.setLogin(input.getLogin());
        account.setFirstName(input.getFirstName());
        account.setSecondName(input.getSecondName());
        account.setPassword(input.getPassword());
        account.setEnable(input.getEnable());

        session.save(account);
        session.flush();
        session.close();
    }

    @SuppressWarnings("all")
    public List<Account> list() {
        Session session = factory.openSession();
        List<Account> collection = (List<Account>) session.createCriteria(Account.class)
            .addOrder(Order.desc("id"))
            .list();
        session.close();

        return collection;
    }
}
