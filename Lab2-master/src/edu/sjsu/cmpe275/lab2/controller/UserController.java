package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.email.ActivationEmail;
import edu.sjsu.cmpe275.lab2.email.TokenGenerator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.sjsu.cmpe275.lab2.model.User;
import edu.sjsu.cmpe275.lab2.email.TokenGenerator;

import static java.lang.String.format;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.ParseException;

@Controller
@SessionAttributes("user")
public class UserController {
	private static final long serialVersionUID = 1L;
	public User user = null;
	CreateUser cu = new CreateUser();
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "user", new User());
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,
		@RequestParam("password") String password) {

		User user= new User();
		
		user=cu.getObjectByEmail(email);
			if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
				return "/addBook";
			}
			else{
				return "User not registered";
				}
		
		//		user = new User();
//		ModelAndView modelAndView = new ModelAndView();
//		if(){
//			user.setEmail(email);
//			user.setPassword(password);
//			modelAndView.addObject("user", user);
//		}else{
//			modelAndView.addObject("user", null);
//		}
//			return modelAndView;
//	}
		
	}
	
	
	@RequestMapping(value = "/userSignup", method = RequestMethod.POST)
	public String signup() {
			return "/signup";

	}

	@RequestMapping(value = "/continue", method = RequestMethod.POST)
	public String signup(@RequestParam("action") String action,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("fName") String fName, @RequestParam("lName") String lName,@RequestParam("univid") String univid) {
		if (action != null && !action.equals("") && action.equals("Continue")) {
			String tokenID = TokenGenerator.randomToken();
			user = new User();
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setEmail(email);
			user.setPassword(password);
			user.setUnivid(univid);
			user.setUniquecode(tokenID.substring(0,6));
			System.out.println("tokenID"+tokenID);
			ActivationEmail.emailRecommendTrigger(fName + " " + lName, email, user.getUniquecode());
			return "/continue";
		}
		return null;
	}

	@RequestMapping(value = "/Welcome", method = RequestMethod.POST)
	public String continueMethod(@RequestParam("action") String action,
			                     @RequestParam("token") String token) {
		CreateUser cu = new CreateUser();
		if (action != null && !action.equals("") && action.equals("Submit")) {
         if(token != null && token.equals(user.getUniquecode())){ 
        	 cu.insert(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUnivid(),user.getUniquecode());
        	 ActivationEmail.emailRecommendTrigger(user.getFirstName() + " " + user.getLastName(), user.getEmail(), "You Have Succesfully Created an Account");
			return "/login";
         }else{
        	 System.out.println("Not a match");
         }
		}
		return null;
	}

}
