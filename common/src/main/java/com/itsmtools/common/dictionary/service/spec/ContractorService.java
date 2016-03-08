package com.itsmtools.common.dictionary.service.spec;


import com.itsmtools.common.dictionary.model.Contractor;

import java.util.List;

public interface ContractorService extends BaseService{
    Contractor item(Integer id);
    void save(Contractor entity);
    void update(Contractor entity);
    void delete(Integer id);
    List<Contractor> list();
}