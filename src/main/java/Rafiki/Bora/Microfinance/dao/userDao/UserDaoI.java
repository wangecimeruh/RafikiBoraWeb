package Rafiki.Bora.Microfinance.dao.userDao;

import Rafiki.Bora.Microfinance.model.users.User;

public interface UserDaoI {
    void save(User user);
    void delete(User user);
}
