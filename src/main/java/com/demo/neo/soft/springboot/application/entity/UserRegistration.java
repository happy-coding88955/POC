package com.demo.neo.soft.springboot.application.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name="UserRegistration")
public class UserRegistration {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String userId;

	@NotBlank(message = "FirstName is mandatory")
	private String firstName;

	@NotBlank(message = "LastName is mandatory")
	private String lastName;

    @NotBlank(message = "Email is mandatory")
	private String emailId;

	private String designation;

	private String address;

	@Column(name="date_of_birth")
	private String dob;

	@Column(name="date_of_joining")
	private String joinDate;

	@NotBlank(message = "Contact No is mandatory")
	private String contactNo;

	@NotBlank(message = "Pincode is mandatory")
	private String pincode;

	public UserRegistration() {
		
	}

	public UserRegistration(String userId, String firstName, String lastName, String emailId, String designation,
			String address, String dob, String joinDate, String contactNo, String pincode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.designation = designation;
		this.address = address;
		this.dob = dob;
		this.joinDate = joinDate;
		this.contactNo = contactNo;
		this.pincode = pincode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	
	
}