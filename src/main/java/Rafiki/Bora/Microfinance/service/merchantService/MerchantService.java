package Rafiki.Bora.Microfinance.service.merchantService;

import Rafiki.Bora.Microfinance.model.merchant.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Rafiki.Bora.Microfinance.dao.merchantDao.MerchantDaoI;


import javax.transaction.Transactional;

@Service
@Transactional
public class MerchantService {

    @Autowired
    private MerchantDaoI dao;

    public void save(Merchant merchant) throws Exception{

        if (merchant.getPerson().getEmail().isEmpty()){
        dao.save(merchant);
        }else {
            System.out.println("User Already Exists!!");
        }

    }
}
