/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arusharamessur.librarysystem;

/**
 *
 * @author arush
 */
import javax.swing.*; //This provides GUI interface for the program.
import java.time.LocalDate; // provide functionality for working with dates.
import java.time.format.DateTimeFormatter; //help to convert YYYY-MM-DD to DD-MM-YYYY.
public class Book {    
    //attributes
    private int BookID;  
    private String BookName; 
    private String Author;
    private String PublicationDate;
    private int Qty;
    private int Section;
    
    public Book() { //default constructor
    
        BookID = 0;  
        BookName = null; 
        Author = null;
        PublicationDate = null;
        Qty = 0;
        Section = 0;

    } // end of default constructor

    public Book(int BookID, String BookName, String Author, String PublicationDate, int Qty, int Section) { //second constructor passing parameters
        // The following lines assign the values of the parameters to the corresponding instance variables of the Book object.
        this.BookID = BookID;  
        this.BookName = BookName; 
        this.Author = Author;
        this.PublicationDate = PublicationDate;
        this.Qty = Qty;
        this.Section = Section;

    } // end of second constructor
    
    // This method is used to retrieve the value of the BookID instance variable.
    public int getBookID(){ 
        return BookID;
    } // end getBookID
    
    // This method is used to retrieve the value of the BookName instance variable.
    public String getBookName(){
        return BookName;
    } // end getBookName
    
    // This method is used to retrieve the value of the Author instance variable.
    public String getAuthor(){
        return Author;
    } // end getAuthor
    
    // This method is used to retrieve the value of the PublicationDate instance variable.
    public String getPublicationDate(){
        return PublicationDate;
    } // end getPublicationDate 
    
    // This method is used to retrieve the value of the Quantity instance variable.
    public int getQty(){
        return Qty;
    } // end getQty
    
    // This method is used to retrieve the value of the Section instance variable.
    public int getSection(){
        return Section;
    } // end getSection
    
    public String PrintBookData(){
        return "Book ID: " + BookID + "\n" +
                "Book Name: " + BookName + "\n" +
                "Author: " + Author + "\n" +
                "Date of publication: "+ PublicationDate + "\n" +
                "Quantity: " + Qty + "\n" +
                "Book Section: "+ Section;
    } //end PrindBookData
    
    public void PrintBook(){
        
        // Display message with title and books details
        String book = "BookID is "+BookID 
                +"\nBook name is "+BookName 
                +"\nAuthor of the book is "+Author 
                +"\nPublication Date of the book is "+PublicationDate
                +"\nNumber of copy available "+Qty  
                +"\nThe "+BookName+" book is found in section "+Section;
        JOptionPane.showMessageDialog(null, book, "NEW BOOK SUCCESSFULLY ADDED TO THE SYSTEM!", JOptionPane.INFORMATION_MESSAGE);
        
        //Print record on concole
        System.out.println("\nNEW BOOK SUCCESSFULLY ADDED TO THE SYSTEM!");
        System.out.println("BookID is "+BookID);
        System.out.println("Book name is "+BookName);
        System.out.println("Author of the book is "+Author);
        System.out.println("Publication Date of the book is "+PublicationDate);
        System.out.println("Number of copy available "+Qty);
        System.out.println("The "+BookName+" book is found in section "+Section+" and on shelf \n\n");
    
    }  // end of PrintBook method  
    
    public void BorrowBook(){
        
        // ask librarian to enter book details and quantity available
        BookName = JOptionPane.showInputDialog("Enter book Title: ");
        String ID = JOptionPane.showInputDialog("Enter bookID: ");
        BookID = Integer.parseInt(ID); 
        String Q = JOptionPane.showInputDialog("Number of copy available ");
        Qty = Integer.parseInt(Q); 
        
        if (Qty > 0)
        {
            Qty--; // decrease number of copies available
        
            LocalDate DateOfBorrowing = LocalDate.now(); // declare date variable to obtain current date from the system clock in the time zone
            
            //Display message that book has been borrow on which date with title 
            String detail = BookName+" with BookID "+ BookID+ " has successfully been borrowed!";
            JOptionPane.showMessageDialog(null, detail, "LENDING BOOK", JOptionPane.PLAIN_MESSAGE);
            String date = JOptionPane.showInputDialog("Issue book on this date(DD-MM-YYYY): ");
            DateOfBorrowing = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            
            //Add 1 week to the current date
            LocalDate ReturnBook = DateOfBorrowing.plusWeeks(1);
            String DateToReturnBook = "The book must be returned on: "+ ReturnBook;
            JOptionPane.showMessageDialog(null, DateToReturnBook, "DATE TO RETURN BOOK!",JOptionPane.PLAIN_MESSAGE);
            
            // print data on console
            System.out.println(BookName+" with BookID "+ BookID+ " has successfully been borrowed!\n");
            System.out.println("Subscriber borrowed this " +BookName+" book on: " + DateOfBorrowing.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    + "\nand must return the book on :"+ ReturnBook.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        } 
        else
        {
            //Display error message if there are no books available 
            String error = "Sorry all copies of "+BookName+" are currently unvailable.";
            JOptionPane.showMessageDialog(null, error, "NO COPIES AVAILABLE", JOptionPane.ERROR_MESSAGE);
            
            // print data on console
            System.out.println("Sorry all copies of "+BookName+" are currently unvailable.\n\n");            
            
        }    // end if    
        
    } // end of BorrowBook method
    
    public void ReturnBook(){
        
        LocalDate DateOfReturn = LocalDate.now(); // declare date variable to obtain current date from the system clock in the time zone
        
        //Display message that book has been returned on which date with title 
        BookName = JOptionPane.showInputDialog("Enter book Title: ");
        String ID = JOptionPane.showInputDialog("Enter bookID: ");
        BookID = Integer.parseInt(ID); 
        String Q = JOptionPane.showInputDialog("Number of copy available ");
        Qty = Integer.parseInt(Q);
        String date = JOptionPane.showInputDialog("Returned book on this date(DD-MM-YYYY): ");
        DateOfReturn = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        Qty++;  // increase number of copies available
         
        String detail = BookName+" with BookID "+ BookID+ " returned successfully!";
        JOptionPane.showMessageDialog(null, detail, "RETURNING BOOK",JOptionPane.PLAIN_MESSAGE);
        
        // print data on console
        System.out.println(BookName+" with BookID "+ BookID+ " returned successfully!\n");
        System.out.println("Subscriber returned the "+BookName+" book on:"+DateOfReturn.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"\n\n");
                
    } // end of ReturnBook    
} // end of Book

