package com.jobmatching.jobmatchingbackend.controller;

import com.jobmatching.jobmatchingbackend.model.User;
import com.jobmatching.jobmatchingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // List all users
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list"; // Thymeleaf view name
    }

    // Create new user
    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/create"; // Thymeleaf view name
    }

    // Save new user
    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Edit user
    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        model.addAttribute("user", user);
        return "user/edit"; // Thymeleaf view name
    }

    // Update user
    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        user.setUser_id(id);
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
