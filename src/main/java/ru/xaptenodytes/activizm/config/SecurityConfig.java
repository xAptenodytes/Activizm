package ru.xaptenodytes.activizm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//@Autowired
	//UserDetailsServiceImpl userDetailsService;

	@Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
    		.authorizeRequests()
            	.antMatchers("/resources/**").permitAll()
            	.antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.loginPage("/index")
            	.defaultSuccessUrl("/secure/index")
            	.permitAll()
            	.and()
            .logout()                    
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.logoutSuccessUrl("/index")
	            .permitAll();
    }
}
