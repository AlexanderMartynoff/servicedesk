package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.ComplexUa;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.List;


public class Principal extends User {
    private ComplexUa ua;

    public Principal(ComplexUa ua, List<SimpleGrantedAuthority> grantedAuthorities) {
        super(ua.getUaGlobal().getLogin(), ua.getUaGlobal().getPassword(), grantedAuthorities);
        this.ua = ua;
    }

    public ComplexUa getUa() {
        return ua;
    }
}