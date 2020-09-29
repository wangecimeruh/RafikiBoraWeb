package Rafiki.Bora.Microfinance.service.groupService;

import Rafiki.Bora.Microfinance.dao.groupsDao.GroupDaoI;
import Rafiki.Bora.Microfinance.model.groups.Group;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupService {
    @Autowired
    private GroupDaoI dao;

    public void save(Group group) throws Exception{


            dao.save(group);


    }
}
