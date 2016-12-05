package edu.sjsu.cmpe275.lab2.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "UNIVID")
	private String univid;
	@Column(name = "UNIQUECODE")
	private String uniquecode;
	@Column(name = "Checkout_Date")
	private LocalDate checkoutDate;
	@Column(name = "Due_Date")
	private LocalDate dueDate;
	
	 public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@ManyToMany(mappedBy="user", fetch=FetchType.LAZY)
	    @JsonBackReference
	   private List<Book> books;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnivid() {
		return univid;
	}

	public void setUnivid(String univid) {
		this.univid = univid;
	}

	public String getUniquecode() {
		return uniquecode;
	}

	public void setUniquecode(String uniquecode) {
		this.uniquecode = uniquecode;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	public User(String email, String firstName, String lastName, String password, String univid, String uniquecode,
			LocalDate checkoutDate, LocalDate dueDate, List<Book> books) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.univid = univid;
		this.uniquecode = uniquecode;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.books = books;
	}

	public User() {
		super();
	}
	
}
