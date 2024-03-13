Library Management System
Description:
This Java application is designed to manage a library system. It allows librarians to perform various tasks such as adding new books, updating book details, checking out books to users, and managing user accounts. The application utilizes file-based data persistence to store book and user information between application runs, implements error handling to manage invalid user inputs and edge cases, and incorporates validation checks to ensure accurate entry of book and user information.

Instructions for Setting Up and Running the Project Locally:
Clone the repository to your local machine.
Ensure you have Java installed on your system.
Open the project in your preferred Java IDE.
Compile and run the LibraryManagementSystem class.
Follow the menu-driven interface to perform various tasks such as adding books, adding users, displaying books, checking out books, returning books, and searching for books by title or author.
Prerequisites/Software Needed:
Java Development Kit (JDK)
Java IDE (such as IntelliJ IDEA, Eclipse, or NetBeans)
Key Features and Functionalities Implemented:
Book Class: Represents a book with attributes such as book ID, title, author, genre, and availability status.
User Class: Represents a user with attributes including user ID, name, contact information, and borrowed books.
Library Class: Manages the library system, containing methods for adding new books and users, checking out and returning books, and searching for books by title or author.
DataHandler Class: Handles file-based data persistence, allowing the application to save and load book and user information between runs.
Main Class (LibraryManagementSystem): Serves as the entry point for the program, providing a simple menu-driven interface for librarians to interact with the system.
