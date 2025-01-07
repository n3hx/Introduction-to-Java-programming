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
public class Subscriber {   
    //attributes
    private int SubID;  
    private String Name;
    private String Surname;
    private int ContactNumber;
 
    public Subscriber(){   //default constructor
        
        SubID= 0;
        Name = null;
        Surname = null;
        ContactNumber = 0;
        
    } // end of default constructor
    
    public Subscriber(int SubID, String Name, String Surname, int ContactNumber ){ //second constructor passing parameters
    
        this.SubID= SubID;
        this.Name = Name;
        this.Surname = Surname;
        this.ContactNumber = ContactNumber;
        
    }// end of second constructor
    
    // This method is used to retrieve the value of the SubID instance variable.
    public int getSubID(){
        return SubID;
    } // end SubID
    
    // This method is used to retrieve the value of the Name instance variable.
    public String getName(){
        return Name;
    } // end getName
    
    // This method is used to retrieve the value of the Surname instance variable.
    public String getSurname(){
        return Surname;
    } // end getSurname
    
    // This method is used to retrieve the value of the Contact instance variable.
    public int getContactNumber(){
        return ContactNumber;
    } // end getContactNumber
    
    public String PrintSubData(){
        return "Subscriber ID: " + SubID + "\n" +
                "Name: " + Name + "\n" +
                "Surname: " + Surname + "\n" +
                "Contact Details: " + ContactNumber;
    } // end PrintSubData
    
    public void PrintSubscriber(){
    
        // Display message with title and subscribers details
        String sub = "SubscriberID is "+SubID 
                + "\nSubscriber name is "+Name +" "+Surname
                + "\nSubscriber phone number is: " +ContactNumber 
                + "\n\nSubscriber "+Name +" "+Surname+" with ID "
                +SubID+" has sucessfully been registered!";
        JOptionPane.showMessageDialog(null, sub, "NEW SUBCRIBERS DETAILS!", JOptionPane.INFORMATION_MESSAGE);
        
        //Print record on concole
        System.out.println("NEW SUBCRIBERS DETAILS!");
        System.out.println("\nSubscriberID is "+SubID);
        System.out.println("Subscriber name is "+Name +" "+Surname);
        System.out.println("Subscriber phone number is: " +ContactNumber);
        
        System.out.println("Subscriber "+Name +" "+Surname+" with ID "+SubID+" has sucessfully been registered!\n\n");
    
    } //end of PrintSubscriber method  
    
    public void BorrowBook(){
        
        // ask librarian to enter subscriber details 
        Name = JOptionPane.showInputDialog("Enter subscriber name: "+Name);
        String id = JOptionPane.showInputDialog("Enter subscriber ID: ");
        SubID  = Integer.parseInt(id);  
        
        String detail = Name +" with ID "+SubID+ " is now borrowing a book!";
        JOptionPane.showMessageDialog(null, detail, "SUBSCRIBER BORROWING A BOOK", JOptionPane.PLAIN_MESSAGE);
        
        // print data on console
        System.out.println(Name +" "+Surname+" with ID "+SubID+ " is now borrowing a book!");
                   
    } // end of BorrowBook method
    
    public void ReturnBook(){
        
        //Display message that  subscriber has returned book 
        Name = JOptionPane.showInputDialog("Enter subscriber name: "+Name);
        String id = JOptionPane.showInputDialog("Enter subscriber ID: ");
        SubID  = Integer.parseInt(id);  
        
        String detail = Name +" has return a book!";
        JOptionPane.showMessageDialog(null, detail, "SUBSCRIBER RETURNING A BOOK", JOptionPane.PLAIN_MESSAGE);
        
        // print data on console
        System.out.println("\n\n"+Name +" has return a book!");
    
    } //end of ReturnBook method
    
}
