package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<User> allUsers = userService.listUsers();
		model.addAttribute("allUsers", allUsers);
		return "main";
	}
	
}