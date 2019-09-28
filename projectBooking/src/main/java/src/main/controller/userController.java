package src.main.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import src.main.Lib.ServerResponse;
import src.main.Service.UserService;
import src.main.java.booking.Khachhang;

@Controller
public class userController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/user/signup", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String Action(@RequestBody String staff) {
		Gson g = new Gson();
		String ajaxResponse = "";
		return ajaxResponse;
	}

	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	public @ResponseBody String signinAction(@RequestBody HashMap<String, ?> postBody) {
		
		String token = userService.auth((String)postBody.get("loginname"), (String)postBody.get("password"));
		ServerResponse response = new ServerResponse();
		
		if(token.isEmpty()) {
			response.setStatus("Fail");
		}
		response.setContent(token);
		
		return response.encode();
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupFormAction(Model model) {
		return "users/RegisterPage";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Model model) {
		return "users/login";
	}
	
}
