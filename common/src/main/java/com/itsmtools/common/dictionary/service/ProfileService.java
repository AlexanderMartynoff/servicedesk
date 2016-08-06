package com.itsmtools.common.dictionary.service;


import java.util.List;
import java.util.Optional;


public interface ProfileService<P, A> {
    Optional<P> get(Integer id);
    Optional<P> getByAccount(A account);
    void save(P p);
    void update(P p);
    List<P> list();
}
