package com.example.IEscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private MyService myService;

	@Autowired	
	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	@GetMapping("/hello")
	public String hello(){
	
		return myService.sayHello("");
	
	}

}
