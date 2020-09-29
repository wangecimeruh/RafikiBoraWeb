package Rafiki.Bora.Microfinance.dao.accountDao;

import Rafiki.Bora.Microfinance.model.account.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountDao implements AccountDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Account accounts) {

    }

    @Override
    public void delete(Account accounts) {

    }
}