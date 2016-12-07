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



/*
 * Search the Book details based on title
 */
@RequestMapping(value = "book/searchBook", method = RequestMethod.GET )
public ModelAndView searchBook(){
	ModelAndView model = new ModelAndView("searchBook");
	return model;
	}

@RequestMapping(value = "book/searchBook/", method = RequestMethod.POST )
public ModelAndView searchBooks(@RequestParam("title")String title)	
{		System.out.println("In cintroller " +title);
		Book newbook =new Book();
		newbook=b.getBookByTitle(title);
		
		System.out.println("In cintroller Nwbook " +newbook.getTitle());
		
		ModelAndView model = new ModelAndView("addBookToCart");
		
		model.addObject(newbook);
		System.out.println("In cintroller 22 Nwbook " +newbook.getPublisher());
		return model;
		
	
}
}

