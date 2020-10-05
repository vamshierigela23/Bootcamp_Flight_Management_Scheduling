package com.capgemini.flightscheduling.controller;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightscheduling.dao.AirportDAO;
import com.capgemini.flightscheduling.dao.FlightSchedulingDAO;
import com.capgemini.flightscheduling.dto.Airport;
import com.capgemini.flightscheduling.dto.Flight;
import com.capgemini.flightscheduling.dto.FlightSchedule;
import com.capgemini.flightscheduling.exception.FlightException;
import com.capgemini.flightscheduling.exception.FlightScheduleNotFoundException;
import com.capgemini.flightscheduling.service.FlightSchedulingService;
@RestController                                 
@CrossOrigin(origins = "http://localhost:4200")     
public class FlightSchedulingController {
	
	@Autowired                                 
	private FlightSchedulingService flight_Scheduling_Service;
	
	@Autowired
	private FlightSchedulingDAO flight_Scheduling_DAO;
	
	@Autowired
	AirportDAO airportDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightSchedulingController.class);

	
	   	
	   @PostMapping("/addFlightSchedule")   //mapping the url to add schedule
	   /**
		 * This method used to add the new schedule into the database
		 * 
		 * @param flight_schedule
		 * @return String telling that flight_schedule added
		 */
	   
	   public ResponseEntity<String> addFlightSchedule(@RequestBody FlightSchedule flight_Schedule) {
		   /**
			 * Checking whether the scheduleId is avilable or not
			 */
			if (!flight_Scheduling_DAO.existsById(flight_Schedule.getScheduleId())) {
				flight_Scheduling_Service.addFlightSchedule(flight_Schedule);
				LOGGER.info("Add Flight Schedule method is accessed");
				return new ResponseEntity<>("Flight Schedule details added", HttpStatus.OK);
		   /**
			 * Adding the flight_schedule into the Database and Returning the ResponseEntity<String>
			 * with Httpstatus and message
			 */	
			}
			else
				return new ResponseEntity<>("Flight Schedule with given id already exists", HttpStatus.ALREADY_REPORTED);
			 /**
			 * Displaying the flight_schedule already exists in the Database and Returning the ResponseEntity<String>
			 * with Httpstatus and message
			 */	
		}
		
		
		@PutMapping("/updateFlightSchedule/{id}") //mapping the url to update schedule
		/**
		 * @RequestBody is used to get the object of the class from the URL Method is
		 *              used to update the flight_schedule           
		 * @param flight_scheduling
		 * @return String that update is successful
		 */
		public ResponseEntity<Object> updateFlightSchedule(@PathVariable("id") String scheduleId, @RequestBody FlightSchedule flight_Scheduling)throws FlightScheduleNotFoundException
		{
			 /**
			 * Checking whether the scheduleId is avilable or not
			 */
			if (flight_Scheduling_DAO.existsById(scheduleId))         
			{
				flight_Scheduling_Service.updateFlightSchedule(flight_Scheduling);
				LOGGER.info("update Flight Schedule method is accessed");
				return new ResponseEntity<>("Flight Schedule is updated successsfully", HttpStatus.OK);
			
			}
			else  
		  /**
			* Else return that flight_schedule_NotFoundException
			 */
			{
				throw new FlightScheduleNotFoundException(scheduleId, null);
			}
		}
		

		
		@GetMapping("/viewFlightSchedule/{id}")  //mapping the url to view schedule with id
		/**
		 * @PathVariable is used to extract the variable from the URL This method
		 *               searches for the flightschedule with particular scheduleId
		 * @param scheduleId
		 * @return Flight_Schedule object if available else throws an exception
		 */
		public ResponseEntity<Object> viewFlightSchedule(@PathVariable("id") String scheduleId)
		{
		    Optional<FlightSchedule> flightSchedule= flight_Scheduling_DAO.findById(scheduleId);
		    if (flightSchedule.isPresent())               
		    {
		      LOGGER.info("View Flight Schedule method is accessed");	
		      return new ResponseEntity<>(flightSchedule.get(), HttpStatus.OK);
		    }
		    else                                       
		    {
		      return new ResponseEntity<>("Flight Schedule not found",HttpStatus.NOT_FOUND);
		    }
		 }
		
		
		//view FlightSchedules
		@GetMapping("/viewFlightSchedule") //mapping the url to view all schedule
		/**
		 * This method used to get all the flightschedules that are available
		 * 
		 * @return List of Flight_Schedule objects
		 */
		public ResponseEntity<Object> viewFlightSchedules()
		{
			List<FlightSchedule> flightScheduleList = flight_Scheduling_Service.viewFlightSchedules();
			return new ResponseEntity<>(flightScheduleList, HttpStatus.OK);
		}

		
		
		@DeleteMapping("/deleteFlightSchedule/{id}")  //mapping the url to delete schedule
		/**
		 * This method used to delete the flightschedule with particular scheduleid
		 * 
		 * @param scheduleId
		 * @return String that flightschedule is deleted successfully else throws an
		 *         Flight_schedule_NotFoundException
		 */
		public ResponseEntity<Object> deleteFlightSchedule(@PathVariable("id") String scheduleId)throws FlightScheduleNotFoundException
		{
			if (flight_Scheduling_DAO.existsById(scheduleId))   
		/**
		  * Checking whether the scheduleId is avilable or not
		  */
			{
				flight_Scheduling_Service.deleteFlightSchedule(scheduleId);
				LOGGER.info("Delete Flight Schedule method is accessed");
				return new ResponseEntity<>("Flight Schedule is deleted successsfully", HttpStatus.OK);
			}
			else                                               
			{
				throw new FlightScheduleNotFoundException(scheduleId, null);
			}
		}
		
		@GetMapping(value="/getFlight/{flightNumber}",produces="application/json")
		public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightNumber) throws FlightException
		{
			String msg = "View the flight:";
			LOGGER.info(msg);
			Optional<Flight> flight =  flight_Scheduling_Service.getFlight(flightNumber);
			if(flight.isPresent())
				return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.OK);
			return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.NOT_FOUND);
		}
		
		//view airport by ID
		@GetMapping("/getAirport/{id}")
		public ResponseEntity<Object> getAirport(@PathVariable("id") String airportCode)
		{
		    Optional<Airport> airport = airportDao.findById(airportCode);
		    if (airport.isPresent())
		    {
		      LOGGER.info("Get Airport method is accessed");	
		      return new ResponseEntity<>(airport.get(), HttpStatus.OK);
		    }
		    else
		    {
		      return new ResponseEntity<>("Airport not found",HttpStatus.NOT_FOUND);
		    }
		 }
		
}