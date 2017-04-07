package com.iris.employ.domain;

import java.util.HashSet;
import java.util.Set;

/*
 *部门的实体 
 */
public class Department {
	private Integer did;
	private String dname;
	private String ddesc;
	//员工集合
	private Set<Employee> employees = new HashSet<Employee>();
	public Set<Employee> getEmployees() {
		return employees;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getNname() {
		return dname;
	}
	public void setNname(String nname) {
		this.dname = nname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
}
