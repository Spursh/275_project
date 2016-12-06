package edu.sjsu.cmpe275.lab2.dao;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Book;
import edu.sjsu.cmpe275.lab2.model.User;

public class BookDetails {
		
	
		//Insert Book Data
		public void createBook(String bookid, String author, String title, String callnum, String publisher, String year, String location, int copies, String status, String keywords) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	    Book book =new Book();
	    book.setBookid(bookid);
	    book.setAuthor(author);
	    book.setTitle(title);
	    book.setCallnum(callnum);
	    book.setPublisher(publisher);
	    book.setYear(year);
	    book.setLocation(location);
	    book.setCopies(copies);
	    book.setStatus(status);
	    book.setKeywords(keywords);
	    
	    System.out.println("Current Book :"+book.getBookid());
  
	    entitymanager.persist( book );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
		}
		
		//Update Book Data
		public void updateBook(String bookId, String author, String title, String callnum, String publisher, String year, String location, int copies, String status, String keywords) {
			
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    
	    Book book =new Book();
	    book = entitymanager.find(Book.class, bookId);
	    
	    book.setAuthor(author);
	    book.setTitle(title);
	    book.setCallnum(callnum);
	    book.setPublisher(publisher);
	    book.setYear(year);
	    book.setLocation(location);
	    book.setCopies(copies);
	    book.setStatus(status);
	    book.setKeywords(keywords);
	    
	    System.out.println("Current updated Book :"+book.getBookid());
 
	    entitymanager.getTransaction().commit();
	    entitymanager.close( );
	    emfactory.close( );	
		}
		
		//Search Book 
		public Book getBookById(String bookid) {
			
			//	This method is called by User Controller for getting User Details from Database
			      
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
		
		//Delete Book
		public void deleteObjectById(String bookid) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
			EntityManager entitymanager = emfactory.createEntityManager( );
			entitymanager.getTransaction( ).begin( );

			Book book = new Book();
			 
			book = entitymanager.find(Book.class, bookid);
			entitymanager.getTransaction().begin();
			entitymanager.remove(book);
			System.out.println("Current deleted Book :"+book.getBookid());  
			entitymanager.getTransaction().commit();
			entitymanager.close();
			
		}
}

