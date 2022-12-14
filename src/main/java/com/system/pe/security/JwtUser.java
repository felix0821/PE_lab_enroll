package com.system.pe.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.system.pe.entity.Account;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6250234144260634731L;
	private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id, String username, String password, 
    		Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUser build(Account account, Collection<Object> personRoles){
        List<GrantedAuthority> authorities = null;
        return new JwtUser(
        		account.getAccountId(), 
        		account.getAccountUsername(), 
        		account.getAccountPassword(), 
        		authorities);
    }
    
    public Long getId() {
    	return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      JwtUser user = (JwtUser) o;
      return Objects.equals(this.id, user.id);
    }
}