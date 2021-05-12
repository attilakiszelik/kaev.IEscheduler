package com.kaev.IEscheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kaev.IEscheduler.domain.Event;
import com.kaev.IEscheduler.service.EventService;

@Controller
public class EventController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private EventService eventService;
	
	@PostMapping("/newEvent")
	public String newEvent(@ModelAttribute Event event) {
		
		eventService.newEvent(event.getDate(), event.getTime(), event.getVehicle().getRegnum(), event.getService().getTextOfService_TYPE());
		
		log.debug("");
		log.debug("új időpont fogalalás");
		log.debug("dátum: " + event.getDate());
		log.debug("időpont: " + event.getTime());
		log.debug("rendszám: " + event.getVehicle().getRegnum());
		log.debug("feladat: " + event.getService().getTextOfService_TYPE());

		return "redirect:/scheduler";
	}
	
}
