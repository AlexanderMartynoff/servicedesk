package com.itsmtools.common.dictionary.service.spec;


import com.itsmtools.common.dictionary.model.UaGlobal;
import java.util.List;
import java.util.Optional;


public interface UaSlaveService<T> extends Service {
    Optional<T> get(Integer id);
    Optional<T> getByUaGlobal(UaGlobal uaGlobal);
    void save(T entity);
    void update(T entity);
    List<T> list();
}