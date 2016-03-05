package com.itsmtools.service.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.stereotype.Component;


@Component
public class ObjectMapperBean extends ObjectMapper{

    public ObjectWriter filterWriter(String ... fields){
        return writer(new SimpleFilterProvider()
            .addFilter("main", SimpleBeanPropertyFilter.serializeAllExcept(fields)));
    }
}
