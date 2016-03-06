package com.itsmtools.dictionary.service.impl;


import com.itsmtools.dictionary.dto.UaComplex;
import com.itsmtools.dictionary.service.spec.BaseService;
import org.springframework.stereotype.Service;


@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public UaComplex getUaComplex(){
        return new UaComplex();
    }

}
