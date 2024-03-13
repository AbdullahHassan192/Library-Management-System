package library;
import java.io.*;
import java.util.ArrayList;

public class DataHandler {
	 private static final String USER_DATA_FILE = "users.dat";
	    private static final String BOOK_DATA_FILE = "books.dat";
	    
	    public static void saveData(ArrayList<User> users, ArrayList<Book> books) {
	        try (ObjectOutputStream userOut = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE));
	             ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream(BOOK_DATA_FILE))) {
	            userOut.writeObject(users);
	            bookOut.writeObject(books);
	            System.out.println("Data saved successfully.");
	        } catch (IOException e) {
	            System.err.println("Error saving data: " + e.getMessage());
	        }
	    }
	    
	    public static ArrayList<User> loadUsers() {
	        ArrayList<User> users = new ArrayList<>();
	        try (ObjectInputStream userIn = new ObjectInputStream(new FileInputStream(USER_DATA_FILE))) {
	            users = (ArrayList<User>) userIn.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error loading user data: " + e.getMessage());
	        }
	        return users;
	    }
	    
	    public static ArrayList<Book> loadBooks() {
	        ArrayList<Book> books = new ArrayList<>();
	        try (ObjectInputStream bookIn = new ObjectInputStream(new FileInputStream(BOOK_DATA_FILE))) {
	            books = (ArrayList<Book>) bookIn.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Error loading book data: " + e.getMessage());
	        }
	        return books;
	    }
}
