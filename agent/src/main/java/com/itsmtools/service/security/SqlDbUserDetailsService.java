package com.itsmtools.service.security;


import com.itsmtools.dictionary.model.UaGlobal;
import com.itsmtools.dictionary.service.spec.UaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class SqlDbUserDetailsService implements UserDetailsService {

    @Autowired
    private UaService uaService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UaGlobal user = uaService.getByUsername(login);

        return new User(user.login, user.password, Arrays.asList(
            new SimpleGrantedAuthority("ADMIN"),
            new SimpleGrantedAuthority("OPERATOR"),
            new SimpleGrantedAuthority("MANAGER"),
            new SimpleGrantedAuthority("PERFORMER"),
            new SimpleGrantedAuthority("CUSTOMER")
        ));
    }
}
