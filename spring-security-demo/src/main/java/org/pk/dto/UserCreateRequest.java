package org.pk.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.pk.model.Role;

public class UserCreateRequest {
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    private Role role = Role.USER;

    public UserCreateRequest() {}
    
    public UserCreateRequest(String email, String password, Role role) {
    	this.email = email;
    	this.password = password;
    	this.role = role;
    }
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}
}