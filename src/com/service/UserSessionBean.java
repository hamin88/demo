package com.service;

import java.io.Serializable;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.io.User;


@Component(value = "sessionBean")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionBean implements Serializable,DisposableBean{

 	/**
	 * 
	 */
	public UserSessionBean() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -8780468507169081822L;

	private User currentUser;
 
	
	
	public User getCurrentUser() {
		return currentUser;
	}



	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}



	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
