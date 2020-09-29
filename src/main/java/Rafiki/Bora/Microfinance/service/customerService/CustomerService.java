package Rafiki.Bora.Microfinance.service.customerService;

import Rafiki.Bora.Microfinance.dao.customerDao.CustomerDaoI;
import Rafiki.Bora.Microfinance.model.customers.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    @Autowired
    private CustomerDaoI dao;

    public void save(Customer customer) throws Exception {

//        if (customer.getEmail().isEmpty()) {
//            dao.save(customer);
//        } else {
//            System.out.println("User Already Exists!!");
//        }

    }
}
