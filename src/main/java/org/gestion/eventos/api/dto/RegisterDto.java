package org.gestion.eventos.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters long")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 4, max = 20, message = "Password must be least 6 characters long")
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Size(min = 4, max = 20, message = "It must be a valid email address")
    private String email;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private Set<String> roles;
}
