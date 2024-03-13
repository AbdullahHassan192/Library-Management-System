package library;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class LibraryManagementSystem {
	
	
	private static Library library;
	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
        ArrayList<User> users = DataHandler.loadUsers();
        ArrayList<Book> books = DataHandler.loadBooks();
        library = new Library();
        library.initializeLibrary(users, books);
		displaymenu();
		
        DataHandler.saveData(library.getusers(), library.getbooks());

	}
	
	public static void displaymenu() {
		int choice;
		do {
			try {
			System.out.println("\t\tWelcome to Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Books by Title");
            System.out.println("7. Search Books by Author");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            
            switch(choice) {
            case 1:
                addbook();
                break;
            case 2:
                adduser();
                break;
            case 3:
                library.displaybooks();
                break;
            case 4:
                checkoutbook();
                break;
            case 5:
                returnbook();
                break;
            case 6:
                searchbytitle();
                break;
            case 7:
                searchbyauthor();
                break;
            case 8:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
			} catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                input.nextLine();
                choice = 0;
            }
            
		} while(choice != 8);
	}
	
	public static void addbook() {
		try {
		System.out.println("Enter book ID: ");
		int bookID = input.nextInt();
		input.nextLine();
		System.out.print("Enter book title: ");
        String title = input.nextLine();
        System.out.print("Enter book author: ");
        String author = input.nextLine();
        System.out.print("Enter book genre: ");
        String genre = input.nextLine();
        Book book = new Book(bookID, title, author, genre);
        library.addbook(book);
        System.out.println("Book added successfully!");
		} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for the book");
            input.nextLine();
        }
	}
	
    public static void adduser() {
    	try {
        System.out.print("Enter user ID: ");
        int userID = input.nextInt();
        input.nextLine();
        System.out.print("Enter user name: ");
        String name = input.nextLine();
        System.out.print("Enter user's contact information: ");
        String contactInfo = input.nextLine();
        User user = new User(userID, name, contactInfo);
        library.adduser(user);
        System.out.println("User added successfully.");
    	} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for the user");
            input.nextLine();
        }
    }
    
    public static User getuserbyID(int userID) {
        for (User user : library.getusers()) {
            if (user.getuserid() == userID) {
                return user;
            }
        }
        return null;
    }

    public static Book getBookByID(int bookID) {
        for (Book book : library.getbooks()) {
            if (book.getbookid() == bookID) {
                return book;
            }
        }
        return null;
    }
	
    public static void checkoutbook() {
    	try {
        System.out.print("Enter user ID: ");
        int userID = input.nextInt();
        System.out.print("Enter book ID: ");
        int bookID = input.nextInt();
        User user = getuserbyID(userID);
        if (user != null) {
            Book book = getBookByID(bookID);
            if (book != null) {
                library.checkoutbook(user, book);
            } else {
                System.out.println("Book with ID " + bookID + " was not found.");
            }
        } else {
            System.out.println("User with ID " + userID + " was not found.");
        }
    	} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid user and Book ID's");
            input.nextLine();
        }
    }
    
    public static void returnbook() {
    	try {
        System.out.print("Enter user ID: ");
        int userID = input.nextInt();
        System.out.print("Enter book ID: ");
        int bookID = input.nextInt();
        User user = getuserbyID(userID);
        if (user != null) {
            Book book = getBookByID(bookID);
            if (book != null) {
                library.returnbook(user, book);
            } else {
                System.out.println("Book with ID " + bookID + " was not found.");
            }
        } else {
            System.out.println("User with ID " + userID + " was not found.");
        }
    	} catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid user and Book ID's");
            input.nextLine();
        }
    }
    
    public static void searchbytitle() {
    	try {
        System.out.print("Enter title to search: ");
        String title = input.nextLine();
        library.searchbytitle(title);
    	} catch (InputMismatchException e) {
            System.out.println("An error occurred! Please try again");
            input.nextLine(); 
        }
    }
	
    public static void searchbyauthor() {
    	try {
        System.out.print("Enter author to search: ");
        String author = input.nextLine();
        library.searchbyauthor(author);
    	}catch (InputMismatchException e) {
            System.out.println("An error occurred! Please try again");
            input.nextLine();
        }
    }
	
}
