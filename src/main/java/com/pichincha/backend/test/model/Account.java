package com.pichincha.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String number;

	@Column(length = 70)
	private String type;

	private LocalDateTime creationDate;
	@OneToMany(mappedBy="account")  
	private List<Transaction> transactions;  

	public String getNumber() {
		return number;
	}
	public List<Transaction> getTransactions(){
		return transactions;
	}

	public void setNumber(String title) {
		this.number = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String content) {
		this.type = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

}
