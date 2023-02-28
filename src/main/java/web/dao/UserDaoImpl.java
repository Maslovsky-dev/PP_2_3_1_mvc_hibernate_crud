package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.controller.CarController;
import web.model.Car;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    private CarController carController = new CarController();
    @Override
    public List<Car> listUsers(Integer count) {
        if (count == null || count > 5) {
            return carController.getCars();
        }
        if (count <= 0) {
            throw new RuntimeException("Некоректный ввод");
        }
        return carController.getCars().stream().limit(count).toList();
    }
}
