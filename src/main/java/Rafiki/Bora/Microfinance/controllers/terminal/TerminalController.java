package Rafiki.Bora.Microfinance.controllers.terminal;


import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.service.agentService.AgentService;
import Rafiki.Bora.Microfinance.service.terminalService.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Terminal terminal){
        try {
            terminalService.save(terminal);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/terminal/get")
    public @ResponseBody String get(){
        return "terminals";
    }
}
