package Rafiki.Bora.Microfinance.controllers.user;

import Rafiki.Bora.Microfinance.model.users.User;
import Rafiki.Bora.Microfinance.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody User user){
        try {
            userService.save(user);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/user/get")
    public @ResponseBody String get(){
        return "users";
    }
}

