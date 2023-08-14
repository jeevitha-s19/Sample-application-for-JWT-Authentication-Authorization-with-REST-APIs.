package com.javasample.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javasample.dao.UserDao;
import com.javasample.model.DAOUser;
import com.javasample.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	//To save user details.
	public DAOUser save(UserDTO user) {
		String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
     

        if (isValidUsername(username)&& isValidEmail(email)&& isValidPassword(password))  {
            DAOUser newUser = new DAOUser();
            newUser.setUsername(username);
            newUser.setPassword(bcryptEncoder.encode(password));
            newUser.setEmail(email);
            return userDao.save(newUser);
        } else {
            // Handle invalid username, password, or email
            throw new IllegalArgumentException("Invalid username, password, or email");
        }
    }

	
	
    private boolean isValidUsername(String username) {
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
    

    
    
    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
	            return false;
	        }
	        
	        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
    
    
    
    
    private boolean isValidPassword(String password) {
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



