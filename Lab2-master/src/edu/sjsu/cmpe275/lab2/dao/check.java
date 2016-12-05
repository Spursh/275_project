package edu.sjsu.cmpe275.lab2.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Book;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*EntityManagerFactory emfactory =  Persistence.createEntityManagerFactory( "275_lab2" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Book b = new Book();
		b.setAuthor("Spursh");
		b.setCallnum("asd");
		b.setKeywords("asd");
		b.setLocation("asdsad");
		b.setPublisher("rewewr");
		b.setStatus("available");
		b.setYear("23324");
		b.setCopies(1);
		b.setTitle("ghfghfhgf");
		entitymanager.persist( b );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );*/
		LocalDateTime timePoint = LocalDateTime.now();
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		System.out.println("theDate"+theDate);
		System.out.println("month"+month);
		System.out.println("day"+day);
		LocalDate dueDate = timePoint.toLocalDate().plusDays(30);
		System.out.println("dueDate"+dueDate);

	}

}
