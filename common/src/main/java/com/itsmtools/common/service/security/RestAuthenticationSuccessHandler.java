package com.itsmtools.common.service.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsmtools.common.dictionary.dto.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    @Qualifier("defaultJacksonObjectMapper")
    private ObjectMapper jackson;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        AuthenticationResponse responseBody = new AuthenticationResponse("200", "Ok", "/");
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(jackson.writeValueAsString(responseBody));
        clearAuthenticationAttributes(request);
    }
}
