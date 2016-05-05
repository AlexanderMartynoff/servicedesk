package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Account;
import org.hibernate.Session;
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

    public void save(Account entity) {
        session.save(entity);
        session.flush();
    }

    public void update(Account entity) {
        Account account = (Account) session.get(Account.class, entity.getId());

        account.setLogin(entity.getLogin());
        account.setFirstName(entity.getFirstName());
        account.setSecondName(entity.getSecondName());
        account.setPassword(entity.getPassword());
        account.setEnable(entity.getEnable());

        session.save(account);
        session.flush();
    }

    public List<Account> list() {
        return null;
    }
}
