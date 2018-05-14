package com.isa_mrs_tim7.isa_mrs_tim7.entity;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCriteria {
	@NotBlank(message = "username can't be empty!")
    String username;
	@NotBlank(message = "password can't be empty!")
	String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
