package com.capgemini.flightscheduling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightscheduling.dto.Flight;

@Repository
public interface FlightDAO extends JpaRepository<Flight,String>
{

}