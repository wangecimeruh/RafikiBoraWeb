package Rafiki.Bora.Microfinance.dao.transactionsDao;

import org.hibernate.Transaction;

import java.util.List;

public interface TransactionDaoI {

    List<Transaction> listTransactions();

    void save(Transaction transaction);

    void filter(Transaction transaction);
}
