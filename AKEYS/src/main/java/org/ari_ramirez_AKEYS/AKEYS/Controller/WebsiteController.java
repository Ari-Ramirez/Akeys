package org.ari_ramirez_AKEYS.AKEYS.Controller;

import org.ari_ramirez_AKEYS.AKEYS.Entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("firstName", user.getFirstName());
        }
        return "AKEYS-website";
    }
    @GetMapping("/keyboards")
    public String keyboards(){

        return "keyboards";
    }

    @GetMapping("/keycaps")
    public String keycaps(){

        return "keycaps";
    }

    @GetMapping("/switches")
    public String switches(){

        return "switches";
    }

    @GetMapping("/checkout")
    public String checkout(){

        return "checkout";
    }


}
