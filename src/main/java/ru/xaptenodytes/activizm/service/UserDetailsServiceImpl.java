package ru.xaptenodytes.activizm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import ru.xaptenodytes.activizm.model.Role;
import ru.xaptenodytes.activizm.model.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserService userService;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userService.getUserLogin(login);
   
		boolean enabled = user.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = user.isNonLocked();
        
        return new org.springframework.security.core.userdetails.User(
        		user.getLogin(),
        		user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,   
                accountNonLocked,
                getAuthorities(user)
        ); 
	}

	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		return getGrantedAuthorities(user);
	}
	
	public List<GrantedAuthority> getGrantedAuthorities(User User) {
		Set<Role> roles = User.getRoles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));  
        }  
        return authorities;  
	}
}
