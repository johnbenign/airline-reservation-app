package com.johnbenign.AirlineReservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PAYMENT")
public class PaymentInfo extends CommonDTO
{
	@Id
	@Column(name="PAYMENT_ID")
	private String paymentId;
	
	@Column(name="PAYMENT_METHOD")
	private Short paymentMethod;
	
	@Column(name="AMOUNT_PAID")
	private Double amountPaid;
	
	@Column(name="DATE_OF_PAYMENT")
	private java.util.Date dateOfPayment;
	
	public String getPaymentId()
	{
		return paymentId;
	}
	public void setPaymentId(String paymentId)
	{
		this.paymentId = paymentId;
	}
	public Short getPaymentMethod()
	{
		return paymentMethod;
	}
	public void setPaymentMethod(Short paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}
	public Double getPaymentAmount()
	{
		return amountPaid;
	}
	public void setPaymentAmount(Double paymentAmount)
	{
		this.amountPaid = paymentAmount;
	}
	public java.util.Date getPaymentDate()
	{
		return dateOfPayment;
	}
	public void setPaymentDate(java.util.Date paymentDate)
	{
		this.dateOfPayment = paymentDate;
	}
}
