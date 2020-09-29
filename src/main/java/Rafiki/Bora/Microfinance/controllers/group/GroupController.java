package Rafiki.Bora.Microfinance.controllers.group;

import Rafiki.Bora.Microfinance.model.groups.Group;
import Rafiki.Bora.Microfinance.service.groupService.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Group group){
        try {
            groupService.save(group);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/group/get")
    public @ResponseBody String get(){
        return "group";
    }
}

