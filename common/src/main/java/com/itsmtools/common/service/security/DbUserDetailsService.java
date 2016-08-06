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
    private Collection<Role> requiredApplicationRoles = new ArrayList<>();
    private Collection<Role> requiredGroupRoles = new ArrayList<>();

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final User user = service.getByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        final Map<Role, Profile> potentialRoles = new HashMap<>();
        final List<SimpleGrantedAuthority> realAuthorities = new ArrayList<>();

        potentialRoles.put(Role.AGENT, user.getAgent());
        potentialRoles.put(Role.CUSTOMER, user.getCustomer());
        potentialRoles.put(Role.CUSTOMER_CUSTOMER, user.getCustomerCustomer());
        potentialRoles.put(Role.AGENT_ADMIN, user.getAgentAdmin());
        potentialRoles.put(Role.AGENT_OPERATOR, user.getAgentOperator());
        potentialRoles.put(Role.AGENT_PERFORMER, user.getAgentPerformer());
        potentialRoles.put(Role.AGENT_MANAGER, user.getAgentManager());

        potentialRoles.forEach((key, value) -> {
            if (value != null && value.getEnable() != null && value.getEnable()) {
                realAuthorities.add(new SimpleGrantedAuthority(key.name()));
            }
        });

        if (!isHasAnyRole(requiredApplicationRoles, realAuthorities) || !isHasAnyRole(requiredGroupRoles, realAuthorities)) {
            throw new UsernameNotFoundException("No such user, or role");
        }

        realAuthorities.add(new SimpleGrantedAuthority(Role.ACCOUNT.name()));

        return new Principal(user, realAuthorities);
    }

    public void setRequiredApplicationRoles(Role... roles) {
        requiredApplicationRoles = Arrays.asList(roles);
    }

    public void setRequiredGroupRoles(Role... roles) {
        requiredGroupRoles = Arrays.asList(roles);
    }

    private boolean isHasAnyRole(Collection<Role> requiredRoles, List<SimpleGrantedAuthority> authorities) {
        return authorities.stream()
            .map(SimpleGrantedAuthority::getAuthority)
            .anyMatch(i -> requiredRoles.stream()
                    .map(Enum::name)
                    .collect(Collectors.toList())
                    .contains(i));
    }

    public enum Role {
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