package com.capgemini.flightscheduling.service;
import java.util.List;
import java.util.Optional;

import com.capgemini.flightscheduling.dto.Airport;
import com.capgemini.flightscheduling.dto.Flight;
import com.capgemini.flightscheduling.dto.FlightSchedule;
import com.capgemini.flightscheduling.dto.FlightSchedule;
/**
 * Interface declaring the methods for crud operations
 */
public interface FlightSchedulingInterface 
{
	public FlightSchedule addFlightSchedule(FlightSchedule flight_Schedule);
	
	public void updateFlightSchedule(FlightSchedule flight_Schedule);
	
	public Optional<FlightSchedule> viewFlightSchedule(String scheduleId );
	
	public void deleteFlightSchedule(String scheduleId);
	
	public List<FlightSchedule> viewFlightSchedules();
	
	 public Optional<Flight> getFlight(String flightNumber);
	 
	 public Optional<Airport> getAirport(String airportCode);
}