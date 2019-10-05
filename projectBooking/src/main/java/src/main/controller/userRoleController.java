package src.main.controller;

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

import src.main.Lib.ServerResponse;
import src.main.Model.Response.UserRoleResponse;
import src.main.Service.UserRoleService;

@Controller
public class userRoleController {
	@Autowired
	UserRoleService userRoleService;
	
	/**
	 * Delete User Role
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/user/role", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody String removeAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			userRoleService.removeUserRole(Integer.parseInt((String)postBody.get("id")));
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Update User Role
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/user/role", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody String saveAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			userRoleService.updateUserRole(postBody);
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Create New User Role
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/user/role", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			int result = userRoleService.createNewUserRole(postBody);
			response.setStatus(result > 0?"Success":"Fail");
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Get User Role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/user/role", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody String userGetOneAction(@RequestParam Integer id) {
		ServerResponse response = new ServerResponse();
		UserRoleResponse userRole = userRoleService.getUserRole(id);
		if(userRole == null) {
			response.setStatus("Fail");
		} else {
			List<UserRoleResponse> result = new ArrayList <UserRoleResponse>();
			result.add(userRole);
			response.setRows(result);
		}
		
		return response.encode();
	}
	
	/**
	 * Get User List
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/user/roles", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody String listAction(Model model, @RequestParam HashMap<String, ?> postBody) {
		List<UserRoleResponse> userRoles = userRoleService.getList(postBody);
		ServerResponse response = new ServerResponse();
		response.setRows(userRoles);
		return response.encode();
	}
	
}
