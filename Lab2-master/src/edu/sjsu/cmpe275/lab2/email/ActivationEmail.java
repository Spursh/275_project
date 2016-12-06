package edu.sjsu.cmpe275.lab2.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivationEmail {

	 public static void emailRecommendTrigger(String name, String receiverMail, String tokenID){
	       final String username = "kalyani.kps54@gmail.com";
	      final String password = "1992polagani";
	     //   String aLink = "http://localhost:8080/275_lab2/UserController?action=activate&value="+tokenID;
	        String[] to = { receiverMail };
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
	         //session = Session.getInstance(props, null);

	        try {

	            Message message = new MimeMessage(session);
	             InternetAddress me = new InternetAddress("library.admin@sjsu.edu");
	                try {
	                    me.setPersonal("SJSU Library");
	                } catch (UnsupportedEncodingException e) {
	                    e.printStackTrace();
	                }
	                message.setFrom(me);
	            for (int i = 0; i < to.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
	            }
	            message.setSubject("Activation Email");
	            message.setText("Dear "+ name  + ",\n" 
	                    + "\nYour Token Id \n "+tokenID+
	                                        "\n\nRegards,\n" + "SJSU Library");
System.out.println("message"+receiverMail);
	            Transport.send(message);


	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    
	    
	    
}
