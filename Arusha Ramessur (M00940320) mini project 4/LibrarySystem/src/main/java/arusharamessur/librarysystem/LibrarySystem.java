/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package arusharamessur.librarysystem;

/**
 * The private and static modifiers indicate that these variables are specific
 * to the class and can be accessed throughout the program.
 * final means that the variable's value cannot be changed once assigned
 * @author arush
 */ 

import javax.swing.*; //This provides GUI interface for the program.
import java.io.*; // provide functionality for working with files
import java.util.*; // provide functionalities such as ArrayList, Vector and Scanner
public class LibrarySystem extends JFrame{
    private static final ArrayList<Book> books = new ArrayList<>(); // create arraylist to store objects of Book class
    private static final Vector<Subscriber> subscribers = new Vector<>(); // create vector to store objects of Subscriber class

    public static void main(String[] args) {
        LibrarySystem DisplayMenu = new LibrarySystem();
        DisplayMenu.setVisible(true); //set visible is an inbuild function of the JFrame which makes the JFrame visible when true
        
    } // end of Main method

    private static void AddBook() {
        try { 
            String BookID = JOptionPane.showInputDialog("Enter Book ID:");
            String BookName = JOptionPane.showInputDialog("Enter Book Name:");
            String Author = JOptionPane.showInputDialog("Enter Author Name:");
            String PublicationDate = JOptionPane.showInputDialog("Publication Date of the book is ");
            String Qty = JOptionPane.showInputDialog("Number of copy available ");
            String Section = JOptionPane.showInputDialog("""
                                                     Enter the section number where the book must go: 
                                                     1.Academic
                                                     2.Kids
                                                     3.Comedy
                                                     4.Horror
                                                     5.Suspense
                                                     6.Mystery
                                                     7.Fiction
                                                     8.Romance
                                                     9.Literatures
                                                     10.Disney Comics""");

            Book book = new Book(Integer.parseInt(BookID), BookName, Author, PublicationDate, Integer.parseInt(Qty), Integer.parseInt(Section));
            books.add(book); // Add the new book to the ArrayList

            // Display success message
            JOptionPane.showMessageDialog(null, "Book added successfully!");
            } catch (NumberFormatException e) {
            // Handle the exception when parsing integers
            JOptionPane.showMessageDialog(null, "Invalid input for Book ID or Quantity. Please enter valid integers.");
            } catch (Exception e1) {
            // Handle any other exceptions that may occur
            JOptionPane.showMessageDialog(null, "An error occurred while adding the book. Please try again.");
        } // end catch
    } // end AddBook method

    private static void AddSubscriber() {
        try {
            String subscriberID = JOptionPane.showInputDialog("Enter Subscriber ID:");
            String name = JOptionPane.showInputDialog("Enter Name:");
            String surname = JOptionPane.showInputDialog("Enter Surname:");
            String contactNumber = JOptionPane.showInputDialog("Enter Contact Number:");

            Subscriber subscriber = new Subscriber(Integer.parseInt(subscriberID), name, surname, Integer.parseInt(contactNumber));
            subscribers.add(subscriber);

            // Display success message
            JOptionPane.showMessageDialog(null, "Subscriber added successfully!");
            } catch (NumberFormatException e) {
            // Handle the exception when parsing integers
            JOptionPane.showMessageDialog(null, "Invalid input for Subscriber ID or Contact Number. Please enter valid integers.");
            } catch (Exception e) {
            // Handle any other exceptions that may occur
            JOptionPane.showMessageDialog(null, "An error occurred while adding the subscriber. Please try again.");
        } // end catch
    } // end AddSubscribers
    
    public static void BorrowBook(){
        //instantiating the borrow book objects
        Subscriber subscriber = new Subscriber(0, "",  "", 0);
        Book book = new Book(0, "", "", "", 0, 0);
        
        subscriber.BorrowBook(); 
        book.BorrowBook(); 
    
    } // end of BorrowBook method
    
    public static void ReturnBook(){
        //instantiating the return book objects
        Subscriber subscriber = new Subscriber(0, "",  "", 0);
        Book book = new Book(0, "", "", "", 0, 0);
        
        subscriber.ReturnBook(); 
        book.ReturnBook(); 
    
    } // end of ReturnBook method

