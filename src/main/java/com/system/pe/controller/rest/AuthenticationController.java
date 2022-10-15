package com.system.pe.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.pe.Constant;
import com.system.pe.dto.Message;
import com.system.pe.dto.request.AccountLoginDto;
import com.system.pe.dto.response.ResponseLoginDto;
import com.system.pe.security.JwtProvider;

@RestController
@RequestMapping(value=Constant.URL_AUTH_REQUEST)
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
	
	@PostMapping(Constant.URL_AUTH_LOGIN_POST)
    public ResponseEntity<?> login(@Valid @RequestBody AccountLoginDto userLogin, BindingResult bindingResult) throws Exception {
    	try {
//			°Realizar validaciones
        	if(bindingResult.hasErrors())
                return new ResponseEntity<Message>(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//	    	°Realizar autenticación
        	String username = userLogin.getUsername().toLowerCase();
        	Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userLogin.getPassword()));
        	SecurityContextHolder.getContext().setAuthentication(authentication);
        	String jwt = jwtProvider.generateToken(authentication);
        	UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        	ResponseLoginDto responseLoginDto = new ResponseLoginDto(jwt, userDetails.getUsername());
        	return new ResponseEntity<ResponseLoginDto>(responseLoginDto, HttpStatus.OK);
    	}catch (Exception e) {
        	e.printStackTrace();
        	return new ResponseEntity<Message>(new Message(Constant.SYSTEM_ERROR_AUTH), HttpStatus.BAD_REQUEST);
        }
    }

}
