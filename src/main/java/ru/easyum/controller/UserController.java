package ru.easyum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.easyum.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        userService.findRandomUser()
                .ifPresent(user -> model.addAttribute("randomUser", user));

        model.addAttribute("users", userService.findAll());

        return "users";
    }
}