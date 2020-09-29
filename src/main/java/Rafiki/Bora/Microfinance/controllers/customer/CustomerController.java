package Rafiki.Bora.Microfinance.controllers.customer;

import Rafiki.Bora.Microfinance.model.customers.Customer;
import Rafiki.Bora.Microfinance.service.customerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public @ResponseBody
    String save(@RequestBody Customer customer){
        try {
            customerService.save(customer);
            System.out.println("success");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "success";
    }

    @GetMapping("/customer/get")
    public @ResponseBody String get(){
        return "customer";
    }
}

