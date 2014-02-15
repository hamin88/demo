package com.io;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
 
@Component
@Entity
@Table(name="STATUS")
public class Status implements Serializable{
	
	private static final long serialVersionUID = -8767337896773261247L;

	private Integer id; 
	private String statusName;
	@Id
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="statusName")
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "Status [id=" + id + ", statusName=" + statusName + "]";
	}
	
	  
}