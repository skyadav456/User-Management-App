package com.sharad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharad.entity.UserAccount;

import jakarta.transaction.Transactional;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE UserAccount u SET u.isActiveSw = :status WHERE u.userId = :userId")
	public void updateUserStatus(Integer userId, String status); // Custom method to update user status
	

}
