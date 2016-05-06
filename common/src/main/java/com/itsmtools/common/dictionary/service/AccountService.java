package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private Session session;

    public Optional<Account> get(Integer id) {
        return null;
    }

    public void save(Account input) {
        session.save(input);
        session.flush();
    }

    public void update(Account input) {
        Account account = (Account) session.get(Account.class, input.getId());

        account.setLogin(input.getLogin());
        account.setFirstName(input.getFirstName());
        account.setSecondName(input.getSecondName());
        account.setPassword(input.getPassword());
        account.setEnable(input.getEnable());

        session.save(account);
        session.flush();
    }

    @SuppressWarnings("all")
    public List<Account> list() {
        return (List<Account>) session.createCriteria(Account.class)
            .addOrder(Order.desc("id"))
            .list();
    }
}
