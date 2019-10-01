package src.main.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import src.main.Lib.ServerResponse;
import src.main.Service.UserService;

@Controller
public class adminController {
	@Autowired
	private UserService userService;
	
	
//	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
//	public String AdminUser(Model model) {
//		model.addAttribute("currentpage", 1);
//		return "admin/app";
//	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String Admin(@RequestParam(required = false) String page, Model model) {
		String currentPage = "";
		if(page != null) {
			currentPage = pageMapping(page);
		}
		model.addAttribute("currentPage", currentPage);
		return "admin/app";
	}
	
	/**
	 * Get Page 
	 * @param page
	 * @return
	 */
	private String pageMapping(String page)
	{
		String _page = "";
		if(page.equals("users")) {
			_page = "/WEB-INF/pages/admin/users/index.jsp";
		}
		if(page.equals("service_type")) {
			_page = "/WEB-INF/pages/admin/services/service_type.jsp";
		}
		return _page;
	}
	
}
