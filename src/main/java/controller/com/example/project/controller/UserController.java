package controller.com.example.project.controller;

import model.User.java.User;
import service.com.example.project.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public Optional<User> loginUser(@RequestBody User user) {
        return userService.authenticate(user.getEmail(), user.getPassword());
    }
}
