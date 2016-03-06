package com.itsmtools.dictionary.service.spec;


import com.itsmtools.dictionary.model.UaGlobal;
import java.util.List;
import java.util.Optional;


public interface UaService {
    Optional<UaGlobal> item(Integer id);
    Optional<UaGlobal> getByUsername(String login);
    void save(UaGlobal entity);
    void update(UaGlobal entity);
    List<UaGlobal> fetch();
}