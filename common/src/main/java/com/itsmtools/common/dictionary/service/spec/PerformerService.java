package com.itsmtools.common.dictionary.service.spec;


import com.itsmtools.common.dictionary.model.UaGlobal;
import java.util.List;


public interface PerformerService extends BaseService{
    UaGlobal item(Integer id);
    void save(UaGlobal entity);
    void update(UaGlobal entity);
    void delete(Integer id);
    List<UaGlobal> list();
}