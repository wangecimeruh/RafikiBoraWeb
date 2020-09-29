package Rafiki.Bora.Microfinance.controllers.role;

import Rafiki.Bora.Microfinance.model.roles.Role;
import Rafiki.Bora.Microfinance.service.rolesService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Role roles){
        try {
            roleService.save(roles);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/roles/get")
    public @ResponseBody String get(){
        return "accounts";
    }
}

