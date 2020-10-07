package Rafiki.Bora.Microfinance.config.security.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class LoginRequest {
    @NotBlank(message = "Email address cannot be empty")
    @Email(message = "Please provide valid email address")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}
