package com.sharad.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserAccount {
       
	        @Id
	        @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Integer userId;
		    private String fullName;
		    private String email;
		    private Long phno;
		    private String gender;
		    private LocalDate dob;
		    private Long ssn;
		    private String isActiveSw="Y";
		    @CreationTimestamp
		    private LocalDate createdDate;
		    @CreationTimestamp
		    private LocalDate updatedDate;
		    

}
