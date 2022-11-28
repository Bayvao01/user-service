package com.user.service.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

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

	@Column(name = "is_account_verified")
	private boolean accountVerified;

	@Column(name = "failed_login_attempts")
	private int failedLoginAttempts;

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

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		User user = (User) o;
		return userId != null && Objects.equals(userId, user.userId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
