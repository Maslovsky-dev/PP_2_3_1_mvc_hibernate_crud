package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private static final List<Car> cars = List.of(new Car("BMW","X6","Semen"),
            new Car("BMW","X5","Jon"),
            new Car("Tesla","Model_T","Bob"),
            new Car("Toyota","Outlander","Mark"),
            new Car("Nissan","Skyline","Sam"));


    @Override
    public List<Car> listUsers(Integer count) {
        if (count == null || count > 5) {
            return cars;
        }
        if (count <= 0) {
            throw new RuntimeException("Некоректный ввод");
        }
        return cars.stream().limit(count).toList();
    }
}
