package Rafiki.Bora.Microfinance.service.rolesService;

import Rafiki.Bora.Microfinance.dao.rolesDao.RolesDaoI;
import Rafiki.Bora.Microfinance.model.roles.Role;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {
    @Autowired
    private RolesDaoI dao;

    public void save(Role roles) throws Exception{

            dao.save(roles);


    }
}
