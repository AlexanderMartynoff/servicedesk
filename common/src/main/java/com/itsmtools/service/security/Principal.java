package com.itsmtools.service.security;


import com.itsmtools.dictionary.model.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Arrays;


@SuppressWarnings("all")
public class Principal extends User {

    private final String firstName;
    private final String secondName;
    private final String thirdName;

    public Principal(UaGlobal uaGlobal){
        super(uaGlobal.getLogin(), uaGlobal.getPassword(), Arrays.asList(
            new SimpleGrantedAuthority("GLOBAL")
        ));

        firstName = uaGlobal.getFirstName();
        secondName = uaGlobal.getSecondName();
        thirdName = uaGlobal.getThirdName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return thirdName;
    }
}
