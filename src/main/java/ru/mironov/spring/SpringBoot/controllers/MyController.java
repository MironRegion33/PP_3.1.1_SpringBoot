package ru.mironov.spring.SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mironov.spring.SpringBoot.service.UserService;
import ru.mironov.spring.SpringBoot.users.User;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "showAllUsers";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addNewUser";
    }

    @RequestMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "addNewUser";
    }

    @GetMapping("/delete")
    public String deleteUserWithParam(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
