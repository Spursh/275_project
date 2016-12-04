package edu.sjsu.cmpe275.lab2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

@Entity
public class Book {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOKID")
	private String bookid;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CALLNUM")
	private String callnum;
	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "YEAR")
	private String year;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "COPIES")
	private String copies;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "KEYWORDS")
	private String keywords;
	
	@ManyToMany(cascade =CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(
        name="Book_User",
        joinColumns=@JoinColumn(name="BOOK_ID", referencedColumnName="BOOKID"),
        inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="EMAIL"))
    private List<User> user;

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Book(String bookid, String author, String title, String callnum, String publisher, String year,
			String location, String copies, String status, String keywords, List<User> user) {
		super();
		this.bookid = bookid;
		this.author = author;
		this.title = title;
		this.callnum = callnum;
		this.publisher = publisher;
		this.year = year;
		this.location = location;
		this.copies = copies;
		this.status = status;
		this.keywords = keywords;
		this.user = user;
	}

	public Book() {
		super();
	}
}