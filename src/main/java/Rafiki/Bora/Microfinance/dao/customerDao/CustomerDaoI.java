package Rafiki.Bora.Microfinance.dao.customerDao;

import Rafiki.Bora.Microfinance.model.customers.Customer;

public interface CustomerDaoI {

    void save(Customer customer);
    void delete(Customer customer);

}
