package com.itsmtools.common.service.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(60 * 3);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {}
}
