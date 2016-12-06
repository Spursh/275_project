package edu.sjsu.cmpe275.lab2.controller;


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

import edu.sjsu.cmpe275.lab2.dao.BookCheckout;
import edu.sjsu.cmpe275.lab2.dao.BookDetails;
import edu.sjsu.cmpe275.lab2.model.Book;
//import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.model.User;


@Controller
public class BookCrudController {

/*
 * Create book
 */

@RequestMapping(value = "book/createBook", method = RequestMethod.GET )
public ModelAndView createUser(){
	ModelAndView model = new ModelAndView("addBook");
	return model;
}

BookDetails b = new BookDetails();
@RequestMapping(value = "book/createBook", method = RequestMethod.POST )
public String addBookDetails(@RequestParam("bookid")String bookid,
		@RequestParam("author")String author,
		@RequestParam("title") String title,
		@RequestParam("callnum") String callnum,
		@RequestParam("publisher") String publisher,
		@RequestParam("year") String year,
		@RequestParam("location") String location,
		@RequestParam("copies") int copies,
		@RequestParam("status") String status,
		@RequestParam("keywords") String keywords)
	{
		//String id = Long.toString(System.currentTimeMillis());
		b.createBook(bookid, author, title, callnum, publisher, year, location, copies,status, keywords);
			//return "success";
			return "redirect:/book/" + bookid;
	}	

/*
 * //Get the User Details from Database
 */
@RequestMapping(value = "book/{bookid}", method = RequestMethod.GET )
public ModelAndView updateBook(@PathVariable("bookid")String bookid,HttpServletResponse httpRes){	
		
		ModelAndView model = new ModelAndView("getBookDetailsAndUpdate");
		Book newbook= b.getBookById(bookid);
		
		if(newbook==null){
			httpRes.setStatus( HttpServletResponse.SC_NOT_FOUND);
			model = new ModelAndView("errorPage");
			model.addObject("givenid", bookid);
		}
		else{	
			model = new ModelAndView("getBookDetailsAndUpdate");
			model.addObject("newbook", newbook);
			System.out.println("Obj: "+newbook.getBookid());
		}
		return model;
	}

/*
 * Update the Book details
 */
BookDetails updatebook = new BookDetails();
@RequestMapping(value = "book/{bookid}", method = RequestMethod.POST )
public String updateBookDetails(@RequestParam("bookid")String bookid,
		@RequestParam("author")String author,
		@RequestParam("title") String title,
		@RequestParam("callnum") String callnum,
		@RequestParam("publisher") String publisher,
		@RequestParam("year") String year,
		@RequestParam("location") String location,
		@RequestParam("copies") int copies,
		@RequestParam("status") String status,
		@RequestParam("keywords") String keywords)
	{
		//String id = Long.toString(System.currentTimeMillis());
		updatebook.updateBook(bookid, author, title, callnum, publisher, year, location, copies,status, keywords);
			//return "success";
			return "redirect:/book/" + bookid;
	}	

/*
 * Delete the Book details
 */
@RequestMapping(value = "book/{bookid}", method = RequestMethod.DELETE )
public String deleteBook(@PathVariable("bookid")  String bookid){
	b.deleteObjectById(bookid);
	return "success";
}








	/*Creates user with GET Call
	
	
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
*/}
