package org.ari_ramirez_AKEYS.AKEYS.Controller;

import jakarta.validation.Valid;
import org.ari_ramirez_AKEYS.AKEYS.DTO.UserDTO;
import org.ari_ramirez_AKEYS.AKEYS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userDto", new UserDTO());
        return "signup";
    }


    @PostMapping("/sign-up-process")
    public String signUpProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "signup";
        }

        userService.saveUser(userDTO);

        return "redirect:/login";
    }
}
