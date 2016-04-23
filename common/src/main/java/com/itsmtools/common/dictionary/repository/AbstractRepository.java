package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.service.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.Map;


abstract public class AbstractRepository<E, I>{

    public Principal getPrincipal(){
        return (Principal) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
    }

    abstract public E get(I id);
    abstract public void create(E entity);
    abstract public void update(E entity);
    abstract public void delete(I id);
    abstract public List<E> list(Map<String, ?> filter);
}