package com.io;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="TAX_TYPE")
public class TaxType implements Serializable{
	
	private static final long serialVersionUID = -8767337896773261247L;

	@Id
	private Integer id; 
	private String taxTypeName;
    private Float vat;
    private Float advancedVat;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaxTypeName() {
		return taxTypeName;
	}
	public void setTaxTypeName(String taxTypeName) {
		this.taxTypeName = taxTypeName;
	}
	public Float getVat() {
		return vat;
	}
	public void setVat(Float vat) {
		this.vat = vat;
	}
	public Float getAdvancedVat() {
		return advancedVat;
	}
	public void setAdvancedVat(Float advancedVat) {
		this.advancedVat = advancedVat;
	}
	 
 	
	  
}