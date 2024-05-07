package com.johnbenign.AirlineReservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="FLIGHT")
public class FlightDTO extends CommonDTO
{
	@Id
	@Column(name="FLIGHT_ID")
    private String flightId;

	@Column(name="FROM")
    private String from;

    @Column(name="PRICE")
    private Integer price;

    @Column(name="DEPARTURE_TIME")
    private java.util.Date departureTime;

    @Column(name="TO")
    private String to;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public java.util.Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(java.util.Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
    
    
}
