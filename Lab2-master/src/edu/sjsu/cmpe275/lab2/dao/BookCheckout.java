package edu.sjsu.cmpe275.lab2.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Book;
import edu.sjsu.cmpe275.lab2.model.User;

public class BookCheckout {
	
	LocalDateTime timePoint = LocalDateTime.now();
	LocalDate theDate = timePoint.toLocalDate();

	public Book getbDetails(String bookid) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
		Book book = new Book();  
	    book = entitymanager.find(Book.class, bookid);	
	    if(book==null)
	    	return null;
	    entitymanager.persist( book );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
	    return book;

	}

	public void checkoutBook(String bookid) {
		// TODO Auto-generated method stub
		User user = new User(); //replace with session
		int tolalNumberOfBooksUserHave = user.getBooks().size();
		//int numberOfBooksUserCheckedoutInADay =  
		
	}

}
