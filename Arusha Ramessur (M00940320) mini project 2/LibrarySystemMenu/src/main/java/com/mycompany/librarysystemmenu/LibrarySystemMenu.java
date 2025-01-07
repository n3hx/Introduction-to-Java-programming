
package com.mycompany.librarysystemmenu;

/**
 *
 * @author arush
 */
import javax.swing.*; //This provides GUI interface for the program.
public class LibrarySystemMenu {

    public static void main(String[] args) {
        
        while (true){ // while (true) means repeat the process until choice is equal to 5
            
            // displaying a welcome message and ask the librarian to enter his choice
            String menu = "WELCOME TO THE LIBRARY MANAGEMENT SYSTEM!"+
                    "\n Enter your choice: "+
                    "\n1. Add a book"+"\n2. Register a new subscriber"+
                    "\n3. Borrow book"+"\n4. Return book"+
                    "\n0. Exit\n";
             int option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (option){
                case 1:
                    AddBook();
                break;
                case 2:
                    SubRegistration();
                break;
                case 3:
                    BorrowBook();
                break;
                case 4:
                    ReturnBook();
                break;
                case 0:
                    System.out.println("Program terminated");
                    System.exit(0);
                default:
                    String invalid = "Please enter a value between 0-5";
                    JOptionPane.showMessageDialog(null, invalid, "INVALID CHOICE", JOptionPane.PLAIN_MESSAGE);                            
                
            } // end of switch statement
            
        } // end of while loop    
    
    } // end of Main method

    public static void AddBook(){
       // create book reference object 
       
        // display message and ask if librarian wants to add a book
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to add a new book?", "ADD NEW BOOK!", JOptionPane.YES_NO_OPTION);
        
        // loop until librarian chooses not to register a subscriber
        while (choice == JOptionPane.YES_OPTION) {
            String ID = JOptionPane.showInputDialog("Enter bookID: ");
            int id = Integer.parseInt(ID);
            String bn = JOptionPane.showInputDialog("Enter book Title: ");
            String au = JOptionPane.showInputDialog("Enter author of the book: ");
            String pd = JOptionPane.showInputDialog("Publication Date of the book is ");
            String Q = JOptionPane.showInputDialog("Number of copy available ");
            int qty = Integer.parseInt(Q);
            String S = JOptionPane.showInputDialog("Enter the section number where the book must go: "+
                    "\n1.Academic\n2.Kids\n3.Comedy\n4.Horror\n5.Suspense\n6.Mystery\n7.Ficion\n8.Romance\n9.Literatures\n10.Disney Comics");
            int sec = Integer.parseInt(S);
            String SH = JOptionPane.showInputDialog("Enter the shelf number where the book must be on: " );
            int sh = Integer.parseInt(SH);
                
            BookReference book = new BookReference(id, bn, au, pd, qty, sec, sh);
            book.PrintBook(); //instantiating the book object
            
            // ask if librarian wants to add another book
            choice = JOptionPane.showConfirmDialog(null, "Do you want to add another book?", "ADD NEW BOOK!", JOptionPane.YES_NO_OPTION);
        
        } // End while loop
    
    } //end of AddBook method
    
    public static void SubRegistration(){
       // create subcribers object  
       
       int count = 0; // initialise count to 0
       
       // display message and ask if librarian wants to register a subscriber
       int choice = JOptionPane.showConfirmDialog(null, "Do you want to register a subscriber?", "REGISTER NEW SUBSCRIBER!", JOptionPane.YES_NO_OPTION);
       
       // loop until librarian chooses not to register a subscriber
        while (choice == JOptionPane.YES_OPTION) {
            count++; // increment count

            String id = JOptionPane.showInputDialog("Enter subscriber ID: ");
            int Sid  = Integer.parseInt(id);
            String sn = JOptionPane.showInputDialog("Enter subscriber name: ");
            String P = JOptionPane.showInputDialog("Enter subscriber phone number: ");
            int ph = Integer.parseInt(P);        
            String add = JOptionPane.showInputDialog("Enter subscriber email address: ");
                
            Subscriber sub= new Subscriber(Sid, sn, ph, add);
            sub.PrintSubscriber(); //instantiating the subscribers object
        
             // ask if librarian wants to register another subscriber
            choice = JOptionPane.showConfirmDialog(null, "Do you want to register another subscriber?", "Subscriber Registration", JOptionPane.YES_NO_OPTION);
            
        } // End while loop
        
        // display the total number of subscribers registered
        JOptionPane.showMessageDialog(null, "Total subscribers registered: " + count);
        System.out.println("Total subscribers registered: " + count); // //Print record on concole

    
    } // end of SubRegistration method
    
    public static void BorrowBook(){
        //instantiating the borrow book objects
        Subscriber subscriber = new Subscriber(0, "", 0, "");
        BookReference book = new BookReference(0, "", "", "", 0, 0,0);
        
        subscriber.BorrowBook(); 
        book.BorrowBook(); 
    
    } // end of BorrowBook method
    
    public static void ReturnBook(){
        //instantiating the return book objects
        Subscriber subscriber = new Subscriber(0, "", 0, "");
        BookReference book = new BookReference(0, "", "", "", 0, 0,0);
        
        subscriber.ReturnBook(); 
        book.ReturnBook(); 
    
    } // end of ReturnBook method
    
} // end of LibrarySystemMenu class
