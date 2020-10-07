package Rafiki.Bora.Microfinance.config.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private SuccessFailure status;
    private String message;

    public enum SuccessFailure {
        SUCCESS, FAILURE
    }
}
