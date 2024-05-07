package com.johnbenign.AirlineReservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TICKET")
public class TicketDTO extends ActivityDTO
{
	@Id
	@Column(name="TICKET_ID")
	private String ticketId;
	
	@Column(name="FLIGHT_ID")
	private String flightId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="CLASS_TYPE")
	private Short classType;//business class, economy class or first class
	
	@Column(name="PAYMENT_ID")
	private String paymentId;
	
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Short getClassType() {
		return classType;
	}
	public void setClassType(Short classType) {
		this.classType = classType;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
}
