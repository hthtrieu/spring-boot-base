package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "java_user")
@DynamicInsert //chi insert các trường có gía trị
@DynamicUpdate //chi update các trường có gía trị
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @Schema(description = "User's name", example = "user", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @Column(nullable = false)
    @Schema(description = "User's password", example = "password", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Column(nullable = false, unique = true)
    @Schema(description = "User's email", example = "user@gmai.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
}
