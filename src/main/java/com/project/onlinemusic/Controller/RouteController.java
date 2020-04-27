package com.project.onlinemusic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

	
	@GetMapping(value = {"/login","/"})
	public String login() throws Exception{
		return "login";
	
	}
	
	@GetMapping(value ="/Dashboard")
	public String Dashboard() {
		return "dashboard";

	}
//	
//	@GetMapping(value ="/daily_report")
//	public String daily_report() {
//		return "/daily_report";
//
//	}
//	 
//	
//	@GetMapping(value ="/personregister")
//	public String test() {
//		return "/personregister";
//
//	}
//	
//	@GetMapping(value="/test")
//	public String test_page() {
//		return "/test";
//	}
//	
//	@GetMapping(value = "/Home")
//	public String home_page() {
//		return "/Home";
//	}
//	
//	@GetMapping(value = "/Vehicle")
//	public String vehicle_page() {
//		return "/Vehicle";
//	}
//	
//	@GetMapping(value = "/markvehicle")
//	public String mark_vehicle() {
//		return "/markvehicle";
//	}
//	
//	@GetMapping(value = "/reports")
//	public String reports() {
//		return "/reports";
//	}
//	
//	@GetMapping(value = "/customer_visit_report")
//	public String cusomer_visit_report() {
//		return "/cusomer_visit_report";
//	}
//	
}
