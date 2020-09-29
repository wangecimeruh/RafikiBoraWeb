package Rafiki.Bora.Microfinance.dao.userDao;

import Rafiki.Bora.Microfinance.model.users.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao implements UserDaoI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {

        em.merge(user);
    }
    @Override
    public void delete(User user) {
        em.remove(user);
    }
}
