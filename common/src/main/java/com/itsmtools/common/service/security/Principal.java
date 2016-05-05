package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;


public class Principal extends org.springframework.security.core.userdetails.User {
    private User user;

    public Principal(User user, List<SimpleGrantedAuthority> grantedAuthorities) {
        super(user.getAccount().getLogin(), user.getAccount().getPassword(), grantedAuthorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}