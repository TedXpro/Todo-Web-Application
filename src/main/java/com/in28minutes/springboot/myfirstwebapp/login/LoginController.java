package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller // makes it a bean.
@SessionAttributes("name") // adds name to session to live much longer than a single request
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET) // the string in "" is URL
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name,
            @RequestParam String password,
            ModelMap model) {

        if (authenticationService.autherticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login";
    }
}
