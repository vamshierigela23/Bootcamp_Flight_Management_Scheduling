package com.capgemini.flightscheduling.exception;

/**
 * Flight_schedule_NotFoundException is a run time exception to handle when ever flightschedule is not available
 *
 */
public class FlightScheduleNotFoundException extends RuntimeException{
	   
	private static final long serialVersionUID = 1L;

	public FlightScheduleNotFoundException(String msg){
        super(msg);
    }

    public FlightScheduleNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}