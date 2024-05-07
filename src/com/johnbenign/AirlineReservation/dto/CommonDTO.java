package com.johnbenign.AirlineReservation.dto;

public class CommonDTO
{
    protected Boolean enabled = true;
   
     protected String createdAt;
     protected String modifiedAt;
     protected String key;
     protected String errorMsg;
     protected java.util.HashMap<Integer, Boolean> editedFields;
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
	}
	public String getCreatedAt()
	{
		return createdAt;
	}
	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}
	public String getModifiedAt()
	{
		return modifiedAt;
	}
	public void setModifiedAt(String modifiedAt)
	{
		this.modifiedAt = modifiedAt;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getErrorMsg()
	{
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
	public java.util.HashMap<Integer, Boolean> getEditedFields()
	{
		return editedFields;
	}
	public void setEditedFields(java.util.HashMap<Integer, Boolean> editedFields)
	{
		this.editedFields = editedFields;
	}
     
     
}
