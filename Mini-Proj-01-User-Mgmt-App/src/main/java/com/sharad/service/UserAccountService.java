package com.sharad.service;

import java.util.List;

import com.sharad.entity.UserAccount;

public interface UserAccountService {
		
		public String saveOrUpdateUserAccount(UserAccount userAccount);
		public List<UserAccount>getAllUserAccounts();
		public UserAccount getUserAccountBy(Integer userId);   // get Single User Account by userId to edit or view
		public boolean	 deleteUserAccount(Integer userId);  // delete User Account by 
        public boolean updateUserStatus(Integer userId, String status); // update User Account status (active/inactive)
		

}
