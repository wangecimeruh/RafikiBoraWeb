package Rafiki.Bora.Microfinance.dao.groupsDao;


import Rafiki.Bora.Microfinance.model.groups.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GroupDao implements GroupDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Group group) {

    }

    @Override
    public void delete(Group group) {

    }
}
