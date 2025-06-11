package com.sharad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sharad.entity.UserAccount;
import com.sharad.service.UserAccountService;

@Controller
public class UserAccountController {
	
	@Autowired
	UserAccountService userAccountService;
	@GetMapping("/")
	public String showUserAccountForm(Model model) {
		model.addAttribute("User" ,new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
	public String handleSubmitForm(UserAccount userAccount, Model model) {
		userAccountService.saveOrUpdateUserAccount(userAccount);
		model.addAttribute("message", "User Account saved successfully!");
		model.addAttribute("User", new UserAccount());      // Reset the form after submission
		System.out.println("userAccount = " + userAccount);
		return "index";
	}
	
	@GetMapping("/users")
	public String getAllUserDetails(Model model) {
		List<UserAccount> usersList = userAccountService.getAllUserAccounts();
		model.addAttribute("users", usersList);
		return "view-user"; // Assuming you have a userList.html template to display the list of users
	}

}
