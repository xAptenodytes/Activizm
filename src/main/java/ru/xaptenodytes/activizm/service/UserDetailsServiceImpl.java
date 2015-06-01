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
	UserService UserService;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User User = UserService.getUserLogin(login);
   
		boolean enabled = User.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = User.isNonLocked();
        
        return null /*new User(
        		User.getLogin(),
        		User.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,   
                accountNonLocked,
                getAuthorities(User)
        )*/; 
	}

	private Collection<? extends GrantedAuthority> getAuthorities(User User) {
		return getGrantedAuthorities(User);
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
