package com.capgemini.flightscheduling.dto;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity                                  
@Table(name="schedule_table")

	public class FlightSchedule 
	{
		@Id                              
		@Column(name="sched_id")              
		String scheduleId;
		
		@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)        
		@JoinColumn(name="flight_number")         
		Flight flight;
		
		@OneToOne                     
		@JoinColumn(name="source" , referencedColumnName="airport_code")
		Airport source;
		
		@OneToOne
		@JoinColumn(name="destination" , referencedColumnName="airport_code")
		Airport destination;
		
		double fare;
		
		LocalDateTime departure;
		
		LocalDateTime arrival;
		
		public FlightSchedule() {
			
			super();  
			
		}
		public FlightSchedule(String scheduleId, Flight flight, Airport source, Airport destination, double fare,
				LocalDateTime departure, LocalDateTime arrival) {
			
			super();
			this.scheduleId = scheduleId;                     
			this.flight = flight;
			this.source = source;
			this.destination = destination;
			this.fare = fare;
			this.departure = departure;
			this.arrival = arrival;
		}
		
		/**
		 *Public getter and setter for the private variables declared
		 */
		
		public String getScheduleId() {                                  
			return scheduleId;
		}
		
		public void setScheduleId(String scheduleId) {     
			this.scheduleId = scheduleId;
		}
		
		public Flight getFlight() {                        
			return flight;
		}
		
		public void setFlight(Flight flight) {                  
			this.flight = flight;
		}
		
		public Airport getSource() {                   
			return source;
		}
		
		public void setSource(Airport source) {             
			this.source = source;
		}
		
		public Airport getDestination() {                     
			return destination;
		}
		
		public void setDestination(Airport destination) {        
			this.destination = destination;
		}
		
		public double getFare() {                      
			return fare;
		}
		
		public void setFare(double fare) {                 
			this.fare = fare;
		}
		
		public LocalDateTime getDeparture() {                 
			return departure;
		}
		
		public void setDeparture(LocalDateTime departure) {         
			this.departure = departure;
		}
		
		public LocalDateTime getArrival() {                       
			return arrival;
		}
		
		public void setArrival(LocalDateTime arrival) {        
			this.arrival = arrival;
		}
		
	}