/*package edu.sjsu.cmpe275.lab2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

public class CreatePhone {
	public void insert(String id,String number, String description, String city, String state, String zip, String street) {
		entitymanager instance associated with persistence context
		This method is called by Phone Controller for inserting Phone Details into Database
		EntityManagerFactory emfactory =  Persistence.createEntityManagerFactory( "275_lab2" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Phone phn = new Phone();
		phn.setId(id);
		phn.setNumber(number);
		phn.setDescription(description);
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip);
		phn.setAddress(addr);
	    entitymanager.persist( phn );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
	}
	
	public Phone getObjectById(String phoneid) {
		
		This method is called by Phone Controller for getting Phone Details from Database
	      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	       
		  Phone phone = new Phone();
	   
	 phone = entitymanager.find(Phone.class, phoneid);
	 if(phone==null)
	    	return null;
	 System.out.println("users in phone"+phone.getUser().size());
	 System.out.println("i am there");
     entitymanager.persist( phone );
     entitymanager.getTransaction( ).commit( );
     entitymanager.close( );
     emfactory.close( );
	 return phone;
	}
	
	public void updatePhone(String number, String description, String title, String city, String state, String zip,
			String street, String userId, String removeUserId, String phoneId) {
		This method is called by Phone Controller for Updating Phone Details into Database
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      System.out.println("i am here");
	      Address address = new Address( ); 
		  Phone phone = new Phone();
		  phone = entitymanager.find(Phone.class, phoneId);
		  User user = entitymanager.find(User.class, userId);
		  phone.getUser().add(user);
		  User removeUser = entitymanager.find(User.class, removeUserId);
		  System.out.println("user to be removed");
		  phone.getUser().remove(removeUser);
		  phone.setNumber(number);
	      phone.setDescription(description);
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      phone.setAddress(address);
	      
	      entitymanager.getTransaction().commit();
	      entitymanager.close( );
	      emfactory.close( );	
	}
	
	
	
	
	public void updatePhoneNoRemove(String number, String description, String title, String city, String state, String zip,
			String street, String userId, String phoneId) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      Address address = new Address( ); 
		  Phone phone = new Phone();
		  

		  phone = entitymanager.find(Phone.class, phoneId);
		  User user = entitymanager.find(User.class, userId);
		  phone.getUser().add(user);
		  phone.setNumber(number);
	      phone.setDescription(description);
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      phone.setAddress(address);
	      
	      entitymanager.getTransaction().commit();
	      entitymanager.close( );
	      emfactory.close( );	
	}
	

	
	
	
	public void deleteObjectById(String phoneId) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      Phone phone = new Phone();
		  phone = entitymanager.find(Phone.class, phoneId);
		 if(phone.getUser().size()== 0){
		  entitymanager.remove(phone);
		  entitymanager.getTransaction().commit();
		  entitymanager.close();
		 }
	}
	
	
}
*/