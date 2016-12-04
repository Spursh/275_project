/*package edu.sjsu.cmpe275.lab2.controller;


import java.io.IOException;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.model.User;

Contoller Class for User Creation handling GET, POST, DELETE

@Controller
public class UserController {

	Creates user with GET Call
	CreateUser cU = new CreateUser();
	@RequestMapping(value = "/user", method = RequestMethod.GET )
	public ModelAndView createUser(){
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST )
	Saves user Details into Database with POST Call
	public String createUserSuccess(@RequestParam("firstname") String firstname,
											@RequestParam("lastname") String lastname,
											@RequestParam("title") String title,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		String id = Long.toString(System.currentTimeMillis());
		
		cU.insert(id, firstname, lastname, title, city, state, zip, street);
		return "redirect:/user/" + id;
	}
	
	@RequestMapping(value = "user/{userid}", method = RequestMethod.GET )
	public ModelAndView updateDeleteUser(@PathVariable("userid")String userid,HttpServletResponse httpRes){
		
		Get the User Details from Database With GET Call
		
		ModelAndView model = null;
		User userDetails = cU.getObjectById(userid);
		if(userDetails==null){
			httpRes.setStatus( HttpServletResponse.SC_NOT_FOUND);
			 model = new ModelAndView("errorPage");
			 model.addObject("givenid", userid);
		}else{
			 model = new ModelAndView("userUpdateDelete");
			model.addObject(userDetails);
			
		}
		return model;
	}
	@RequestMapping(value = "userJSON/{userid}", method = RequestMethod.GET )
	public ModelAndView jsonUser(@PathVariable("userid")String userid){
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("user id "+userid);
		User user = cU.getJsonById(userid);
		
		User user = cU.getObjectById(userid);
		
		
		System.out.println("in controller user object"+ user);
		
		String jsonString = null;
		
		try {
		jsonString = mapper.writeValueAsString(user);
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

	
	
	
	
	
	
	
	
	
	
	   @RequestMapping(value = "/user/{userid}",params={"json"}, method=RequestMethod.GET, produces="application/json")
	    @ResponseBody
	    public String getPhoneJson(
	      HttpServletRequest request,
	      HttpServletResponse response,
	    @PathVariable("userid") String userid,
	    @RequestParam(value = "json") String value){
	    String s = "JSON fdsfdsfdsf";
	    
	    CreateUser cU = new CreateUser();
	  
	    
	    User user =   cU.getJsonById(userid);
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonInString = "";
	        if(user==null){
	        response.setStatus(404);
	        return " sorry  "+userid+" does not exist";
	        }
	        try {
	            jsonInString = mapper.writeValueAsString(user);
	            } catch (JsonProcessingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	            return jsonInString;
	     }



	//@RequestMapping(value = "/updateUser", method = RequestMethod.POST )
	@RequestMapping(value="/user/{userid}" ,method = RequestMethod.POST)
	public String updateUser(@PathVariable("userid") String userId,@RequestParam Map<String, String> req){
		
		Takes the User Details  and Update user table in Database with Post Call
		
		System.out.println("Results are Shown here ----------->"+ req.get("firstname") );
		cU.update(req.get("firstname"), req.get("lastname"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), userId);
		return "redirect:/user/" + userId;
		}
	
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE )
	public String deleteUser(@PathVariable("userId")  String userId){
		Deletes the User according to userID in function with Delete Call
		cU.deleteObjectById(userId);
		return "user";
	}
}

*/