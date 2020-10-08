package Rafiki.Bora.Microfinance.controllers.user;

import Rafiki.Bora.Microfinance.config.security.dto.UserDto;
import Rafiki.Bora.Microfinance.config.security.dto.UserSummary;
import Rafiki.Bora.Microfinance.model.users.User;
import Rafiki.Bora.Microfinance.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user/auth")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/me")
//    public ResponseEntity<UserSummary> me() {
//        return ResponseEntity.ok(userService.getUserProfile());
//    }

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User signUp(@RequestBody UserDto user){
        log.info("----------------------");
        log.info("The Data is:", user);
        log.info("------------------------");
        return userService.save(user);
    }
//    @PostMapping("register")
//    public User save(@RequestBody User user){
//        try {
//            userService.register(user);
//            System.out.println("success");
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//        return user;
//    }
//
//    @PostMapping("login")
//    public boolean login(@RequestBody String email, String password){
//        boolean isLoggedIn = true;
//        try {
//            userService.login(email, password);
//            System.out.println("success");
//            isLoggedIn = true;
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//            isLoggedIn = false;
//        }
//
//        return isLoggedIn;
//    }
//
//    @GetMapping("/user/get")
//    public @ResponseBody String get(){
//        return "users";
//    }
}

