package com.loyaltyone.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class User {

	/*
	@Id
	@SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	private String id;
	*/

	private String strFirstName;
	private String strLastName;
	private String strAddress;
	private String strPhone;
	@Id
	private String strEmail;
	
	@Column(name="Created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date objDate = new Date();

	public User() {

	}

	public User(String strFirstName, String strLastName, String strAddress, String strPhone, String strEmail,
			Date objDate) {
		super();
		this.strFirstName = strFirstName;
		this.strLastName = strLastName;
		this.strAddress = strAddress;
		this.strPhone = strPhone;
		this.strEmail = strEmail;
		this.objDate = objDate;
	}



	public String getStrFirstName() {
		return strFirstName;
	}


	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}


	public String getStrLastName() {
		return strLastName;
	}


	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}


	public String getStrAddress() {
		return strAddress;
	}


	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}


	public String getStrPhone() {
		return strPhone;
	}


	public void setStrPhone(String strPhone) {
		this.strPhone = strPhone;
	}


	public String getStrEmail() {
		return strEmail;
	}


	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public Date getObjDate() {
		return objDate;
	}

	public void setObjDate(Date objDate) {
		this.objDate = objDate;
	}
}
