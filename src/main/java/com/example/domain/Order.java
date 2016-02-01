package com.example.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue
	private Integer id;
	//@Column(nullable = false)
	private String firstName;
	//@Column(nullable = false)
	private int volume;
	private String date;
	private Boolean done;
	
	public void setDate(){
		Calendar calendar = Calendar.getInstance();
		System.out.println("test:" + calendar.getTime().toString());
		this.date = calendar.getTime().toString();
	}
	
	public void resetDone() {
		this.done = false;
	}
	
	public void setDone() {
		this.done = true;
	}
	
}
