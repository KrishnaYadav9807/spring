package com.ascoprp.model;

import javax.validation.constraints.Size;


public class User{
	
	private int userId;
	@Size(min=2)
	private String name;
	private String lastName;
	private String middleName;
	@Size(min=5, message="villgae must have atleast 5 characters")
	private String villgae;
	
	public int getUserId() {
		return userId;
	}
	public User(int userId, String name, String lastName, String middleName, String villgae) {
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
		this.villgae = villgae;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getVillgae() {
		return villgae;
	}
	public void setVillgae(String villgae) {
		this.villgae = villgae;
	}
	@Override
	public String toString() {
		return "Employee [id=" + userId + ", name=" + name + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", villgae=" + villgae + "]";
	}

}
