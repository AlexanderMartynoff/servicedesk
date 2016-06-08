package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private Session session;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProfileAgentService agentService;
    @Autowired
    private ProfileCustomerCustomerService customerCustomerService;
    @Autowired
    private ProfileCustomerService customerService;
    @Autowired
    private ProfileAgentAdminService agentAdminService;
    @Autowired
    private ProfileAgentManagerService agentManagerService;
    @Autowired
    private ProfileAgentOperatorService agentOperatorService;
    @Autowired
    private ProfileAgentPerformerService agentPerformerService;

    public List<User> list() {
        return accountService.list()
            .stream()
            .map(e -> buildByAccount((Account) e))
            .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public Optional<User> getByLogin(String login) {
        session.clear();
        return session.createCriteria(Account.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst()
            .map(account -> buildByAccount((Account) account));
    }

    @SuppressWarnings("unchecked")
    public void save(User user) {
        Map<Profile, ProfileService> map = buildProfileServiceMap(user);
        accountService.save(user.getAccount());

        map.forEach((key, value) -> {
            key.setAccount(user.getAccount());
            value.save(key);
        });
    }

    @SuppressWarnings("unchecked")
    public void update(User user){
        Map<Profile, ProfileService> map = buildProfileServiceMap(user);
        accountService.update(user.getAccount());

        map.forEach((key, value) -> {
            if (key.getId() == null) {
                key.setAccount(user.getAccount());
                value.save(key);
            } else {
                value.update(key);
            }
        });
    }

    private Map<Profile, ProfileService> buildProfileServiceMap(User user){
        Map<Profile, ProfileService> map = new HashMap<>();

        // agent profiles
        map.put(user.getAgent(), agentService);
        map.put(user.getAgentAdmin(), agentAdminService);
        map.put(user.getAgentManager(), agentManagerService);
        map.put(user.getAgentOperator(), agentOperatorService);
        map.put(user.getAgentPerformer(), agentPerformerService);

        // customer profiles
        map.put(user.getCustomer(), customerService);
        map.put(user.getCustomerCustomer(), customerCustomerService);

        return map.entrySet()
            .stream()
            .filter(entry -> entry.getKey() != null)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    // builder User object
    private User buildByAccount(Account account) {
        User user = new User();
        user.setAccount(account);

        // agent profiles
        agentService.getByAccount(account).ifPresent(user::setAgent);
        agentAdminService.getByAccount(account).ifPresent(user::setAgentAdmin);
        agentManagerService.getByAccount(account).ifPresent(user::setAgentManager);
        agentManagerService.getByAccount(account).ifPresent(user::setAgentManager);
        agentOperatorService.getByAccount(account).ifPresent(user::setAgentOperator);
        agentPerformerService.getByAccount(account).ifPresent(user::setAgentPerformer);
        // customer profiles
        customerService.getByAccount(account).ifPresent(user::setCustomer);
        customerCustomerService.getByAccount(account).ifPresent(user::setCustomerCustomer);

        return user;
    }
}