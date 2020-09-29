package Rafiki.Bora.Microfinance.dao.customerDao;

import org.springframework.stereotype.Repository;
import Rafiki.Bora.Microfinance.model.customers.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDao implements CustomerDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
