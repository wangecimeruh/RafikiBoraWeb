package Rafiki.Bora.Microfinance.service.userService;

import Rafiki.Bora.Microfinance.dao.userDao.UserDaoI;
import Rafiki.Bora.Microfinance.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDaoI dao;

    public void save(User user) throws Exception {

        if (user.getPerson().getEmail().isEmpty()) {
            dao.save(user);
        } else {
            System.out.println("User Already Exists!!");
        }

    }
}
