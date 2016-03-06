package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.dto.ComplexUa;
import com.itsmtools.common.dictionary.model.*;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SqlDbUserDetailsService implements UserDetailsService {
    private List<SimpleGrantedAuthority> granted = new ArrayList<>();

    @Autowired
    BaseUaMasterService<UaGlobal, ComplexUa> uaGlobalService;
    @Autowired
    BaseUaSlaveService<UaContextBackend> uaContextBackendService;
    @Autowired
    BaseUaSlaveService<UaContextFrontend> uaContextFrontendService;
    @Autowired
    BaseUaSlaveService<UaGroupAdmin> uaGroupAdminService;
    @Autowired
    BaseUaSlaveService<UaGroupManager> uaGroupManagerService;
    @Autowired
    BaseUaSlaveService<UaGroupOperator> uaGroupOperatorService;
    @Autowired
    BaseUaSlaveService<UaGroupPerformer> uaGroupPerformerService;

    @Override
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{

        ComplexUa complexUa = uaGlobalService.getComplexByUaGlobalLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Username not found exception"));

        // for all case
        granted.add(new SimpleGrantedAuthority("Global"));

        Optional.ofNullable(complexUa.getUaContextBackend())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("ContextBackend")));

        Optional.ofNullable(complexUa.getUaContextBackend())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("ContextFrontend")));

        Optional.ofNullable(complexUa.getUaContextFrontend())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("ContextFrontend")));

        Optional.ofNullable(complexUa.getUaGroupAdmin())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("GroupAdmin")));

        Optional.ofNullable(complexUa.getUaGroupManager())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("GroupManager")));

        Optional.ofNullable(complexUa.getUaGroupOperator())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("GroupOperator")));

        Optional.ofNullable(complexUa.getUaGroupPerformer())
            .ifPresent((e) -> granted.add(new SimpleGrantedAuthority("GroupPerformer")));

        return new Principal(complexUa, granted);
    }
}