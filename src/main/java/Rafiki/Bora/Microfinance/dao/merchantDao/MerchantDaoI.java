package Rafiki.Bora.Microfinance.dao.merchantDao;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;

public interface MerchantDaoI {
    void save(Merchant merchant);
    void delete(Merchant merchant);
}
