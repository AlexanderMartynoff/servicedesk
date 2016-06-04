package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.Profile;
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
    private Collection<Roles> requiredApplicationRoles = new ArrayList<>();
    private Collection<Roles> requiredGroupRoles = new ArrayList<>();

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = service.getByLogin(login).orElseThrow(() -> new UsernameNotFoundException("No such user, or role"));

        Map<Roles, Profile> potentials = new HashMap<>();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        potentials.put(Roles.AGENT, user.getAgent());
        potentials.put(Roles.CUSTOMER, user.getCustomer());
        potentials.put(Roles.CUSTOMER_CUSTOMER, user.getCustomerCustomer());
        potentials.put(Roles.AGENT_ADMIN, user.getAgentAdmin());
        potentials.put(Roles.AGENT_OPERATOR, user.getAgentOperator());
        potentials.put(Roles.AGENT_PERFORMER, user.getAgentPerformer());
        potentials.put(Roles.AGENT_MANAGER, user.getAgentManager());

        potentials.forEach((key, value) -> {
            if (value != null && value.getEnable() != null && value.getEnable()) {
                authorities.add(new SimpleGrantedAuthority(key.name()));
            }
        });

        if (!(isHasAnyRole(requiredApplicationRoles, authorities) && isHasAnyRole(requiredGroupRoles, authorities))) {
            throw new UsernameNotFoundException("No such user, or role");
        }

        authorities.add(new SimpleGrantedAuthority(Roles.ACCOUNT.name()));

        return new Principal(user, authorities);
    }

    public void setRequiredApplicationRoles(Roles... roles) {
        requiredApplicationRoles = Arrays.asList(roles);
    }

    public void setRequiredGroupRoles(Roles... roles) {
        requiredGroupRoles = Arrays.asList(roles);
    }

    private boolean isHasAnyRole(Collection<Roles> requiredRoles, List<SimpleGrantedAuthority> authorities) {
        return authorities.stream()
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