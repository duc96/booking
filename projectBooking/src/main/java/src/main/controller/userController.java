package src.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
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
	public @ResponseBody String signinAction(@RequestBody String staffInfo) {
		System.out.print(staffInfo);
		Gson gson = new Gson();
		Khachhang staff = gson.fromJson(staffInfo, Khachhang.class);
		String token = userService.auth(new Khachhang());
//		ServerResponse response = new ServerResponse();
//		if (token.isEmpty()) {
//			response.setStatus("Fail");
//		}
//		response.setContent(token);
//		return gson.toJson(response);
		
		return "";
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
