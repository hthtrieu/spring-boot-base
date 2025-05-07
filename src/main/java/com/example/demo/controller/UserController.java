package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    List<UserEntity> getUsers() {
        return this.userService.getAllUser();
    }

    @PostMapping()
    @Operation(
            summary = "Create a new user",
            description = "Creates and returns the new user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User object to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "New User Example",
                                    value = "{\"username\": \"user\", \"email\": \"user@example.com\",\"password\": \"password\"}"
                            )
                    )
            )
    )
    public UserEntity createUser(@Valid @RequestBody() UserEntity user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/search")
    @Operation(
            summary = "Search users by username",
            description = "Finds users by their username, supports pagination"

    )
    public Page<UserEntity> findByUserName(@RequestParam("username") String username, Pageable pageable) {
        return this.userService.findByUserName(username, pageable);
    }
}
