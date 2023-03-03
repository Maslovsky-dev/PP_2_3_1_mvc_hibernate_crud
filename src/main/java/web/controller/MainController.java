package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/")
	public String printWelcome(Model model) {
		model.addAttribute("allUsers", userService.listUsers());
		return "main";
	}
	@RequestMapping(value = "/{id}")
	public String printWelcome(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user",userService.userById(id));
		return "main-1-user";
	}

	@RequestMapping(value = "/addNewUser")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-info";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute ("user") User user) {
		userService.add(user);
		return "redirect:/";
	}
//	@RequestMapping("/updateInfo")
//	public String updateUser () {
//
//	}
	
}