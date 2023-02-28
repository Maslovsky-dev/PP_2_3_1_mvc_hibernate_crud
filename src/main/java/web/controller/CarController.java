package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private static final List<Car> cars = List.of(new Car("BMW","X6","Semen"),
            new Car("BMW","X5","Jon"),
            new Car("Tesla","Model_T","Bob"),
            new Car("Toyota","Outlander","Mark"),
            new Car("Nissan","Skyline","Sam"));


    public List<Car> getCars() {
        return cars;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam (value = "count",required = false) Integer count,
                               Model model) {
        UserService userService = new UserServiceImpl();
        model.addAttribute("cars",userService.listUsers(count));
        System.out.println();
        userService.listUsers(count).forEach(System.out::println);
        return "cars";
    }
}
