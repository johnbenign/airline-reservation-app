package com.johnbenign.AirlineReservation.dao;

import com.johnbenign.AirlineReservation.bo.ConnectionManager;
import com.johnbenign.AirlineReservation.config.ObjectFactory;
import com.johnbenign.AirlineReservation.dto.UserDTO;
import com.johnbenign.AirlineReservation.factory.AbstractFactory;

public class CommonDAO
{
	protected String userId;
	protected String errorMsg;
    protected UserDTO userDTO;
    
    protected ObjectFactory factory;
    
    public CommonDAO()
    {
    	factory = ConnectionManager.getFactory();
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
    
    //protected PersistenceManager pm;
}
