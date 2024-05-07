package com.johnbenign.AirlineReservation.bo;

import java.util.List;

import com.johnbenign.AirlineReservation.dto.CommonDTO;
import com.johnbenign.AirlineReservation.dto.ResponseDTO;
import com.johnbenign.AirlineReservation.dto.UserDTO;

public interface Maintainable
{	
	ResponseDTO create(CommonDTO commonDTO);
	
	CommonDTO getById(Integer key);
	
	ResponseDTO edit(CommonDTO commonDTO);
	
	List<CommonDTO> getAll();
	
	ResponseDTO delete(Integer key);
	
}
