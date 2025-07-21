package com.bookingservice.dto;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


public class RoomAvailability {

	private long id;
	
	private LocalDate availableDate;
    private int availableCount;
    private double price;
    
    private Rooms room;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
