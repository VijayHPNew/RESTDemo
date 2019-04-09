package com.loyaltyone.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Message {
	
	@Id
	@SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	private int id;	
	
	private String message;	
	private String userName;
	
	@Column(name="Created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date objDate = new Date();

	public Message() {

	}
	
	public Message(int id, String message, String userName, Date objDate) {
		super();
		this.id = id;
		this.message = message;
		this.userName = userName;
		this.objDate = objDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getObjDate() {
		return objDate;
	}

	public void setObjDate(Date objDate) {
		this.objDate = objDate;
	}
}
