package Rafiki.Bora.Microfinance.controllers.agent;

import Rafiki.Bora.Microfinance.model.agents.Agent;
import Rafiki.Bora.Microfinance.service.agentService.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class AgentController {


    @Autowired
    private AgentService agentService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Agent agents){
        try {
            agentService.save(agents);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/agents/get")
    public @ResponseBody String get(){
        return "agents";
    }
}
