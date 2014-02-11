package com.io;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TYPE")
public class CustomerType {

	private static final long serialVersionUID = -8767337896773261247L;

	@Id
	@Column(name="id")
	private Long id;
 
	@Column(name="CustomerTypeName")
	private String CustomerTypeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerTypeName() {
		return CustomerTypeName;
	}

	public void setCustomerTypeName(String CustomerTypeName) {
		this.CustomerTypeName = CustomerTypeName;
	}
 
	
}
