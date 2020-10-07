package Rafiki.Bora.Microfinance.controllers.user;

import Rafiki.Bora.Microfinance.config.security.dto.UserSummary;
import Rafiki.Bora.Microfinance.model.users.User;
import Rafiki.Bora.Microfinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserSummary> me() {
        return ResponseEntity.ok(userService.getUserProfile());
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

