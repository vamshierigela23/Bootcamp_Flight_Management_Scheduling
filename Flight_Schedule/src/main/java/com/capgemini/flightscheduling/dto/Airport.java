package com.capgemini.flightscheduling.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="airport_table")   

public class Airport 
{
	
    @Id                                        
    @Column(name="airport_code",length=10)         
    String airportCode;
    
    @Column(name="airport_name",length=10)
    String airportName;
    
    @Column(name="airport_location",length=10)
    String airportLocation;
    
	public Airport() {
		
		super();                             
	}
	public Airport(String airportCode, String airportName, String airportLocation) 
	
	{
		super();
		this.airportCode = airportCode;          
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	
	/**
	 *Public getter and setter for the private variables declared
	 */
	
	public String getAirportCode() {                    
		return airportCode;
	}
	
	public void setAirportCode(String airportCode) {          
		this.airportCode = airportCode;
	}
	
	public String getAirportName() {                    
		return airportName;
	}
	
	public void setAirportName(String airportName) {          
		this.airportName = airportName;
	}
	
	public String getAirportLocation() {                   
		return airportLocation;
	}
	
	public void setAirportLocation(String airportLocation) {       
		this.airportLocation = airportLocation;
	}
       
}