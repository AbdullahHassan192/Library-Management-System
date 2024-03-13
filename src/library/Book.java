package library;
import java.io.Serializable;

public class Book implements Serializable{
	
	private int bookid;
	private String title;
	private String author;
	private String genre;
	private boolean availability;

	
	Book(int id, String btitle, String bauthor, String bgenre){
		if (id > 0 && btitle != null && bauthor != null && bgenre != null) {
		bookid = id;
		title = btitle;
		author = bauthor;
		genre = bgenre;
		availability = true;
		
	} else {
		System.out.println("Invalid input! Please enter valid book details!");
	}
	}
	
	public int getbookid() {
		return bookid;
	}
	
	public String gettitle() {
		return title;
	}
	
	public String getauthor() {
		return author;
	}
	
	public String getgenre() {
		return genre;
	}
	
	public boolean getavailability() {
		return availability;
	}
	
	public void setavailability(boolean available) {
		availability = available;
	}
}
