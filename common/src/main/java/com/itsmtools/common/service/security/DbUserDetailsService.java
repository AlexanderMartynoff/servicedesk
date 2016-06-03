package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.User;
import com.itsmtools.common.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DbUserDetailsService implements UserDetailsService {
    private List<SimpleGrantedAuthority> granted = new ArrayList<>();
    private Map<String, Object> potentials = new HashMap<>();
    private Collection<Roles> requiredApplicationRoles = new ArrayList<>();
    private Collection<Roles> requiredGroupRoles = new ArrayList<>();

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = service.getByLogin(login).orElseThrow(() -> new UsernameNotFoundException("No such user, or role"));

        granted.clear();

        potentials.put(Roles.AGENT.name(), user.getAgent());
        potentials.put(Roles.CUSTOMER.name(), user.getCustomer());
        potentials.put(Roles.CUSTOMER_CUSTOMER.name(), user.getCustomerCustomer());
        potentials.put(Roles.AGENT_ADMIN.name(), user.getAgentAdmin());
        potentials.put(Roles.AGENT_OPERATOR.name(), user.getAgentOperator());
        potentials.put(Roles.AGENT_PERFORMER.name(), user.getAgentPerformer());
        potentials.put(Roles.AGENT_MANAGER.name(), user.getAgentManager());

        potentials.forEach((key, value) -> {
            if (value != null) {
                granted.add(new SimpleGrantedAuthority(key));
            }
        });
        granted.add(new SimpleGrantedAuthority(Roles.ACCOUNT.name()));

        if (!(isHasAnyRole(requiredApplicationRoles) && isHasAnyRole(requiredGroupRoles))) {
            throw new UsernameNotFoundException("No such user, or role");
        }

        return new Principal(user, granted);
    }

    public void setRequiredApplicationRoles(Roles... roles) {
        requiredApplicationRoles = Arrays.asList(roles);
    }

    public void setRequiredGroupRoles(Roles... roles) {
        requiredGroupRoles = Arrays.asList(roles);
    }

    private boolean isHasAnyRole(Collection<Roles> requiredRoles) {
        return granted.stream()
            .map(SimpleGrantedAuthority::getAuthority)
            .anyMatch(i -> requiredRoles.stream()
                .map(Enum::name)
                .collect(Collectors.toList())
                .contains(i));
    }

    public enum Roles {
        ACCOUNT,
        AGENT,
        AGENT_PERFORMER,
        AGENT_MANAGER,
        AGENT_OPERATOR,
        AGENT_ADMIN,
        CUSTOMER,
        CUSTOMER_CUSTOMER
    }
}