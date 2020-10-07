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
    public User save(User user) {

        return em.merge(user);
    }

    @Override
    public User login(String email, String password) {
        User user = null;
        String query = "SELECT u FROM User u WHERE u.email=:email";
        user = (User) this.em.createQuery(query)
                .setParameter("email", email).getSingleResult();
        return user;
    }

}
