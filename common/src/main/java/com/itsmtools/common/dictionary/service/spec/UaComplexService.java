package com.itsmtools.common.dictionary.service.spec;


import java.util.List;
import java.util.Optional;


public interface UaComplexService<Complex> {
    List<Complex> list();
    Optional<Complex> getByLogin(String login);
    void save(Complex complex);
}