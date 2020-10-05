package com.capgemini.flightscheduling.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flightscheduling.dao.AirportDAO;
import com.capgemini.flightscheduling.dao.FlightDAO;
import com.capgemini.flightscheduling.dao.FlightSchedulingDAO;
import com.capgemini.flightscheduling.dto.Airport;
import com.capgemini.flightscheduling.dto.Flight;
import com.capgemini.flightscheduling.dto.FlightSchedule;

@Service                     
@Transactional                
/**
 * This class implements the FlightServiceInterface interface and performs crud operations
 * @author vamshidhar
 *
 */
public class FlightSchedulingService implements FlightSchedulingInterface {

	@Autowired(required = true)
	FlightSchedulingDAO flight_Scheduling_DAO;
	
	 @Autowired
	   FlightDAO fdao;
	   public void setFdao(FlightDAO fdao) { this.fdao=fdao; }
	   
	   @Autowired
		AirportDAO adao;
		public void setAdao(AirportDAO adao) { this.adao=adao;}
  
	
	    
		@Override  
		/**
		 * Adding the flightschedule into the database
		 */
		public FlightSchedule addFlightSchedule(FlightSchedule flight_Schedule)
	    {
			 return flight_Scheduling_DAO.save(flight_Schedule);
		}
		
	    //To view All FlightSchedules	
		@Override  
		/**
		 * Returning the list of flightschedule objects
		 */
		public List<FlightSchedule> viewFlightSchedules()
	    {	
				return flight_Scheduling_DAO.findAll();
		}

		
		@Override  
		/**
		 * Getting the flightschedule object and then setting the varibles with the new object values
		 */
		public void updateFlightSchedule(FlightSchedule flight_Schedule)
		{
			FlightSchedule f = flight_Scheduling_DAO.findById(flight_Schedule.getScheduleId()).get();
			f.setFare(flight_Schedule.getFare());
			f.setArrival(flight_Schedule.getArrival());
			f.setDeparture(flight_Schedule.getDeparture());
		}

		
		@Override 
		/**
		 * searching a flightschedule with scheduleId and returning the object
		 */
		public Optional<FlightSchedule> viewFlightSchedule(String scheduleId) 
		{
			return flight_Scheduling_DAO.findById(scheduleId);
		}

		
		@Override  
		/**
		 * deleting the flightschedule with its scheduleId and returning the string
		 */
		public void deleteFlightSchedule(String scheduleId) {

			flight_Scheduling_DAO.deleteById(scheduleId);
			
		}
		
		 @Transactional()
		   public Optional<Flight> getFlight(String flightNumber)
		   {
			   return fdao.findById(flightNumber);
		   }
		 
		//view airport by Id
			@Transactional()
			public Optional<Airport> getAirport(String airportCode)
			{
				return adao.findById(airportCode);
			}
			
		
}