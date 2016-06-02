package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.User;
import com.itsmtools.common.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


/**
 * Make abstract this class
 */
@Service
public class SqlDbUserDetailsService implements UserDetailsService {
    private List<SimpleGrantedAuthority> granted = new ArrayList<>();
    private Map<String, Object> map = new HashMap<>();
    private String NOT_FOUND = "No such user, or role";

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = service.getByLogin(login).orElseThrow(() -> new UsernameNotFoundException(NOT_FOUND));

        map.put("ContextBackend", user.getAgent());
        map.put("ContextFrontend", user.getCustomer());
        map.put("ContextFrontend", user.getCustomerCustomer());
        map.put("GroupAdmin", user.getAgentAdmin());
        map.put("GroupOperator", user.getAgentOperator());
        map.put("GroupPerformer", user.getAgentPerformer());

        map.entrySet()
            .stream()
            .filter(e -> e.getValue() != null)
            .forEach(e -> granted.add(new SimpleGrantedAuthority(e.getKey())));

        granted.add(new SimpleGrantedAuthority("Global"));

        return new Principal(user, granted);
    }
}