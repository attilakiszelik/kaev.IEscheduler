package com.kaev.IEscheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kaev.IEscheduler.authentication.myAuthenticationFacade;
import com.kaev.IEscheduler.domain.Event;
import com.kaev.IEscheduler.service.EventService;

@Controller
public class EventController {
	
	//teszt

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private myAuthenticationFacade authenticationFacade;

	private EventService eventService;
	
	@Autowired	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	@PostMapping("/newEvent")
	public String newEvent(@ModelAttribute Event event) {
		
		Authentication authentication = authenticationFacade.getAuthentication();
        String userEmail = authentication.getName();
		
		log.debug("új időpont fogalalás");
		log.debug("dátum: " + event.getDate());
		log.debug("időpont: " + event.getTime());
		log.debug("user: " + userEmail);
		log.debug("rendszám: " + event.getSelectedRegnum());
		log.debug("feladat: " + event.getSelectedService());
		
		eventService.newEvent(event.getDate(), event.getTime(), userEmail, event.getSelectedRegnum(), event.getSelectedService());
		
		return "redirect:/scheduler";
	}
	
}
