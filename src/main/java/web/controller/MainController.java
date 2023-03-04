package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	//Отображение всех пользователей
	@GetMapping(value = "/")
	public String printWelcome(Model model) {
		model.addAttribute("allUsers", userService.listUsers());
		return "index";
	}
	//Отображение пользователя по его ID
	@GetMapping (value = "/{id}")
	public String printWelcome(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user",userService.userById(id));
		return "show";
	}
	//Форма для добавления пользователя
	@GetMapping(value = "/new")
	public String addNewUser(@ModelAttribute ("user") User user) {
		return "new";
	}
	//Сохранение пользователя
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute ("user") User user) {
		userService.add(user);
		return "redirect:/";
	}
	//Форма для редактирования пользователя
	@GetMapping (value = "/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("user",userService.userById(id));
		return "edit";
	}
	@PatchMapping("/{id}")
	public  String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.update(id,user);
		return "redirect:/";
	}
}