package com.sharad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharad.entity.UserAccount;
import com.sharad.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
		@Autowired
	    private UserAccountRepo userAccountRepo;

	@Override
	public String saveOrUpdateUserAccount(UserAccount userAccount) {
		Integer userId= userAccount.getUserId();
		 userAccountRepo.save(userAccount);
		if(userId == null) {
			return "User Account created Successfully" ;
		}else {
			return "User Account updated Successfully ";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepo.findAll();
		
	}

	@Override
	public UserAccount getUserAccountBy(Integer userId) {
		Optional<UserAccount> opt = userAccountRepo.findById(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAccount(Integer userId) {
		
		boolean existsById = userAccountRepo.existsById(userId);
		if(existsById) {
			userAccountRepo.deleteById(userId);
			return true;
		}else {
			return false;
		} 
		
	}

	@Override
	public boolean updateUserStatus(Integer userId, String status) {
		try {
		userAccountRepo.updateUserStatus(userId, status);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
