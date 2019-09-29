package src.main.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import src.main.Lib.ServerResponse;
import src.main.Model.Response.UserResponse;
import src.main.Service.UserService;
import src.main.java.booking.AdminUsers;
import src.main.java.booking.Khachhang;

@Controller
public class userController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/api/user/remove", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String removeAction(@RequestBody Integer id) {
		ServerResponse response = new ServerResponse();
		try {
			userService.removeUser(id);
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	@RequestMapping(value = "/api/user/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String saveAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			userService.updateUser(postBody);
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	@RequestMapping(value = "/api/user/create", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			int result = userService.createNewUser(postBody);
			response.setStatus(result > 0?"Success":"Fail");
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Get User List
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/user/getone", method = RequestMethod.GET)
	public @ResponseBody String userGetOneAction(@RequestParam Integer id) {
		ServerResponse response = new ServerResponse();
		UserResponse user = userService.getUser(id);
		if(user == null) {
			response.setStatus("Fail");
		} else {
			List<UserResponse> result = new ArrayList <UserResponse>();
			result.add(user);
			response.setRows(result);
		}
		
		return response.encode();
	}
	
	/**
	 * Get User List
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
	public @ResponseBody String userListAction(Model model, @RequestParam HashMap<String, ?> postBody) {
		Gson g = new Gson();
		System.out.print(postBody);
		List<UserResponse> users = userService.getList(postBody);
		ServerResponse response = new ServerResponse();
		response.setRows(users);
		
		return response.encode();
	}

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
