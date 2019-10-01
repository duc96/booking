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
import com.google.gson.Gson;

import src.main.Lib.ServerResponse;
import src.main.Model.Response.ServiceTypeResponse;
import src.main.Service.ServiceTypeService;

@Controller
public class serviceTypeController {
	@Autowired
	ServiceTypeService serviceTypeService;
	
	/**
	 * Delete Service Type
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/service/type", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody String removeAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			serviceTypeService.removeService(Integer.parseInt((String)postBody.get("id")));
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Update Service Type
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/service/type", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody String saveAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			serviceTypeService.updateService(postBody);
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Create New Service Type
	 * @param postBody
	 * @return
	 */
	@RequestMapping(value = "/api/service/type", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createAction(@RequestBody HashMap<String, ?> postBody) {
		ServerResponse response = new ServerResponse();
		try {
			int result = serviceTypeService.createNewService(postBody);
			response.setStatus(result > 0?"Success":"Fail");
		}catch(NullPointerException e) {
			response.setStatus("Fail");
		}
		
		return response.encode();
	}
	
	/**
	 * Get Service Type
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/service/type", method = RequestMethod.GET)
	public @ResponseBody String userGetOneAction(@RequestParam Integer id) {
		ServerResponse response = new ServerResponse();
		ServiceTypeResponse serviceType = serviceTypeService.getService(id);
		if(serviceType == null) {
			response.setStatus("Fail");
		} else {
			List<ServiceTypeResponse> result = new ArrayList <ServiceTypeResponse>();
			result.add(serviceType);
			response.setRows(result);
		}
		
		return response.encode();
	}
	
	/**
	 * Get User List
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/service/types", method = RequestMethod.GET)
	public @ResponseBody String listAction(Model model, @RequestParam HashMap<String, ?> postBody) {
		Gson g = new Gson();
		System.out.print(postBody);
		List<ServiceTypeResponse> services = serviceTypeService.getList(postBody);
		ServerResponse response = new ServerResponse();
		response.setRows(services);
		
		return response.encode();
	}
	
}
