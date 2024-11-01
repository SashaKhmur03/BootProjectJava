package by.itstep.sasha.demoboot.controller;

import by.itstep.sasha.demoboot.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {


    @GetMapping("/home-page")
    public String homePage() {
        return "home-page";
    }


    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "form/login-form";
    }

    @GetMapping("/register")
    public String register(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "form/sign-up-form";
    }

    @GetMapping("/forgot-password")
    public String passwordResetPage() {
        return "form/password-recovery-form";
    }

    @GetMapping("/address")
    public String address(Model model, UserDto userDto) {
        model.addAttribute("address");
        return "form/user-address-form";
    }

}
