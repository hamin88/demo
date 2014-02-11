package com.io;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_TYPE")
public class ContactType {

	private static final long serialVersionUID = -8767337896773261247L;

	@Id
	@Column(name="id")
	private Long id;
 
	@Column(name="contactTypeName")
	private String contactTypeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactTypeName() {
		return contactTypeName;
	}

	public void setContactTypeName(String contactTypeName) {
		this.contactTypeName = contactTypeName;
	}
 
	
}
