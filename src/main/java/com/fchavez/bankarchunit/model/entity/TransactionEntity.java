package com.fchavez.bankarchunit.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class TransactionEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	private String type;
	@Column(name = "creationdate")
	private String creationDate;
	@Column(name = "accountid")
	private Integer accountId;
 
 
	public TransactionEntity() {
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
		this.setCreationDate(dateFormat.format(date));
    }
 
	public Integer getId() {
		return id;
	}
 
	public String getCreationDate() {
		return creationDate;
	}
 
	public void setCreationDate(String creationDate) {	
		this.creationDate = creationDate;   
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public Double getAmount() {
		return amount;
	}
 
	public void setAmount(Double amount) {
		this.amount = amount;
	}
 
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
 
	public Integer getAccountId() {
		return accountId;
	}
 
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}