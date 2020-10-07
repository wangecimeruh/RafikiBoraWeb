package Rafiki.Bora.Microfinance.service.userService;

import Rafiki.Bora.Microfinance.dao.userDao.UserDaoI;
import Rafiki.Bora.Microfinance.model.users.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDaoI dao;

    public User register(User user) throws Exception {
        if (user == null)
            throw new Exception("No user details");
        return dao.save(user);
    }

    public User login(String email, String password) throws Exception {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            throw new Exception("Invalid user details");
        }
        return dao.login(email, password);

    }
}