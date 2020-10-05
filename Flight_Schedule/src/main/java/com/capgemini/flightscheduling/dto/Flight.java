package com.capgemini.flightscheduling.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                                     
@Table(name="flight_table")                         

public class Flight {
	
    @Id                                           
    @Column(name="flight_number",length=10)         
	public String flightNumber;
    
    @Column(name="carrier_name",length=20)
	public String carrierName;
    
    @Column(name="flight_model",length=20)
	public String flightModel;
    
    @Column(name="seat_capacity",length=4)
	public int seatCapacity;
  
    //default constructor
	public Flight() {
		// TODO Auto-generated constructor stub
		super();	                                
	}

	public Flight(String flightNumber, String flightModel, String carrierName, int seatCapacity) {
		
		super();
		this.flightNumber = flightNumber;                
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}
	
	/**
	 *Public getter and setter for the private variables declared
	 */
	
	public String getFlightNumber() {                        
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {               
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {                         
		return flightModel;
	}

	public void setFlightModel(String flightModel) {             
		this.flightModel = flightModel;
	}

	public String getCarrierName() {                           
		return carrierName;
	}

	public void setCarrierName(String carrierName) {                   
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {                              
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {             
		this.seatCapacity = seatCapacity;
	}

}