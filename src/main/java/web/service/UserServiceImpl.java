package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.Car;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

private UserDao userDao = new UserDaoImpl();
    @Override
    public List<Car> listUsers(Integer count) {
        return userDao.listUsers(count);
    }
}
