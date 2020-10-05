package com.capgemini.flightscheduling.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.flightscheduling.dto.FlightSchedule;
/**
 * JpaRepository contains methods for performing CRUD operations
 */
public interface FlightSchedulingDAO extends JpaRepository<FlightSchedule,String>
{
	
}