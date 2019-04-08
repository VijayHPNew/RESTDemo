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
	
	private String strMessage;	
	
	@Column(name="Created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date objDate = new Date();

	public Message() {

	}
	
	public Message(int id, String strMessage, Date objDate) {
		super();
		this.id = id;
		this.strMessage = strMessage;
		this.objDate = objDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	public Date getObjDate() {
		return objDate;
	}

	public void setObjDate(Date objDate) {
		this.objDate = objDate;
	}
}
