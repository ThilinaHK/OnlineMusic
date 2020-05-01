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
	
	@GetMapping(value = "/landingpage")
	public String landingpage() {
		return "/landingpage";

	}

}
