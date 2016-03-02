package com.itsmtools.dictionary.service.spec;


import com.itsmtools.dictionary.dto.UaComplex;
import com.itsmtools.dictionary.model.UaGlobal;

import java.util.List;


public interface UaService {
    UaComplex item(Integer id);
    UaGlobal getByUsername(String login);
    void save(UaComplex entity);
    void update(UaComplex entity);
    List<UaComplex> fetch();
}