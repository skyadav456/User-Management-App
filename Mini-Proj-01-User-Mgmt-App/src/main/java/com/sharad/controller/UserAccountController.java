package com.sharad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/edit")
	public String editUserAccount(@RequestParam("id") Integer userId, Model model) {
		UserAccount user = userAccountService.getUserAccountBy(userId);
		model.addAttribute("User" ,user);
		return "index"; 
	}
	
	@GetMapping("/delete")
	public String deleteUserAccount(@RequestParam("id") Integer userId) {
		boolean deleteUserAccount = userAccountService.deleteUserAccount(userId);
		return "redirect:/users"; // Redirect to the user list after deletion
	}
	
	@GetMapping("/update")
	public String updateUserStatus(@RequestParam("id") Integer userId, 
														@RequestParam("status") String status) {
		userAccountService.updateUserStatus(userId, status);
		return "redirect:/users"; // Redirect to the user list after updating status
	}
}
