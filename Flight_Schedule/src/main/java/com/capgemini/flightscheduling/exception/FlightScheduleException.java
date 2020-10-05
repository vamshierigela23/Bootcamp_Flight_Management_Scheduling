package com.capgemini.flightscheduling.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice                               

/**
 * @ControllerAdvice is an annotation provided by Spring allowing you to write
 *                   global code that can be applied to a wide range of
 *                   controllers
 *
 */

public class FlightScheduleException extends Exception
{
	
private static final long serialVersionUID = 1L;

@ExceptionHandler(value={FlightScheduleNotFoundException.class })    

	public ResponseEntity<Object> exception(FlightScheduleNotFoundException exception)
	
	{
	      return new ResponseEntity<>("Flight Schedule not found", HttpStatus.NOT_FOUND);
	}

}