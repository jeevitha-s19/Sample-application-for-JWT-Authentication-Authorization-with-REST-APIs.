package com.javasample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
	 
@Table(name = "bookstorage")
	public class Books  
	{  
	@Id  
	@Column  
	private int bookid;  
	@Column  
	private String bookname;  
	@Column  
	private String author;  
	@Column  
	private int price;  
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


public boolean IsPriceValid() {
    if(this.price <0)
        return false;
    if(this.price >30000.00)
        return false;
    else
        return true;
}
 
public boolean IsBookNameValid() {
    if (bookname == null || bookname.isEmpty()) {
        return false;
    }
    else
        return true;    
}
 
public boolean Isauthorvalid() {
    if (author == null || author.isEmpty()) {
        return false;
    }
    else
        return true;    
}
 
	}
