package Rafiki.Bora.Microfinance.controllers.merchant;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import Rafiki.Bora.Microfinance.service.merchantService.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value = "/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("save")
    public @ResponseBody String save(@RequestBody Merchant merchant){
        try {
            merchantService.save(merchant);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/merchants/get")
    public @ResponseBody String get(){
     return "Merchants";
    }
}
