package org.ari_ramirez_AKEYS.AKEYS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password) {
        if (authenticationSuccessful(email, password)) {
            return "redirect:/home";
        } else {
            return "redirect:/login?error";
        }
    }
    private boolean authenticationSuccessful(String email, String password) {
        return true;
    }




}
