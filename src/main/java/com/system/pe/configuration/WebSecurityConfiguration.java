package com.system.pe.configuration;

import static com.system.pe.Constant.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.system.pe.security.JwtEntryPoint;
import com.system.pe.security.JwtTokenFilter;
import com.system.pe.service.UserDetailsServiceImplements;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	private String[] openResources = new String[]{
			"/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**", "/", "/index", "/person/recovery-password",
			"/auth/**","/","/generate-data", "/favicon.ico", "/private-message", "/message","/ws/**",
			"/our-websocket/**","/ws/message","/ws/private-message","/general/**","/concession/**","/requirement-alert-session/**","/requirement-alert/**",
			"/person","/requirement-alert-session", URL_COURSE_ID_GET
			};
	
	private String[] securedResources = new String[] {
			"/secured/**", "/secured/success", "/secured/socket", "/secured/success"
			};
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    UserDetailsServiceImplements userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(openResources).permitAll();
		http.authorizeRequests().antMatchers(securedResources).authenticated()
				.anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		//return bCryptPasswordEncoder;
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(
    		AuthenticationConfiguration authenticationConfiguration) throws Exception{
    return authenticationConfiguration.getAuthenticationManager();
    }

}