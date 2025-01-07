/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystemmenu;

/**
 *
 * @author arush
 */
import javax.swing.*; //This provides GUI interface for the program.
public class Subscriber {
   
    //attributes
    int SubID;  
    String SubName;
    int ContactNumber;
    String EmailAddress;
    int BookBorrowed;
 
    public Subscriber(){   //default constructor
        
        SubID= 0;
        SubName = null;
        ContactNumber = 0;
        EmailAddress = null;
        
    } // end of default constructor
    
    public Subscriber(int Sid, String sn, int ph, String add){ //second constructor passing parameters
    
        SubID= Sid;
        SubName = sn;
        ContactNumber = ph;
        EmailAddress = add;
        
    }// end of second constructor
    
    
    public void PrintSubscriber(){
    
        // Display message with title and subscribers details
        String sub = "SubscriberID is "+SubID 
                + "\nSubscriber name is "+SubName 
                + "\nSubscriber phone number is: " +ContactNumber 
                + "\nSubscriber email address is: "+ EmailAddress
                + "\n\nSubscriber "+SubName+" with ID "
                +SubID+" has sucessfully been registered!";
        JOptionPane.showMessageDialog(null, sub, "NEW SUBCRIBERS DETAILS!", JOptionPane.INFORMATION_MESSAGE);
        
        //Print record on concole
        System.out.println("NEW SUBCRIBERS DETAILS!");
        System.out.println("\nSubscriberID is "+SubID);
        System.out.println("Subscriber name is "+SubName);
        System.out.println("Subscriber phone number is: " +ContactNumber);
        System.out.println("Subscriber email address is: "+ EmailAddress); 
        
        System.out.println("Subscriber "+SubName+" with ID "+SubID+" has sucessfully been registered!\n\n");
    
    } //end of PrintSubscriber method  
    
    public void BorrowBook(){
        
        // ask librarian to enter subscriber details 
        SubName = JOptionPane.showInputDialog("Enter subscriber name: ");
        String id = JOptionPane.showInputDialog("Enter subscriber ID: ");
        SubID  = Integer.parseInt(id);  
        BookBorrowed++; //increase the number of book borrowed
        
        String detail = SubName+" with ID "+SubID+ " is now borrowing a book!";
        JOptionPane.showMessageDialog(null, detail, "SUBSCRIBER BORROWING A BOOK", JOptionPane.PLAIN_MESSAGE);
        
        // print data on console
        System.out.println(SubName+" with ID "+SubID+ " is now borrowing a book!");
                   
    } // end of BorrowBook method
    
    public void ReturnBook(){
        
        //Display message that  subscriber has returned book 
        SubName = JOptionPane.showInputDialog("Enter subscriber name: ");
        String id = JOptionPane.showInputDialog("Enter subscriber ID: ");
        SubID  = Integer.parseInt(id);  
        BookBorrowed--;  //decrease the number of book borrowed
        
        String detail = SubName+" has return a book!";
        JOptionPane.showMessageDialog(null, detail, "SUBSCRIBER RETURNING A BOOK", JOptionPane.PLAIN_MESSAGE);
        
        // print data on console
        System.out.println("\n\n"+SubName+" has return a book!");
    
    } //end of ReturnBook method

} //end of Subscriber class
