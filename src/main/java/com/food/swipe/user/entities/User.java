package com.food.swipe.user.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_enabled")
	private boolean isEnabled;

	@Column(name = "last_login_time")
	private Timestamp lastLoginTime;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;

	@CreationTimestamp
	@Column(name = "creation_time")
	private Timestamp creationTime;

	@UpdateTimestamp
	@Column(name = "updation_time")
	private Timestamp updationTime;
	
}
