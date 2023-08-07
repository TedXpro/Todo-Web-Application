package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public boolean autherticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("Yohannes");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        
        return isValidUserName && isValidPassword;
    }
}
