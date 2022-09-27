package com.food.swipe.user.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usr_prmsn_tbl")
public class UserPermissionTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_permission_id")
	private Long userPermissionId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "is_enabled")
	private boolean isEnabled;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "creation_time")
	private Timestamp creationTime;
	
	@Column(name = "updation_time")
	private Timestamp updationTime;
}
