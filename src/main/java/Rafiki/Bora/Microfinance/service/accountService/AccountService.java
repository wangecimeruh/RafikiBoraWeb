package Rafiki.Bora.Microfinance.service.accountService;

import Rafiki.Bora.Microfinance.dao.accountDao.AccountDaoI;
import Rafiki.Bora.Microfinance.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
    @Autowired
    private AccountDaoI dao;

    public void save(Account accounts) throws Exception{
        dao.save(accounts);

    }
}