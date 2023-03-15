package com.example.ExpenseTrackerApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "/user_tbl")
public class User {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "userName is requried")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String userName;
	
	@NotBlank(message="Email is requried")
    @Email(message ="Invalid email format")
	private String email;
	
	@NotBlank(message = "Password is requried")
	@Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
	private String password;
	
}
