package com.example.registration.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String employee_name;
	private Long employee_id;
	private String gender;
	private Long mobile_number;
	private String employee_role;
	private LocalDate start_date;
	private LocalDate deadline;
	private LocalDate completion;
	private String task_name;
	private String location;
	private String task_status;

	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}
	
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public LocalDate getCompletion() {
		return completion;
	}
	public void setCompletion(LocalDate completion) {
		this.completion = completion;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	
	
	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTitle(Object title) {
		// TODO Auto-generated method stub
		
	}
		
}
