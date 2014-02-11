package com.io;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BRANCH_TYPE")
public class BranchType {

	private static final long serialVersionUID = -8767337896773261247L;

	@Id
	@Column(name="id")
	private Long id;
 
	@Column(name="branchTypeName")
	private String branchTypeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranchTypeName() {
		return branchTypeName;
	}

	public void setBranchTypeName(String branchTypeName) {
		this.branchTypeName = branchTypeName;
	}
 
	
}
