package com.capgemini.flightscheduling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flightscheduling.dto.Airport;

@Repository
public interface AirportDAO extends JpaRepository<Airport,String>
{

}