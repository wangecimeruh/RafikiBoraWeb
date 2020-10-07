package Rafiki.Bora.Microfinance.dao.userDao;

import Rafiki.Bora.Microfinance.model.users.User;

public interface UserDaoI {
    User save(User user);
    // void delete(User user);
    User login(String email, String password);

}
