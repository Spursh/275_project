/*package edu.sjsu.cmpe275.lab2.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

import org.json.simple.*;

public class CreateUser {	
	
	 
	public void insert(String id, String firstname, String lastname, String title, String city, String state, String zip, String street) {
		// TODO Auto-generated method stub
		entitymanager instance associated with persistence context
		This method is called by User Controller for inserting User Details into Database
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  User user = new User();
		  user.setId(id);
	      user.setFirstname(firstname);
	      user.setLastname(lastname);
	      user.setTitle(title);
	      
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      user.setAddress(address);

	      entitymanager.persist( user );
	      entitymanager.getTransaction( ).commit( );
	      entitymanager.close( );
	      emfactory.close( );
	}

	public User getObjectById(String userid) {
		
		This method is called by User Controller for getting User Details from Database
	      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );


	     
		  User user = new User();

	   
		user = entitymanager.find(User.class, userid);	
		if(user==null)
	    	return null;
	    entitymanager.persist( user );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
	    return user;

	}

	public void update(String firstname, String lastname, String title, String city, String state, String zip,
			String street, String userId) {
		// TODO Auto-generated method stub
		
		This method is called by User Controller for Updating User Details into Database
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	     Address address = new Address( ); 
		 User user = new User();
		 user = entitymanager.find(User.class, userId);
		
		  user.setFirstname(firstname);
	      user.setLastname(lastname);
	      user.setTitle(title);
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      user.setAddress(address);
	      
	      entitymanager.getTransaction().commit();
	      entitymanager.close( );
	      emfactory.close( );	
	}

	public void deleteObjectById(String userId) {
		// TODO Auto-generated method stub
		This method is called by User Controller for Deleting User Details from Database
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
//	      Address address = new Address( ); 
//		  
	    User user = new User();
		  
		  user = entitymanager.find(User.class, userId);
		  
		  List<Phone> phone = user.getPhones();
		  for(Phone p : phone)
		  {
			  Phone pId = entitymanager.find(Phone.class, p.getId()); 
			  pId.getUser().remove(user);
		  }
		  
		  //address = entitymanager.find(Address.class);
		 
//		  entitymanager.getTransaction().begin();
		  entitymanager.remove(user);
		  //entitymanager.remove(address);
		  entitymanager.getTransaction().commit();
		  entitymanager.close();
		
	}

	public User getJsonById(String userid) {
		// TODO Auto-generated method stub
		System.out.println("i am in dao");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );

	    System.out.println("user id"+userid);
	    User user = entitymanager.find(User.class, userid);
		  System.out.println("user object"+ user);
		  	entitymanager.persist( user );
		     entitymanager.getTransaction( ).commit( );
		     entitymanager.close( );
		     emfactory.close( );
		  	return user;

	}
}

*/