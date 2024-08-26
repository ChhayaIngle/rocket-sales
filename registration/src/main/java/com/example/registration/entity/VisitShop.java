package com.example.registration.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employee_name;
    private String role;
    private String shop_name;
    private String shop_address;
    private LocalDateTime visiting_date_time;
    private String reason_for_visit;
    @Lob
    private byte image; 
	
    // Getters and setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public LocalDateTime getVisiting_date_time() {
		return visiting_date_time;
	}
	public void setVisiting_date_time(LocalDateTime visiting_date_time) {
		this.visiting_date_time = visiting_date_time;
	}
	public String getReason_for_visit() {
		return reason_for_visit;
	}
	public void setReason_for_visit(String reason_for_visit) {
		this.reason_for_visit = reason_for_visit;
	}
	public byte getImage() {
		return image;
	}
	public void setImage(byte image) {
		this.image = image;
	}

	
}
