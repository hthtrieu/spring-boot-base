package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.annotation.*;


@RestController
@RequestMapping("/health")
@RequiredApiKey
@Tag(name = "Health", description = "health check")
class HealthController {
    @GetMapping()
    public String healthCheck(){
        return "Hello world";
    }
}
