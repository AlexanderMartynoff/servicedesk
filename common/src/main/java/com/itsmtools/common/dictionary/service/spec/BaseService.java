package com.itsmtools.common.dictionary.service.spec;


import com.itsmtools.common.service.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;


public interface BaseService {
    default Principal getPrincipal(){
        return (Principal) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
    }
}