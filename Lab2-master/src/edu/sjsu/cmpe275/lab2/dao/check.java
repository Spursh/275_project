package edu.sjsu.cmpe275.lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Book;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory =  Persistence.createEntityManagerFactory( "275_lab2" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Book b = new Book();
		b.setAuthor("Spursh");
		entitymanager.persist( b );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );

	}

}
