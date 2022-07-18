package com.chainsys.jspproject.pojo;
import java.util.Date;

public class Employee {
	private int E_Id;
	private String First_Name; 
	private String Last_Name; 
	private String Email; 
	private Date Hire_Date;
	private String Job_ID;
	private float Salary;                

	public int getE_Id() {
		return E_Id;
	}
	public void setE_Id(int e_Id) {
		this.E_Id = e_Id;
	}
	
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.First_Name = first_Name;
	}
	
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.Last_Name = last_Name;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
	
	public Date getHire_Date() {
		return Hire_Date;
	}
	public void setHire_Date(Date date) {
		this.Hire_Date = date;
	}
	
	public String getJob_ID() {
		return Job_ID;
	}
	public void setJob_ID(String job_ID) {
		this.Job_ID = job_ID;
	}
	
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		this.Salary = salary;
	}
	
}
