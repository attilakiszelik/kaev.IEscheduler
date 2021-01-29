package com.example.IEscheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Jóskám") String name) {
	
		return String.format("Szevasz %s!", name);
	
	}

}
