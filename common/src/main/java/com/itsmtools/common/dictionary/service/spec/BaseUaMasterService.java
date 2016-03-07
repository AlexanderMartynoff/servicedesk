package com.itsmtools.common.dictionary.service.spec;


import java.util.List;
import java.util.Optional;


public interface BaseUaMasterService<Master, Complex> {
    Optional<Master> get(Integer id);
    Optional<Master> getByLogin(String login);
    List<Complex> listComplex();
    Complex buildComplexByUaGlobal(Master master);
    Optional<Complex> getComplexByUaGlobalLogin(String login);
    void save(Master entity);
    void update(Master entity);
    List<Master> list();
}