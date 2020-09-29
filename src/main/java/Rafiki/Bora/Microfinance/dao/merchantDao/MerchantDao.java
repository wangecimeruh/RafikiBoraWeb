package Rafiki.Bora.Microfinance.dao.merchantDao;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MerchantDao implements MerchantDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Merchant merchant) {

        em.merge(merchant);
    }
    @Override
    public void delete(Merchant merchant) {
        em.remove(merchant);
    }
}
