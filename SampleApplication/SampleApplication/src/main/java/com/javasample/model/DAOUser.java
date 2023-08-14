package com.javasample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private String email;
	
	
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
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

	
	
	//username validation
	 public boolean isValidUsername(String username) {
    	 if (username == null || username.isEmpty()) {
             return false;
         }

    	 else if (username.length() > 20) {
             return false;
         }
    	 if (username.contains(" ")) {
             return false;
    	 }
	        return true;
	 } 
	 
	 
	 //email validation
	 public boolean isValidEmail(String email) {
	        if (email == null || email.isEmpty()) {
	            return false;
	        }
	        
	        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
	 
	 
	 //password validation
	 public boolean isValidPassword(String password) {
	       
	        if (password == null || password.isEmpty()) {
	            return false;
	        }
	     
	        if (password.length() < 8) {
	            return false;
	        }
	        
	        if (!password.matches(".*[A-Z].*")) {
	            return false;
	        }

	 
	        if (!password.matches(".*[a-z].*")) {
	            return false;
	        }
       
	        if (!password.matches(".*\\d.*")) {
	            return false;
	        }
	       
	        if (!password.matches(".*[@#$%^&+=].*")) {
	            return false;
	        }
	           return true;
	    }
	
	 
	 
	 
	

}