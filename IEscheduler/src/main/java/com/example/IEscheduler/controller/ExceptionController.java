package com.example.IEscheduler.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public String exception(Exception ex, Model model) {
		
		model.addAttribute("exception", ex);
		
		//TODO ezt a htmlt el kell készíteni
		return "exception";
		
	}
	
	
}
