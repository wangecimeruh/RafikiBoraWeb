package Rafiki.Bora.Microfinance.dao.accountDao;

import Rafiki.Bora.Microfinance.model.account.Account;

public interface AccountDaoI {

    void save(Account accounts);
    void delete(Account accounts);

}