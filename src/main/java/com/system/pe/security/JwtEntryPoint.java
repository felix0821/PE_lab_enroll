package com.system.pe.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.pe.Constant;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    	logger.error("Unauthenticated error: {}", authException.getMessage());

    	  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    	  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    	  final Map<String, Object> body = new HashMap<>();
    	  body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
    	  body.put("error", Constant.SYSTEM_MSG_UNAUTHENTICATED);
    	  body.put("message", authException.getMessage());
    	  body.put("path", request.getServletPath());

    	  final ObjectMapper mapper = new ObjectMapper();
    	  mapper.writeValue(response.getOutputStream(), body);
    }
    
    
}
