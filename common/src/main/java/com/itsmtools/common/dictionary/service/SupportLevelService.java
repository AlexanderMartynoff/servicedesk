package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.SupportLevel;
import com.itsmtools.common.dictionary.repository.SupportLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service
public class SupportLevelService {

    @Autowired
    private SupportLevelRepository repository;

    public Collection<SupportLevel> list(Map<String, String> singleParams, Map<String, List<String>> multiParams){
        return repository.list(singleParams, multiParams);
    }
}
