package library;
import java.util.ArrayList;

public class Library {

	private ArrayList<Book> books;
	private ArrayList<User> users;
	
	public Library() {
		books = new ArrayList<Book>();
		users = new ArrayList<User>();
	}
	
    public void initializeLibrary(ArrayList<User> loadedUsers, ArrayList<Book> loadedBooks) {
        this.users = loadedUsers;
        this.books = loadedBooks;
    }
	
	public void addbook(Book book) {
		try {
		if(book != null) {
		books.add(book);
	} else {
		System.out.println("Invalid input! Please enter valid book details");
	}
		}
		catch (Exception e) {
        System.out.println("An error occurred while adding the book");
    }
		}
	
	public void adduser(User user) {
		try {
			if(user != null) {
				users.add(user);
	} else {
		System.out.println("Invalid input! Please enter valid user details");
	}
		} catch (Exception e) {
			System.out.println("An error occured while adding the user");
		}
	}
	
	public void checkoutbook(User user, Book book) {
		try {
			if(book.getavailability()) {
			book.setavailability(false);
		user.borrowbook(book);
		System.out.println(book.gettitle() + " successfully checked out to " + user.getname());
		}
		else {
			System.out.println("Sorry! " + book.gettitle() + " is currently unavailable!");
		}
		} catch (Exception e) {
            System.out.println("An error occurred while checking out the book");
        }
	}
	
	
	public void returnbook(User user, Book book) {
		try {
		if(user.getborrowedbooks().contains(book)) {
			book.setavailability(true);
			user.returnbook(book);
			System.out.println(book.gettitle() + " successfully returned by " + user.getname());
		}
		else {
			System.out.println(user.getname() + " did not borrow " + book.gettitle());
		}
		} catch (Exception e) {
            System.out.println("An error occurred while returning the book");
        }
	}
	
	public void searchbytitle(String title) {
		try {
		System.out.println("Searching for books titled " + title);
		for(Book book: books) {
			if(book.gettitle().equalsIgnoreCase(title)) {
				System.out.println(book.gettitle() + " by " + book.getauthor());
			}
		}
		} catch (Exception e) {
            System.out.println("An error occurred while searching for books");
        }
	}

	public void searchbyauthor(String author) {
		try {
		System.out.println("Searching for books by " + author);
		for(Book book: books) {
			if(book.getauthor().equalsIgnoreCase(author)) {
				System.out.println(book.gettitle() + " by " + book.getauthor());
			}
		}
		} catch (Exception e) {
            System.out.println("An error occurred while searching for books");
        }
	}
	
	public void displaybooks() {
		try {
		System.out.println("All books in the library:");
		for(Book book: books) {
			System.out.println(book.gettitle());
		}
		} catch (Exception e) {
            System.out.println("An error occurred while displaying books.");
        }
	}
	
	public ArrayList<User> getusers(){
		return users;
	}	
	
	public ArrayList<Book> getbooks(){
		return books;
	}
	
}



