package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.service.spec.BaseService;
import com.itsmtools.common.service.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
abstract public class BaseServiceImpl implements BaseService {
    @Override
    public Principal getPrincipal(){
        return (Principal)SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
    }

}
