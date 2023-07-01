package com.bbit.app.bbithotelbooking.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.entity.UserEntity;
import com.bbit.app.bbithotelbooking.repository.UserRepository;
import com.bbit.app.bbithotelbooking.service.UserService;

/**
 * This Controller is used for GET, UPDATE, DELETE user details
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userRepo;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserEntity userEntity = userRepo.findByEmail(email);
		User user = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getFirstName(),
				userEntity.getLastName(), userEntity.getMobileNo(), userEntity.getRole());

		m.addAttribute("user", user);

	}
	
	@GetMapping("/user/home")
	public String home() {
		return "/home";
	}
	 

	@GetMapping("/user/new")
	public String createUserForm(Model model) {

		// create student object to hold student form data
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";

	}
	
	@PostMapping("/user/addUser")
	public String createuser(@ModelAttribute User user, HttpSession session) {
		
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			userService.createUser(user);
		}

		return "redirect:/user/users";
	}

	@GetMapping
	public User getUserByEmail(@RequestParam("email") String email) throws Exception {
		return userService.getUserByEmail(email);
	}

	@GetMapping("/user/users")
	public String getAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/user/update/{email}")
	public String editUserForm(@PathVariable String email, Model model) throws Exception {
		model.addAttribute("user", userService.getUserByEmail(email));
		return "edit_user";
	}

	@PostMapping("/updateUser/{email}")
	public String updateUser(@PathVariable String email, @ModelAttribute("user") User user, Model model)
			throws Exception {

		// get user from database by id
		userService.updateUser(email, user);
		return "redirect:/user/users";
	}
	
	@GetMapping("/deleteUser/{email}")
	public String deleteUSer(@PathVariable String email)
			throws Exception {

		userService.deleteUser(email);
		return "redirect:/user/users";
	}

}
