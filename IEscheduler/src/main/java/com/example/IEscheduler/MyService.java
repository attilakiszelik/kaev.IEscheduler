package com.example.IEscheduler;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MyService {

	public String sayHello(@RequestParam(value = "name", defaultValue = "Jóskám") String name) {
		
		//return String.format("Szevasz %s!" + name);
		
		return "Szevasz Jóskám!";
		
	}
	
	
}
