package com.mycompany;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class CustomSession extends AuthenticatedWebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String user;
	
	public CustomSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String arg0, String arg1) {
		
		return true;
	}

	@Override
	public Roles getRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getUser () {
		if (user == null) {
			SecureRandom random = new SecureRandom();
			user = new BigInteger(130, random).toString(32);
			System.out.println("Store username: " + user);
			bind();
		}
		return user;
	}

}
