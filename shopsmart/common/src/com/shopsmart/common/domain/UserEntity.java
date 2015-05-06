package com.shopsmart.common.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SS_USER")
public class UserEntity {

	@Id
	@Column(name = "USERID")
	@GeneratedValue
	private int userId;

	@NotEmpty
	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "LOGINEMAIL")
	private String loginEmail;

	@NotEmpty
	@Column(name = "CURRENTPASSWORD")
	private String currentPassword;

	@NotEmpty
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;

	@NotEmpty
	@Column(name = "DATEUPDATED")
	private Timestamp dateUpdated;

	@NotEmpty
	@Column(name = "UPDATEDBY")
	private int updatedBy;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", loginEmail=" + loginEmail + "]";
	}
}