package com.itsmtools.common.dictionary.service.spec;


import java.util.List;
import java.util.Optional;


public interface BaseUaMasterService<T> {
    Optional<T> get(Integer id);
    Optional<T> getByLogin(String login);
    void save(T entity);
    void update(T entity);
    List<T> list();
}