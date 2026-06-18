package com.self.crud.controller;

import com.self.crud.entity.User;
import com.self.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud/users")

public class UserController{

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/all_users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,@Valid @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
