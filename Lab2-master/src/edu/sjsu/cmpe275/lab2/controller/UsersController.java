package edu.sjsu.cmpe275.lab2.controller;

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

import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.email.ActivationEmail;
import edu.sjsu.cmpe275.lab2.email.TokenGenerator;
import edu.sjsu.cmpe275.lab2.model.User;

@Controller
public class UsersController {

	public User user = null;
	CreateUser cu = new CreateUser();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView user() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {

		User user = new User();
		user = cu.getObjectByEmail(email);
		if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
			ModelAndView model = new ModelAndView("searchBook");// go to search
																// page
			model.addObject(user);
			return model;
		} else {
			// return "User not registered";
			//return null;
			ModelAndView model = new ModelAndView("error1"); //no result exception
			return model;
		}
		
	}

	@RequestMapping(value = "/userSignup", method = RequestMethod.POST)
	public String signup() {
		return "/signup";

	}

	@RequestMapping(value = "/continue", method = RequestMethod.POST)
	public String signup(@RequestParam("action") String action, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("fName") String fName,
			@RequestParam("lName") String lName, @RequestParam("univid") String univid) {
		
		if (action != null && !action.equals("") && action.equals("Continue")) {
			//&& !user.getEmail().equals(email) 
			String tokenID = TokenGenerator.randomToken();
			String type = null;
			if (email.contains("@sjsu.edu")) {
				type = "librarian";
			} else {
				type = "patron";
			}
			String univ = null;
			if(univid.length()==6){
				univ=univid;
			}
			else{
				return "/error1"; //validate univid
			}
			
			user = new User();
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setEmail(email);
			user.setPassword(password);
			user.setUnivid(univ);
			user.setUniquecode(tokenID.substring(0, 6));
			user.setUsertype(type);
			System.out.println("tokenID" + tokenID);
			ActivationEmail.emailRecommendTrigger(fName + " " + lName, email, user.getUniquecode());
			return "/continue";
		}
		else{
			return "/error1";
		}
		
	}

	@RequestMapping(value = "/Welcome", method = RequestMethod.POST)
	public String continueMethod(@RequestParam("action") String action, @RequestParam("token") String token) {
		CreateUser cu = new CreateUser();
		if (action != null && !action.equals("") && action.equals("Submit")) {
			if (token != null && token.equals(user.getUniquecode())) {
				cu.insert(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
						user.getUnivid(), user.getUniquecode(), user.getUsertype());
				ActivationEmail.emailRecommendTrigger(user.getFirstName() + " " + user.getLastName(), user.getEmail(),
						"You Have Succesfully Created an Account");
				return "/login";
			} else {
				System.out.println("Not a match");
			}
		}
		return null;
	}

}
