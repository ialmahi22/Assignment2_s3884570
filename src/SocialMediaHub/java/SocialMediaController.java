package SocialMediaHub.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import SocialMediaHub.java.*;
import SocialMediaHub.java.SocialMediaPosts.SocialMediaPostsHandler;
//SocialMediaPostsHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



interface socialMediaController {

    
    static void updateUserName(String user, String newUsername) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	
    	try {
    		FileWriter fileWrite = new FileWriter(newFile, true);
    		BufferedWriter bufWrite = new BufferedWriter(fileWrite);
    		PrintWriter printWrite = new PrintWriter(bufWrite);      		       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		while(scan.hasNext())
    		{
    			userName = scan.next();
    			userFirstName = scan.next();
    			userLastName = scan.next();
    			userPassword = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(newUsername + "," + userFirstName + "," + userLastName + "," + userPassword + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "\n");				
    				}
    		 }    			
    		scan.close();
    		printWrite.flush();
    		printWrite.close();
    		currentFile.delete();
    		newFile.renameTo(currentFile);
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in updating the username");
    	}
    }

    static void updateFirstName(String user, String newFirstName) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	
    	try {
    		FileWriter fileWrite = new FileWriter(newFile, true);
    		BufferedWriter bufWrite = new BufferedWriter(fileWrite);
    		PrintWriter printWrite = new PrintWriter(bufWrite);      		       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		while(scan.hasNext())
    		{
    			userName = scan.next();
    			userFirstName = scan.next();
    			userLastName = scan.next();
    			userPassword = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + newFirstName + "," + userLastName + "," + userPassword + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "\n");				
    				}
    		 }    			
    		scan.close();
    		printWrite.flush();
    		printWrite.close();
    		currentFile.delete();
    		newFile.renameTo(currentFile);
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in updating the First Name");
    	}
    }

    static void updateLastName(String user, String newLastName) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	
    	try {
    		FileWriter fileWrite = new FileWriter(newFile, true);
    		BufferedWriter bufWrite = new BufferedWriter(fileWrite);
    		PrintWriter printWrite = new PrintWriter(bufWrite);      		       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		while(scan.hasNext())
    		{
    			userName = scan.next();
    			userFirstName = scan.next();
    			userLastName = scan.next();
    			userPassword = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + userFirstName + "," + newLastName + "," + userPassword + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "\n");				
    				}
    		 }    			
    		scan.close();
    		printWrite.flush();
    		printWrite.close();
    		currentFile.delete();
    		newFile.renameTo(currentFile);
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in updating the First Name");
    	}
    }  
    
    static void updatePassword(String user, String newpassword) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	
    	try {
    		FileWriter fileWrite = new FileWriter(newFile, true);
    		BufferedWriter bufWrite = new BufferedWriter(fileWrite);
    		PrintWriter printWrite = new PrintWriter(bufWrite);      		       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		while(scan.hasNext())
    		{
    			userName = scan.next();
    			userFirstName = scan.next();
    			userLastName = scan.next();
    			userPassword = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + newpassword + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= "") {
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "\n");				
    				}
    		 }    			
    		scan.close();
    		printWrite.flush();
    		printWrite.close();
    		currentFile.delete();
    		newFile.renameTo(currentFile);
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in updating the password");
    	}
    }
}

public class SocialMediaController implements updateUserInformation{
    private Scene scene;
    private Parent root; 

    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    private Label userWelcomeMessage;   
    @FXML
    private Button UpdateUserInfo;
    @FXML
    private Button AddPost;    
    @FXML
    private Button RemovePost;  
    @FXML
    private Button RetrievePost;
    @FXML
    private Button UpdateSubmit;
    @FXML
    private Label welcomUsername;      
    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private Label invalidRegistrationCredentials;
    @FXML
    private TextField loginUsernameTextField;   
    @FXML
    private TextField updateUserName;
    @FXML
    private TextField updateFirstName;
    @FXML
    private TextField updateLastName;
    @FXML
    private TextField updatePassword;
    @FXML
    private Label invalidUpdateInfo;
    // posts addition/retrieval/deletion fields
    @FXML
    private Button AddPostSubmit;    
    @FXML
    private Button BackButton;
    @FXML
    private TextField postID;
    @FXML
    private TextField postContent;    
    @FXML
    private TextField postAuthor;    
    @FXML
    private TextField postLikes;      
    @FXML
    private TextField postShares; 
    @FXML
    private DatePicker postDate;
    @FXML
    private Label invalidPostInput; 
    
    // initialised logged on user variable, will be updated with the logged username
    public static String loggedUser = "";   

    
    public void setUsernameLabel( String username) {
    	 welcomUsername.setText(username);
    	 loggedUser = username;
    	}

    @FXML
    private void onUpdateUserInfo() throws IOException {   
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/UpdateUserInfo.fxml"));
        root = loader2.load();
        
        SocialMediaController UserInterfaceController = loader2.getController();

        Stage stage = (Stage) UpdateUserInfo.getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    	@FXML
		private void onUpdateSubmit() throws IOException {
    	    if (!updateUserName.getText().isBlank()) {  	    	   	
	    	updateUserInformation.updateUserName(loggedUser, updateUserName.getText().toString());
	    	invalidUpdateInfo.setText("Username has been updated successfully");
	    	invalidUpdateInfo.setStyle(successMessage);	 	    	
    	    }
    	    
    	    else if (!updateFirstName.getText().isBlank()) {  	    	   	
	    	updateUserInformation.updateFirstName(loggedUser, updateFirstName.getText().toString());
	    	invalidUpdateInfo.setText("First Name has been updated successfully");
	    	invalidUpdateInfo.setStyle(successMessage);	    		    	
    	    }    
    	    
    	    else if (!updateLastName.getText().isBlank()) {  	    	   	
	    	updateUserInformation.updateLastName(loggedUser, updateLastName.getText().toString());
	    	invalidUpdateInfo.setText("Last Name has been updated successfully");
	    	invalidUpdateInfo.setStyle(successMessage);	    	
    	    }     
   	    
    	    
    	    else if (!updatePassword.getText().isBlank()) {  	    	   	
	    	updateUserInformation.updatePassword(loggedUser, updatePassword.getText().toString());
	    	invalidUpdateInfo.setText("Password has been updated successfully");
	    	invalidUpdateInfo.setStyle(successMessage);
    	    }
    	    
    	    else {
    	    	invalidUpdateInfo.setText("Only one record is allowed to be updated at a time");
    	    	invalidUpdateInfo.setStyle(errorMessage);
    	    }		
	    } 

    	
    	@FXML
    	private void onAddPost() throws IOException { 

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/AddSocialMediaPost.fxml"));
        root = loader2.load();
        
        SocialMediaController UserInterfaceController = loader2.getController();

        Stage stage = (Stage) AddPost.getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    } 
    	@FXML
		private void onAddPostSubmit() throws NumberFormatException, Exception {
        	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
        	smHandler.AddPost(Integer.parseInt(postID.getText()), postContent.getText().toString(), loggedUser, 
        			Integer.parseInt(postLikes.getText()), Integer.parseInt(postShares.getText()), postDate.getValue() );
        	invalidPostInput.setText("The post has been added successfully");
        	invalidPostInput.setStyle(successMessage);
    	    }        	

    	
    	@FXML
		private void onBackButton() {
    		
    	}
    	
	
    @FXML
    	private void onRemovePost() throws IOException {    	
    } 
    @FXML
    	private void onRetrievePost() throws IOException {    	
    } 
   }