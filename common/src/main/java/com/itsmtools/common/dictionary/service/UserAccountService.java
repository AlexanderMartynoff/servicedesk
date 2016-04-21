package com.itsmtools.common.dictionary.service;



import java.util.List;
import java.util.Optional;

public interface UserAccountService<E, G> {
    Optional<E> get(Integer id);
    Optional<E> getByUaGlobal(G ua);
    void save(E e);
    void update(E e);
    List<E> list();
}
