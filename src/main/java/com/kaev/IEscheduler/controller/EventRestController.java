package com.kaev.IEscheduler.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaev.IEscheduler.authentication.myAuthenticationFacade;
import com.kaev.IEscheduler.domain.Event;
import com.kaev.IEscheduler.service.EventService;

@RestController
@RequestMapping("/getMyBookings")
public class EventRestController {

    @Autowired
    private myAuthenticationFacade authenticationFacade;
	    
    private EventService eventService;
    
	@Autowired	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping
	public Map<Long, Map<String, String>> myBookings(){
		
		Authentication authentication = authenticationFacade.getAuthentication();
        String userEmail = authentication.getName();
		
        List<Event> myBookings = eventService.getMyBookings(userEmail);
        
        Map<Long, Map<String, String>> bookings = new HashMap<>();
        
        for (Event n : myBookings) {
        	
        	Map<String, String> booking = new HashMap<>();
        	
        	booking.put("date:", n.getDate().toString());
        	booking.put("time:", n.getTime());
        	booking.put("regnum:", n.getVehicle().getRegnum());
        	booking.put("service:", n.getService().getTextOfService_TYPE());
        	booking.put("status:", n.getStatus());
        	
        	bookings.put(n.getId(), booking);
        }
        
        return bookings; 
	
	}
	
}
