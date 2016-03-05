package com.itsmtools.dictionary.service.impl;


import com.itsmtools.dictionary.dto.UaComplex;
import com.itsmtools.dictionary.model.UaGlobal;
import com.itsmtools.dictionary.service.spec.UaService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UaServiceImpl implements UaService{

    @Override
    public UaComplex item(Integer id) {
        return null;
    }

    @Override
    public UaGlobal getByUsername(String login) {
        return new UaGlobal(login, "12345678");
    }

    @Override
    public void save(UaComplex entity) {

    }

    @Override
    public void update(UaComplex entity) {

    }

    @Override
    public List<UaComplex> fetch() {
        return null;
    }
}
