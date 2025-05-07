package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("users")
class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    List<UserEntity> getUsers() {
        return this.userService.getAllUser();
    }

    @PostMapping()
    @Operation(summary = "Create a new user", description = "Creates and returns the new user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "User object to be created",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            name = "New User Example",
                            value = "{\"name\": \"user\", \"email\": \"user@example.com\",\"password\": \"password\"}"
                    )
            )
    )
    UserEntity createUser(@RequestBody UserEntity user) {
        return this.userService.createUser(user);
    }
}
