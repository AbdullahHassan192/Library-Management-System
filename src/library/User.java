package library;
import java.util.ArrayList;
import java.io.Serializable;


public class User implements Serializable {

	private int userid;
	private String name;
	private String contactinfo;
	private ArrayList<Book> borrowedbooks;
	
	User(int id, String uname, String ucontact){
		try {
		userid = id;
		name = uname;
		contactinfo = ucontact;
		borrowedbooks = new ArrayList<Book>();
	} catch (Exception e) {
        System.out.println("An error occurred while creating the user.");
    }
}
	
	public int getuserid() {
		return userid;
	}
	
	public String getname() {
		return name;
	}
	
	public String getcontactinfo() {
		return contactinfo;
	}
	
	public ArrayList<Book> getborrowedbooks(){
		return borrowedbooks;
	}
	
	public void borrowbook(Book book) {
		borrowedbooks.add(book);
	}
	
	public void returnbook(Book book) {
		borrowedbooks.remove(book);
	}
}
