package Rafiki.Bora.Microfinance.dao.transactionsDao;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TransactionsDao implements TransactionDaoI{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transaction> listTransactions() {
       return em.createQuery("from " + Transaction.class.getName()).getResultList();
    }

    @Override
    public void save(Transaction transaction) {
        em.merge(transaction);

    }

    @Override
    public void filter(Transaction transaction) {


    }
}
