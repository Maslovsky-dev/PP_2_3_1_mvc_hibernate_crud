package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String printWelcome(Model model) {
		List<User> allUsers = userService.listUsers();
		model.addAttribute("allUsers", allUsers);
		return "main";
	}

	@GetMapping(value = "/addNewUser")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-info";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute ("user") User user) {
		userService.add(user);
		return "redirect:/";
	}
	
}