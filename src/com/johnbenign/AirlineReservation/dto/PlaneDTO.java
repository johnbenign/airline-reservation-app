package com.johnbenign.AirlineReservation.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class PlaneDTO
{
	@Column(name="MODEL")
    private Short model;

    @Id
    @Column(name="PLANE_ID")
    private String planeId;

    @Column(name="COMPANY")
    private Short company;

    @Column(name="NUMBER_OF_SEATS")
    private Integer numberOfSeats;

	public Short getModel() {
		return model;
	}

	public void setModel(Short model) {
		this.model = model;
	}

	public String getPlaneId() {
		return planeId;
	}

	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	public Short getCompany() {
		return company;
	}

	public void setCompany(Short company) {
		this.company = company;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
    
    
}
