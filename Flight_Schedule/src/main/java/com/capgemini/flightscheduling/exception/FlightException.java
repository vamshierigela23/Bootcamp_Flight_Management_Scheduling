package com.capgemini.flightscheduling.exception;

public class FlightException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public FlightException(String message)
	{
		super(message);
	}
	public FlightException()
	{
		super();
	}
}