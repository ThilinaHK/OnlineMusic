package com.project.onlinemusic.Controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
//@RequestMapping("online/v1/api/login")
public class LoginController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger("LoginController");
	
//	@RequestMapping(value = "/",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	@PostMapping(value="/login_access")
	public String authentication(@RequestParam("username") String username,
			@RequestParam("password") String password,HttpSession session,ModelMap modelMap) {
		ResponseEntity<?> respone =null;
		RouteController route=new RouteController();
		String path="";
		try {
			LOGGER.info("online/api/login/"+username+":"+password+" method=[POST]");
			if(username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
				session.setAttribute("username", username);
				path=route.Dashboard();
				return path;
			} else {
				modelMap.put("error", "Invalid access...");
				path=route.login();
				return path;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respone.getBody().toString();
	}
	


	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../account";
	}
	
}
