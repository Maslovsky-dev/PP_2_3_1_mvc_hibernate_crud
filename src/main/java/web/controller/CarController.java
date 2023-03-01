package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;


@Controller
public class CarController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam (value = "count",required = false) Integer count,
                               Model model) {

        model.addAttribute("cars",userService.listUsers(count));

        System.out.println();
        userService.listUsers(count).forEach(System.out::println);
        return "cars";
    }
}
