package com.io;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name="TAX")
public class Tax implements Serializable{
	
	private static final long serialVersionUID = -8767337896773261247L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
	 
	private String description;
 
	@ManyToOne
	@JoinColumn(name="taxTypeId")
	private TaxType taxTypeId;
	
	
	
	@ManyToOne
	@JoinColumn(name="status")
	private Status status;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public TaxType getTaxTypeId() {
		return taxTypeId;
	}



	public void setTaxTypeId(TaxType taxTypeId) {
		this.taxTypeId = taxTypeId;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}
	
	  	 
}
