package com.flightschedulingtestcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.capgemini.flightscheduling.dao.FlightSchedulingDAO;
import com.capgemini.flightscheduling.dto.FlightSchedule;
import com.capgemini.flightscheduling.service.FlightSchedulingService;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightSchedulingServiceTest {
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private FlightSchedulingDAO flightScheduleDao;
	@InjectMocks
	private FlightSchedulingService flightScheduleService;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testGetFlightScheduleList(){
		List<FlightSchedule> flightScheduleList = new ArrayList<FlightSchedule>();
		flightScheduleList.add(new FlightSchedule("RQ23",null,null,null,3000,null,null));
		flightScheduleList.add(new FlightSchedule("RE32",null,null,null,3500,null,null));
		when(flightScheduleDao.findAll()).thenReturn(flightScheduleList);
		assertEquals(2, flightScheduleList.size());
	}
	@Test
	public void testAddFlightSchedule() {
		FlightSchedule flightSchedule=new FlightSchedule("RQ23",null,null,null,3000,null,null);
		flightSchedule.setScheduleId("RQ23");
		flightSchedule.setFlight(null);
		flightSchedule.setSource(null);
		flightSchedule.setDestination(null);
		flightSchedule.setFare(3000);
		flightSchedule.setArrival(null);
		flightSchedule.setDeparture(null);
		flightScheduleDao.save(flightSchedule);
	
	}
	
	@Test
	public void testUpdateFlightSchedule() {
		FlightSchedule flightSchedule=new FlightSchedule("RQ23",null,null,null,3000,null,null);
		flightScheduleDao.findById("RQ23");
		flightScheduleDao.save(flightSchedule);
	   verify(flightScheduleDao, Mockito.times(1)).save(flightSchedule);
	}
	
	@Test
	public void testDeleteFlightSchedule(){
	FlightSchedule flightSchedule=new FlightSchedule("RQ23",null,null,null,3000,null,null);
	flightScheduleDao.deleteById("RQ23");
	verify(flightScheduleDao, times(1)).deleteById("RQ23");
	}
	
	@Test
	public void testViewFlightSchedule(){
	FlightSchedule flightSchedule=new FlightSchedule("RQ23",null,null,null,3000,null,null);
	flightScheduleDao.findById("RQ23");
	verify(flightScheduleDao, times(1)).findById("RQ23");
	}

}