package com.johnbenign.AirlineReservation.dto;

import org.springframework.stereotype.Component;

@Component
public abstract class ActivityDTO extends CommonDTO
{
	protected String activityNumber;
	protected Short activityType;
	protected String description;
	public String getActivityNumber() {
		return activityNumber;
	}
	public void setActivityNumber(String activityNumber) {
		this.activityNumber = activityNumber;
	}
	public Short getActivityType() {
		return activityType;
	}
	public void setActivityType(Short activityType) {
		this.activityType = activityType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
