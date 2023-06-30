package com.practical.assignment.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practical.assignment.model.User;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String userName;

	@JsonIgnore
	private String password;
	
	Set<GrantedAuthority> authorities=null;
	

	
	
	public UserDetailsImpl(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public static UserDetailsImpl build(User user) {

		return new UserDetailsImpl(
				user.getUserId(), 
				user.getUserName(), 
				user.getUserPassword()
				
				);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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

}

