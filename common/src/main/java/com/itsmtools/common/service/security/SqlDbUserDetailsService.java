package com.itsmtools.common.service.security;


import com.itsmtools.common.dictionary.model.*;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
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
    Session session;
    @Autowired
    BaseUaMasterService<UaGlobal> uaGlobalService;
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

        UaGlobal uaGlobal = uaGlobalService.getByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Username not found exception"));

        // for all case
        granted.add(new SimpleGrantedAuthority("Global"));

        Optional<UaContextBackend> uaContextBackend = uaContextBackendService.getByUaGlobal(uaGlobal);
        Optional<UaContextFrontend> uaContextFrontend = uaContextFrontendService.getByUaGlobal(uaGlobal);
        Optional<UaGroupAdmin> uaGroupAdmin = uaGroupAdminService.getByUaGlobal(uaGlobal);
        Optional<UaGroupManager> uaGroupManager = uaGroupManagerService.getByUaGlobal(uaGlobal);
        Optional<UaGroupOperator> uaGroupOperator = uaGroupOperatorService.getByUaGlobal(uaGlobal);
        Optional<UaGroupPerformer> uaGroupPerformer = uaGroupPerformerService.getByUaGlobal(uaGlobal);

        uaContextBackend.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("ContextBackend")));
        uaContextFrontend.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("ContextFrontend")));
        uaGroupAdmin.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("GroupAdmin")));
        uaGroupManager.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("GroupManager")));
        uaGroupOperator.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("GroupOperator")));
        uaGroupPerformer.ifPresent((value) -> granted.add(new SimpleGrantedAuthority("GroupPerformer")));

        return new Principal(
            uaGlobal, uaContextBackend,
            uaContextFrontend, uaGroupAdmin,
            uaGroupManager, uaGroupOperator,
            uaGroupPerformer, granted
        );
    }
}