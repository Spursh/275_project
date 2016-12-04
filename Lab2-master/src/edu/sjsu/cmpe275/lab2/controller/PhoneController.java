/*package edu.sjsu.cmpe275.lab2.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sjsu.cmpe275.lab2.dao.CreatePhone;
import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;


@Controller
public class PhoneController {
	
	Contoller Class for User Creation handling GET, POST, DELETE
	CreatePhone pU = new CreatePhone();
	@RequestMapping(value = "/phone", method = RequestMethod.GET )
	public ModelAndView createPhone(){
		ModelAndView model = new ModelAndView("phone");
		return model;
	}
	@RequestMapping(value = "phoneJSON/{phoneid}", method = RequestMethod.GET )
	public ModelAndView jsonUser(@PathVariable("phoneid")String phoneid){
		
		ObjectMapper mapper = new ObjectMapper();
		Phone phone = pU.getObjectById(phoneid);
		
		
		System.out.println("in controller user object"+ phone);
		
		String jsonString = null;
		
		try {
		jsonString = mapper.writeValueAsString(phone);
		System.out.println(jsonString);
		}
		 catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("json string"+jsonString);
		
		ModelAndView model = new ModelAndView("jsonUserDetails");
		model.addObject("userdetails", jsonString);
		return model;
	}

	
	@RequestMapping(value = "/phone", method = RequestMethod.POST )
	public String createPhoneSuccess(@RequestParam("phoneNumber") String phoneNumber,
											
											@RequestParam("description") String description,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		Saves Phone Details into Database with POST Call taking all the parameters from this function
		String id = Long.toString(System.currentTimeMillis());
		pU.insert(id,phoneNumber, description, city, state, zip, street);
		return "redirect:/phone/" + id;
	}
	
	
	
	@RequestMapping(value = "phone/{phoneid}", method = RequestMethod.GET )
	public ModelAndView updateDeletePhone(@PathVariable("phoneid")String phoneid, HttpServletResponse httpRes){
		Get the Phone Details from Database With GET Call
		ModelAndView model = null;
		Phone phoneDetails = pU.getObjectById(phoneid);
		if(phoneDetails==null){
			httpRes.setStatus( HttpServletResponse.SC_NOT_FOUND);
			 model = new ModelAndView("phoneErrorPage");
			 model.addObject("givenid", phoneid);
		}else{
			 model = new ModelAndView("phoneUpdateDelete");
			 model.addObject(phoneDetails);
			
		}
		return model;
	}
	
	@RequestMapping(value="/phone/{phoneid}" ,method = RequestMethod.POST)
	public ModelAndView updatePhone(@PathVariable("phoneid") String phoneId,@RequestParam Map<String, String> req){
		Takes the Phone Details  and Update user table in Database with Post Call
		String selectedUser=  req.get("phoneUserElement");
		if(selectedUser == null)
		{
			pU.updatePhoneNoRemove(req.get("phoneNumber"), req.get("description"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), req.get("userId"), phoneId);
		}
		else
		{
			pU.updatePhone(req.get("phoneNumber"), req.get("description"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), req.get("userId"), req.get("phoneUserElement"), phoneId);
		}
		ModelAndView model = new ModelAndView("successfulUserUpdate");
		return model;
	}
	
	@RequestMapping(value = "/phone/{phoneId}", method = RequestMethod.DELETE )
	public ModelAndView deleteUser(@PathVariable  String phoneId){
		Deletes the Phone according to phoneId in function with Delete Call
		pU.deleteObjectById(phoneId);
		ModelAndView model = new ModelAndView("successfulDeletion");
		return model;
	}
	
}
*/