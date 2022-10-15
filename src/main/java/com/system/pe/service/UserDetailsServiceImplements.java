package com.system.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.pe.entity.Account;
import com.system.pe.repository.AccountRepository;
import com.system.pe.security.JwtUser;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	@Autowired
	AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String personUsername) throws UsernameNotFoundException {
    	Account account = accountRepository.findByAccountUsername(personUsername).get();
        return JwtUser.build(account, null);
    }
}