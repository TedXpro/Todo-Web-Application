package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller // makes it a bean.
@SessionAttributes("name") // adds name to session to live much longer than a single request
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET) // the string in "" is URL
    public String goToWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
                
        return authentication.getName();
    }
}
