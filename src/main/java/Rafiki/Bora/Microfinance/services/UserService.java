package Rafiki.Bora.Microfinance.services;

import Rafiki.Bora.Microfinance.config.security.dto.LoginRequest;
import Rafiki.Bora.Microfinance.config.security.dto.LoginResponse;
import Rafiki.Bora.Microfinance.config.security.dto.UserSummary;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest, String accessToken, String refreshToken);

    ResponseEntity<LoginResponse> refresh(String accessToken, String refreshToken);



    UserSummary getUserProfile();
}
