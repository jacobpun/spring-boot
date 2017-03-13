package org.pk.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user;
	public CurrentUser(User user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}
	
	public Role getRole() {
		return user.getRole();
	}
	public long getId() {
		return user.getId();
	}
}
