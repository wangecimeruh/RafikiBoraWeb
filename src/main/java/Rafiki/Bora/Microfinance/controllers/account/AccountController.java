package Rafiki.Bora.Microfinance.controllers.account;

import Rafiki.Bora.Microfinance.model.account.Account;
import Rafiki.Bora.Microfinance.service.accountService.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Account accounts){
        try {
            accountService.save(accounts);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/accounts/get")
    public @ResponseBody String get(){
        return "accounts";
    }
}
