package com.kaev.IEscheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class ErrorPageController implements ErrorController{

	private static final String ERR_PATH = "/error";
	
	//az ErrorController implemetálásakor elvárja, hogy felülírjuk a getErrorPath-t
	//felülírás csak annyi, hogy hiba esetén irányítsa az ERR_PATH-ra, ami az alábbiakban kerül kezelésre
	@Override
	public String getErrorPath() {
		return ERR_PATH;
	}
	
	private ErrorAttributes errorAttributes;
	
	@Autowired
	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}
	
	@RequestMapping(ERR_PATH)
	public String error(Model model, WebRequest request){
		
		@SuppressWarnings("deprecation")
		Map<String,Object> error = this.errorAttributes.getErrorAttributes(request, true);
		
		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", error.get("path"));
		model.addAttribute("status", error.get("status"));
		
		return "error/error";
	
		//TODO: innentől lehet még variálni, hogy ha a status pl.: 404, akkor ezt és ezt tegye, stb.
	}
	

}
