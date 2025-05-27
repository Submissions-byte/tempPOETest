/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lab_services_student
 */
public class Message {

    private int numMessageSent;
    private int msgNumber;
    private String ID, recipient, hash, message;
    private StringBuffer sent = new StringBuffer();
    private StringBuffer store = new StringBuffer();

    public Message(String recipient, String message, int msgNumber) {
        this.msgNumber = msgNumber;
        genID();                    //generates message ID
        this.recipient = recipient;
        this.message = message;
        this.hash = createMesssageHash();
    }

    public String getMessage() {
        return message;
    }

    public String getHash() {
        return hash;
    }

    public String getID() {
        return ID;
    }

    public int getNumMessageSent() {
        return numMessageSent;
    }

    public void setNumMessageSent(int numMessageSent) {
        this.numMessageSent = numMessageSent;
    }

    //helper methods above for accessing attributes/properties of the object/class
    public String checkMessageLength() {
        if (this.message.length() > 250) {
            return "Please enter a message of less than 250 characters.";
        }
        return "Message sent";
    }

    public void genID() {
        ID = "";
        for (int i = 0; i < 10; i++) {
            ID += (int) Math.floor(Math.random() * 10); //adds one random digit at a time to form the ID
        }
    }

    public boolean checkMessageID() {//does as instructed, does not confirm format of ID
        return ID.length() <= 10;
    }

    public int checkRecipientCell() {
        if (recipient.length() <= 12 && recipient.startsWith("+27", 0) && recipient.substring(3).matches("\\d+")) {
            return 0;       //returns 0 if the cell number is valid and 1 if not
        }
        return 1;
    }

    public String createMesssageHash() {
        String[] output = message.split(" ");
        return (ID.substring(0, 2) + ':' + msgNumber + ':' + output[0].toUpperCase() + output[output.length - 1].toUpperCase());
    }   //creates a message hash

    public String sentMessage() {
        String[] options = {"Send Message", "Discard Message", "Store Message to send later"};
        //this is so that options can be selcted when testing
        int option = JOptionPane.showInternalOptionDialog(null, "Choose one of the following options", "Choose one of the following options", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (option == 0) {//carries out procedures for 'Send Message'

            sent.append(this.message + "\n");
            String[] lines = {this.ID, this.hash, this.recipient, this.message};
            if (checkRecipientCell() == 0 && this.message.length() <= 250) {
                JOptionPane.showMessageDialog(null, lines, "Message information", JOptionPane.INFORMATION_MESSAGE);
                numMessageSent++;
            }
            if (checkRecipientCell() != 0) {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again", "Send Messages", JOptionPane.DEFAULT_OPTION);
                if (!checkMessageLength().contains("sent"))//for logical reasons, if the cell numbber is incorrectly formatted the message cannot be sent,as such implementing the messaging differently would be misleading
                {
                    JOptionPane.showMessageDialog(null, checkMessageLength(), "Send Messages", JOptionPane.DEFAULT_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cellphone number successfully captured.", "Send Messages", JOptionPane.DEFAULT_OPTION);
                JOptionPane.showMessageDialog(null, checkMessageLength(), "Send Messages", JOptionPane.DEFAULT_OPTION);
            }

            //the above is due to a lack of an appropriate place to place the error messaging for the message and recipient cell, as the non error message "Message sent"
            return "Message successfully sent.";    //unclear as to what string should be returned and as such the strings indicated by the test cases shall be used
        }

        if (option == 1) {//carries out procedures for 'Discard Message'
            return "Press 0 to delete message.";
        }
        if (option == 2) {
            ////carries out procedures for 'Store Message''
            store.append(this.message);
            return "Message successfully stored.";
        }
        return "Closed";//incase the user simply closes the JOptionPane
    }

    public String testableSentMessage(int option) { //this method exists as a way of bypassing joption panes, for both output and input when testing/for testing as, per the instructions: the sentMesage method should be the thing allowing the user to make their selection hence would require a JOptionPane or scanner
        //as such it replicates the logic
        if (option == 0) {//carries out procedures for 'Send Message'
            if (checkRecipientCell() == 0 && this.message.length() <= 250) {
                return "Message successfully sent.";    //unclear as to what string should be returned and as such the strings indicated by the test cases shall be used
            }
        }
        if (option == 1) {//carries out procedures for 'Discard Message'
            return "Press 0 to delete message.";
        }
        ////carries out procedures for 'Store Message''
            store.append(this.message);
        return "Message successfully stored.";
    }

    public String printMessages() {
        return sent.toString();         //returns a list of all the messages sent
    }

    public int returnTotalMessagess() {
        return numMessageSent;          //returns the total number of messages sent
    }

    //code attribution
    //ChatGPT. (2024). ChatGPT (Dec 11
    //version) [Large language
    //model]. https://chatgpt.com/share/6804bfef-0a94-8005-b060-aba98aeaa2e7
    public static void storeMessage(String filePath, String message, String sender) {
        // Create a JSON object for the message
        JSONObject messageObject = new JSONObject();
        messageObject.put("sender", sender);
        messageObject.put("message", message);
        messageObject.put("timestamp", "2025-05-26T12:00:00");  // Replace with actual timestamp if needed

        // Check if the file exists
        File file = new File(filePath);
        JSONArray messagesArray = new JSONArray();

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                // Read the existing messages from the JSON file
                int data = reader.read();
                StringBuilder jsonString = new StringBuilder();
                while (data != -1) {
                    jsonString.append((char) data);
                    data = reader.read();
                }
                // Parse the existing JSON content into an array
                messagesArray = new JSONArray(jsonString.toString());
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }

        // Append the new message to the JSON array
        messagesArray.put(messageObject);

        // Write the updated messages back to the file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(messagesArray.toString(4));  // Pretty print with indentation of 4 spaces
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

}
