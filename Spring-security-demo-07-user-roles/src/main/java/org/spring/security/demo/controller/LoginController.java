package org.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "fancy-login";
    }

    @GetMapping("/accessDenied")
    public String showDenied() {
        return "access-denied";
    }
}