    private static void SearchBooks() {
        String searchBook = JOptionPane.showInputDialog("Enter book name to search:");
        ArrayList<Book> searchResults = new ArrayList<>();

        for (Book book : books) { // (int i = 0; i < books.size(); i++) Book book = books.get(i); thus we bypass this 2 lines
            if (book.getBookName().equalsIgnoreCase(searchBook)) {
                searchResults.add(book);
            } // end if
        } // end for loop

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books found.");
        } else {
            StringBuilder sb = new StringBuilder(); //StringBuilder is a class in Java that provides a convenient way to manipulate strings.
            for (Book book : searchResults) {
                sb.append(book.PrintBookData()).append("\n");
            } // end for loop
            JOptionPane.showMessageDialog(null, sb.toString());
        } //end if 
    }// end SearchBooks method
    
    private static void SearchAuthor() {
        String searchBook = JOptionPane.showInputDialog("Enter author of the book to search:");
        ArrayList<Book> searchResults = new ArrayList<>();

        for (Book book : books) { // (int i = 0; i < books.size(); i++) Book book = books.get(i); thus we bypass this 2 lines
            if (book.getAuthor().equalsIgnoreCase(searchBook)) {
                searchResults.add(book);
            } // end if 
        } // end for

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books found.");
        } else {
            StringBuilder sb = new StringBuilder(); //StringBuilder is a class in Java that provides a convenient way to manipulate strings.
            for (Book book : searchResults) {
                sb.append(book.PrintBookData()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } // end if 
    } // end SeachAuthor method

    private static void SearchSubscribers() {
        String searchQuery = JOptionPane.showInputDialog("Enter subscriber surname to search:");
        Vector<Subscriber> searchResults = new Vector<>();

        for (Subscriber subscriber : subscribers) { // (int i = 0; i < subscribers.size(); i++) Subscriber subscriber = subscibers.get(i); thus we bypass this 2 lines
            if (subscriber.getSurname().equalsIgnoreCase(searchQuery)) {
                searchResults.add(subscriber);
            } // end if 
        } // end for

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No subscribers found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Subscriber subscriber : searchResults) {
                sb.append(subscriber.PrintSubData()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } // end if 
    } // end SearchSubscribers method

    private static void SortBooks() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < books.size() - 1; i++) { 
                if (books.get(i).getBookID() > books.get(i + 1).getBookID()) {
                    Book temp = books.get(i);
                    books.set(i, books.get(i + 1));
                    books.set(i + 1, temp);
                    swapped = true;
                } // end if 
            } // end for
        } while (swapped);

        JOptionPane.showMessageDialog(null, "Books sorted by ID.");
        StringBuilder sortedBooks = new StringBuilder("Sorted Books:\n");
        for (Book book : books) {
            sortedBooks.append(book.PrintBookData()).append("\n\n");
        } // end for 
        JOptionPane.showMessageDialog(null, sortedBooks.toString());
    } // end SortBooks method

    private static void SortSubscribersID() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < subscribers.size() - 1; i++) {
                if (subscribers.get(i).getSubID() > subscribers.get(i + 1).getSubID()) {
                    Subscriber temp = subscribers.get(i);
                    subscribers.set(i, subscribers.get(i + 1));
                    subscribers.set(i + 1, temp);
                    swapped = true;
                } // end if 
            } // end for 
        } while (swapped);

        JOptionPane.showMessageDialog(null, "Subscribers sorted by ID.");
        StringBuilder sortedSubscribers = new StringBuilder("Sorted Subscribers:\n");
        for (Subscriber subscriber : subscribers) {
            sortedSubscribers.append(subscriber.PrintSubData()).append("\n\n");
        } // end for 
        JOptionPane.showMessageDialog(null, sortedSubscribers.toString());
    } // end SortSubscribers method
    
   private static void SortSubscribersName() {
       boolean swapped;
       do {
            swapped = false;
            for (int i = 0; i < subscribers.size() - 1; i++) {
                if (subscribers.get(i).getName().compareToIgnoreCase(subscribers.get(i + 1).getName()) > 0) {
                    Subscriber temp = subscribers.get(i);
                    subscribers.set(i, subscribers.get(i + 1));
                    subscribers.set(i + 1, temp);
                    swapped = true;
                } // end if 
            } // end for 
        } while (swapped);

        JOptionPane.showMessageDialog(null, "Subscribers sorted alphabetically.");
        StringBuilder sortedSubscribers = new StringBuilder("Sorted Subscribers:\n");
        for (Subscriber subscriber : subscribers) {
            sortedSubscribers.append(subscriber.PrintSubData()).append("\n\n");
        } // end for 
        JOptionPane.showMessageDialog(null, sortedSubscribers.toString());
    } // end SortSubscibersName method

    private static void SaveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("books.txt", true))) {
            for (Book book : books) {
                writer.println("Book ID is: " + book.getBookID() + "\n" +
                        "Book Name: " + book.getBookName() + "\n" +
                        "Author: " + book.getAuthor() + "\n" +
                        "Date of publication: " + book.getPublicationDate()+ "\n" +
                        "Copy available: " + book.getQty() + "\n" +
                        "Book found in section number: " + book.getSection()+ "\n\n");
            } // end for loop
            JOptionPane.showMessageDialog(null, "Books appended to the file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving books.");
        } // end catch
    } // end SaveBookToFile method

    private static void SaveSubscribersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("subscribers.txt", true))) {
            for (Subscriber subscriber : subscribers) {
                writer.println("Subscriber ID is: "+ subscriber.getSubID() + "\n" +
                        "First Name: " + subscriber.getName() + "\n" +
                        "Last Name: " + subscriber.getSurname() + "\n" +
                        "Contact Details: " + subscriber.getContactNumber()+ "\n\n");
            } // end for loop
            JOptionPane.showMessageDialog(null, "Subscribers appended to the file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving subscribers.");
        } // end catch
    } // end SaveSubscribersToFile method

    private static void DisplayBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            StringBuilder bookDetails = new StringBuilder("Books:\n");
            String line;
            while ((line = reader.readLine()) != null) {
                bookDetails.append(line).append("\n");
            } // end while loop
            JOptionPane.showMessageDialog(null, bookDetails.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading books file.");
        } // end catch 
    } // end DisplayBooksFromFile method

    private static void DisplaySubscribersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("subscribers.txt"))) {
            StringBuilder subscriberDetails = new StringBuilder("Subscribers:\n");
            String line;
            while ((line = reader.readLine()) != null) {
                subscriberDetails.append(line).append("\n");
            }
            JOptionPane.showMessageDialog(null, subscriberDetails.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading subscribers file.");
        }
    }

    //attributes of LibrarySystem (assign each button to its name)
    private final JButton addBookButton; // Button for adding a book
    private final JButton addSubscriberButton; // Button for adding a subscriber
    private final JButton searchBookButton; // Button for searching a book by name
    private final JButton searchAuthorButton; // Button for searching a book by author
    private final JButton searchSubscriberButton; // Button for searching subscribers
    private final JButton borrowBookButton; // Button for borrowing a book
    private final JButton returnBookButton; // Button for returning a book
    private final JButton sortBooksButton; // Button for sorting books
    private final JButton sortSubscribersButton; // Button for sorting subscribers by IDs
    private final JButton sortSubscribersByNameButton; // Button for sorting subscribers by name in alphabetical order
    private final JButton openBookFileButton; // Button for opening book file
    private final JButton openSubscriberFileButton; // Button for opening subscriber file
    private final JButton saveRecordsButton; // Button for saving records
    private final JButton exitButton; // Button for exiting the program

    public LibrarySystem() { //constuctor of LibrarySystem class
        setTitle("Library System Menu"); //This will be displayed at the top of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the program will exit and terminate when the JFrame window is closed
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addBookButton = createButton("Add Book"); // Create "Add Book" button
        addSubscriberButton = createButton("Add Subscriber"); // Create "Add Subscriber" button
        searchBookButton = createButton("Search Book name"); // Create "Search Book name" button
        searchAuthorButton = createButton("Search book by author"); // Create "Search book by author" button
        searchSubscriberButton = createButton("Search Subscribers"); // Create "Search Subscribers" button
        borrowBookButton = createButton("Borrow book"); // Create "Borrow book" button
        returnBookButton = createButton("Return book"); // Create "Return book" button
        sortBooksButton = createButton("Sort Books"); // Create "Sort Books" button
        sortSubscribersButton = createButton("Sort Subscribers IDs"); // Create "Sort Subscribers IDs" button
        sortSubscribersByNameButton = createButton("Sort Subscribers in alphabetical order"); // Create "Sort Subscribers by Name in alphabetical order" button
        openBookFileButton = createButton("Open Book File"); // Create "Open Book File" button
        openSubscriberFileButton = createButton("Open Subscriber file"); // Create "Open Subscriber file" button
        saveRecordsButton = createButton("Save records"); // Create "Save records" button
        exitButton = createButton("Exit"); // Create "Exit" button

        // add buttons on the jframe menu
        add(Box.createVerticalStrut(10)); //adds vertical spacing between buttons
        add(addBookButton); 
        add(Box.createVerticalStrut(10));
        add(addSubscriberButton);
        add(Box.createVerticalStrut(10));
        add(searchBookButton);
        add(Box.createVerticalStrut(10));
        add(searchAuthorButton);
        add(Box.createVerticalStrut(10));
        add(searchSubscriberButton);
        add(Box.createVerticalStrut(10));
        add(borrowBookButton);
        add(Box.createVerticalStrut(10));
        add(returnBookButton);
        add(Box.createVerticalStrut(10));
        add(sortBooksButton);
        add(Box.createVerticalStrut(10));
        add(sortSubscribersButton);
        add(Box.createVerticalStrut(10));
        add(sortSubscribersByNameButton);
        add(Box.createVerticalStrut(10));
        add(openBookFileButton);
        add(Box.createVerticalStrut(10));
        add(openSubscriberFileButton);
        add(Box.createVerticalStrut(10));
        add(saveRecordsButton);
        add(Box.createVerticalStrut(10));
        add(exitButton);
        add(Box.createVerticalStrut(10)); 

        setSize(300, 550); // Set size of JFrame
        setLocationRelativeTo(null);
        setVisible(true);
    } // end constructor of LibrarySystem

    private JButton createButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setAlignmentX(CENTER_ALIGNMENT);
        // When the button is clicked, this ActionListener calls the HandleButtonClick method, passing the buttonText as an argument.
        button.addActionListener(e -> HandleButtonClick(buttonText)); 
        return button;
    } // end createButton method

    //The HandleButtonClick method receives the buttonText argument and uses it within a switch statement to determine which button was clicked.
    private void HandleButtonClick(String buttonText) {
        switch (buttonText) {
            case "Add Book":
                AddBook(); // Call method for adding a book
                break;
            case "Add Subscriber":
                AddSubscriber(); // Call method for adding a subscriber
                break;
            case "Search Book name":
                SearchBooks(); // Call method for searching a book by name
                break;
            case "Search Subscribers":
                SearchSubscribers(); // Call method for searching subscribers
                break;
            case "Borrow book":
                BorrowBook(); // Call method for borrowing a book
                break;
            case "Return book":
                ReturnBook(); // Call method for returning a book
                break;
            case "Sort Books":
                SortBooks(); // Call method for sorting books
                break;
            case "Sort Subscribers IDs":
                SortSubscribersID(); // Call method for sorting subscribers by IDs
                break;
            case "Open Book File":
                DisplayBooksFromFile(); // Call method for opening book file
                break;
            case "Open Subscriber file":
                DisplaySubscribersFromFile(); // Call method for opening subscriber file
                break;
            case "Save records":
                SaveBooksToFile(); // Call method for saving records - Books
                SaveSubscribersToFile(); // Call method for saving records - Subscribers
                break;
            case "Search book by author":
                SearchAuthor(); // Call method for searching a book by author
                break;
            case "Sort Subscribers in alphabetical order":
                SortSubscribersName(); // Call method for sorting subscribers by name in alphabetical order
                break;
            case "Exit":
                System.exit(0); // Exit the program
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                break;
        } // end switch case statement
        
    } //end HandleButtonClick method    
    
} // end LibrarySystem Class
