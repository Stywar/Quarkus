package com.aforo255.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cusotmer")
	private Integer IdCustomer;
	@Column(name="full_name")
	private String FullName;
	public Integer getIdCustomer() {
		return IdCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	
}
