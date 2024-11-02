package by.itstep.sasha.demoboot.controller;

import by.itstep.sasha.demoboot.dto.UserDto;
import by.itstep.sasha.demoboot.entity.user.User;
import by.itstep.sasha.demoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {


    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = userService.findByEmail(userDto.getUsername());
        if (user != null) {
            model.addAttribute("Userexist", user);
            return "form/sign-up-form";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }


    @GetMapping("/forgot-password")
    public String passwordResetPage() {
        return "form/password-recovery-form";
    }


    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "list/users-list";
    }


    @GetMapping("/address")
    public String address(Model model, UserDto userDto) {
        model.addAttribute("address");
        return "form/user-address-form";
    }


    @GetMapping(value = "/delete-user-{email}")
    public String deleteUser(UserDto userDto) {
        userService.deleteByEmail(userDto.getEmail());
        return "list/users-list";
    }

    @RequestMapping(value = "/update-user-{email}")
    public String updateUser(@PathVariable String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "form/sign-up-form";
    }


}
