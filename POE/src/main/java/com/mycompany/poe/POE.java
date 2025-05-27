/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poe;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
public class POE {

    public static void main(String[] args) {
        String name, pass, phone, first, last;

        //       Login user = new Login();
        Scanner scan = new Scanner(System.in);

//        System.out.println("Register:");
//
//        System.out.println("enter username");
//        name = scan.nextLine();
//        System.out.println("enter password");
//        pass = scan.nextLine();
//        System.out.println("enter telephone number");
//        phone = scan.nextLine();
//        System.out.println("enter first name");
//        first = scan.nextLine();
//        System.out.println("enter last name");
//        last = scan.nextLine();
//
//        Login user = new Login(name, pass, phone, first, last);
//
//        System.out.println(user.phoneMessaging());
//
//        System.out.println(user.registerUser());
//        System.out.println("Login:");
//
//        System.out.println("enter username");
//        name = scan.nextLine();
//        System.out.println("enter password");
//        pass = scan.nextLine();
//
//        System.out.println(user.returnLoginStatus(pass, name));
//        if (user.loginUser(pass, name)) {
            int option = 0;
            while (option != 3) {   //closes application when user chooses to "Quit"
                option = Integer.parseInt(JOptionPane.showInputDialog(null, "Option 1)Send messages\nOption 2)Show recent messages\nOption 3)Quit", "Welcome to QuickChat", JOptionPane.DEFAULT_OPTION));
                //retrieves input
                if (option == 2) //Displays output for "Show recent messages"             
                {
                    JOptionPane.showInternalMessageDialog(null, "Coming Soon.", "Show recent messages", JOptionPane.DEFAULT_OPTION);
                }

                if (option == 1) {  //"Displays output for "Send messages"
                    int totalMessages = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of message that you wish to enter:", "Send messages", JOptionPane.DEFAULT_OPTION));
                    //above retrieves input for the number of messages that the user shall be entering
                    int count = 0;
                    for (int i = 0; i < totalMessages; i++) {   //keeps creating message entries until the user has enterred all of the messages they declared they would previously                 
                        String recipient = JOptionPane.showInputDialog(null, "Enter Recipient Cell", "Send messages", JOptionPane.DEFAULT_OPTION);
                        String message = JOptionPane.showInputDialog(null, "Enter message", "Send messages", JOptionPane.DEFAULT_OPTION);

                        Message current = new Message(recipient, message, i); //message number increments as loop runs
                        current.setNumMessageSent(count); //for keeping track of the number of messages sent, when the object gets overwritten                    
                        current.sentMessage();   //provides menu for the user to select to send,store or discard the message
                        count = current.getNumMessageSent();
                    }
                    JOptionPane.showMessageDialog(null, count, "total number of messages", JOptionPane.DEFAULT_OPTION);//I'm under the impression that the total number of messages accumulated that was aluded to refers to the number of messages sent, as indicated by the test cases
                }
            }
        //}
        scan.close();
    }
}
