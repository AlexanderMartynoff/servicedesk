package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.ComplexUa;
import com.itsmtools.common.dictionary.service.UaComplexService;
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


@Service
public class SqlDbUserDetailsService implements UserDetailsService {
    private List<SimpleGrantedAuthority> granted = new ArrayList<>();
    private Map<String, Object> map = new HashMap<>();

    @Autowired
    private UaComplexService uaService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ComplexUa ua = uaService.getByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("No such user"));

        map.put("ContextBackend", ua.getUaContextBackend());
        map.put("ContextFrontend", ua.getUaContextFrontend());
        map.put("GroupAdmin", ua.getUaGroupAdmin());
        map.put("GroupOperator", ua.getUaGroupOperator());
        map.put("GroupPerformer", ua.getUaGroupPerformer());

        map.entrySet().forEach((entry) -> {
            if(entry.getValue() != null)
                granted.add(new SimpleGrantedAuthority(entry.getKey()));
        });

        // for all case
        granted.add(new SimpleGrantedAuthority("Global"));

        return new Principal(ua, granted);
    }
}