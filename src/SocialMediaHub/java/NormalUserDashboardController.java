/*

 * NormalUserDashboardController class
 * Contains the javafx methods to load the normal user dashboards and enable the functionalities for the normal users, options provided:
 * 1. Upgrade to become VIP user
 * 2. Update the user's profile information
 * 3. Add social media post
 * 4. Remove social media post
 * 5. Retrieve social media post
 * 6. Retrieve top N liked or shared posts
 * 
 * 
 * Version: v1.0
 *
 * Date: 20 Oct 2023
 * 
 * Copyright to RMIT, Oct 2023
 */
package SocialMediaHub.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import SocialMediaHub.java.SocialMediaPosts.SocialMediaPostsHandler;
import SocialMediaHub.java.SocialMediaPosts.TopNPosts;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/* Interface containing methods to update the user's information */
interface updateUserInformation {
    static void vipOptIn(String username) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	String userVIP = "";
    	
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
    			userVIP = scan.next();
    			
    			if(userName.trim().equals(username.trim())) {
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," + "YES" + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," + userVIP + "\n");				
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
    		System.out.println("Error in updating the VIP subscription!");
    	}
    }
    
    static void updateUserName(String user, String newUsername) {
    	String filename = ("src/SocialMediaHub/files/users.txt");
    	String tmpFile = ("src/SocialMediaHub/files/tmpusers.txt");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	String userName = "";
    	String userFirstName = "";
    	String userLastName = "";
    	String userPassword = "";
    	String userVIP = "";
    	
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
    			userVIP = scan.next();
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(newUsername + "," + userFirstName + "," + userLastName + "," + userPassword + "," + userVIP  + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," +  userVIP  +"\n");				
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
    	String userVIP = "";
    	
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
    			userVIP = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + newFirstName + "," + userLastName + "," + userPassword + "," +  userVIP + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," +  userVIP + "\n");				
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
    	String userVIP = "";
    	
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
    			userVIP = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + userFirstName + "," + newLastName + "," + userPassword + "," + userVIP + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= ""){
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," + userVIP + "\n");				
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
    	String userVIP = "";
    	
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
    			userVIP = scan.next();
    			
    			if(userName.trim().equals(user.trim())) {
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + newpassword + "," + userVIP + "\n");
    				}
    			else if(userName!= "\n" && userName!=  null && userName!= "") {
    				printWrite.print(userName + "," + userFirstName + "," + userLastName + "," + userPassword + "," + userVIP +  "\n");				
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

public class NormalUserDashboardController implements updateUserInformation{
	/* Create an instance of the social media handler */
	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();

    private Scene scene;
    private Parent root; 

    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    
    /* FXML declarations for the user dashboard */
    @FXML
    private Label welcomUsername;   
    @FXML
    private Button VIPOptIn;
    @FXML
    private Button LogOutButton;
    @FXML
    private Button UpdateUserInfo;
    @FXML
    private Button AddPost;    
    @FXML
    private Button RemovePost;  
    /* VIP subscription button */
    @FXML
    private Button VIPSubscribe;
    @FXML
    private Label vipSubscriberMessage;
    
    /* Update user information */
    @FXML
    private Button UpdateSubmit;   
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
    /* posts addition/retrieval/deletion fields */
    @FXML
    private Button AddPostSubmit;    
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
    
    /* post removal fxml gui */
    @FXML
    private Button RemovePostSubmit;
    @FXML
    private TextField removePostID;
    @FXML
    private Label invalidPostID; // shared with retrieve a post
    
    /* Retrieve a post */
    @FXML
    private Button RetrievePost;
    @FXML
    private Button RetrievePostSubmit;
    @FXML
    private TextField retrievePostID;    
    @FXML
    private Label retrievedPost;
    
    /* Retrieve TOP N Liked Posts */
    @FXML
    private Button TopNLikedPosts;
    @FXML
    private Button RetrieveTopNLikedSubmit;
    @FXML
    private TextField retrieveTopNLikedPosts;
    @FXML
    private TableView<TopNPosts> retrievedTopNLikedTable;
    @FXML
    private TableColumn<TopNPosts, String> retrievedLikedPostContent = new TableColumn<TopNPosts, String>("postContent");
    @FXML
    private TableColumn<TopNPosts, Integer> retrievedPostLikes = new TableColumn<TopNPosts, Integer>("numberOfInteractions");
    @FXML
    private Label retrievedTopNPostsMessage; // Used to write the message to the user for the top N shared and liked posts

    /* Retrieve TOP N Shared Posts parameters*/
    @FXML
    private Button TopNSharedPosts;
    @FXML
    private Button RetrieveTopNLSharedSubmit;
    @FXML    
    private TableView<TopNPosts> retrievedTopNSharedTable;
    @FXML
    private TableColumn<TopNPosts, String> retrievedSharedPostContent = new TableColumn<TopNPosts, String>("postContent");
    @FXML
    private TableColumn<TopNPosts, Integer> retrievedPostShares = new TableColumn<TopNPosts, Integer>("numberOfInteractions");
    @FXML
    private TextField retrieveTopNSharedPosts;

    
    
    /* initialised logged on user variable, will be updated with the logged username */
	public String loggedUser;
	
	public void setUser(String username) {
		welcomUsername.setText(username);
		loggedUser = username;
		}

    /* Open the VIP user registration/opt in window if the users click on VIP button */
    @FXML
    private void onVIPOptIn() throws IOException {   
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/VIPOptIn.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();  
    }
    
    @FXML
    private void onLogOutButton() {
    	
    }
	@FXML
	private void onVIPSubscribe() throws IOException {
		/* Ask the user for CONFIRMATION */
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("VIP Subscription Confirmation!");
		Optional<ButtonType> alertResult = alert.showAndWait();
		/* Throw an error if the user does not confirm or cancel the subscription */
		if (alertResult.isEmpty()) {
			vipSubscriberMessage.setText("Please make a choice of OK or CANCEL");
			vipSubscriberMessage.setStyle(errorMessage);
		/* Update the user's record to be VIP and instruct the user to logout/login if subscription is confirmed */
		} else if (alertResult.get() == ButtonType.OK) {
			
			updateUserInformation.vipOptIn(loggedUser);
			vipSubscriberMessage.setText("Please log out and log in again to access VIP functionalities.");
			vipSubscriberMessage.setStyle(successMessage);
			
		/* Abort the subscription if the user choose not to proceed */			
		} else if(alertResult.get() == ButtonType.CANCEL) {
			vipSubscriberMessage.setText("No worries, the VIP subscription is aborted!, please close this widonw!");
			vipSubscriberMessage.setStyle(successMessage);
			}

	}
	/* Below methods will open new windows based on the users choice or button clicked */

    @FXML
     void onUpdateUserInfo() throws IOException {   
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/UpdateUserInfo.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();     

        
    	}
    	@FXML 
    	/* Only one parameter update is allowed at a time, e.g only username or password */
    	 void onUpdateSubmit( ) throws IOException {
    	    if (!updateUserName.getText().isBlank()) { 
    	    	System.out.println(loggedUser);
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
    	void onAddPost() throws IOException { 

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/AddPost.fxml"));
       
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();     
      
    	} 
    	
	    	@FXML
	    	void onAddPostSubmit() throws NumberFormatException, Exception {
	        	smHandler.addPost(Integer.parseInt(postID.getText()), postContent.getText().toString(), loggedUser, 
	        			Integer.parseInt(postLikes.getText()), Integer.parseInt(postShares.getText()), postDate.getValue().atStartOfDay() );
	        	invalidPostInput.setText("The post has been added successfully");
	        	invalidPostInput.setStyle(successMessage);
	    	    }        	
	
	    	
	
	@FXML
	public void onRemovePost() throws IOException {    

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RemovePost.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();           
    	} 
    	
	    	@FXML
	    	public void onRemovePostSubmit() throws NumberFormatException, Exception {
	        	smHandler.removePost(Integer.parseInt(removePostID.getText()) );
	        	invalidPostID.setText("The post has been removed successfully");
	        	invalidPostID.setStyle(successMessage);
	    	    }        	
	
    
	@FXML
	public void onRetrievePost() throws IOException {    

		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrievePost.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();           
	  } 
		
		/* Return the post corresponding to the entered post ID, if found */	    	
		@FXML 
		public void onRetrievePostSubmit() throws NumberFormatException, Exception {
			String returnedPost = smHandler.retrievePost(Integer.parseInt(retrievePostID.getText()) );
	        	
			if(returnedPost != "") {
				invalidPostID.setText("Please find the below retrieved post");
				invalidPostID.setStyle(successMessage);
				retrievedPost.setText(returnedPost);
	        	}
			else {
					invalidPostID.setText("There is no post found matching the provided ID!");
		       		invalidPostID.setStyle(errorMessage);
		       		retrievedPost.setText("");		        		
			}
		}   
		
	/* Return the Top N posts, if the N is larger than the total posts, return all posts */	    	
	@FXML
	public void onTopNLikedPosts() throws IOException {
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrieveTopNLikedPosts.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();       
		} 
	    	
		@FXML
		public void onRetrieveTopNLikedSubmit() throws NumberFormatException, Exception {
			HashMap<String, Integer> returnedPosts = smHandler.retrieveTopNLikedPosts(Integer.parseInt(retrieveTopNLikedPosts.getText()) );

	        ObservableList<TopNPosts> topnObservList = retrievedTopNLikedTable.getItems();

			for (Map.Entry<String, Integer> set : returnedPosts.entrySet()) {
				TopNPosts topn = new TopNPosts(set.getKey(), set.getValue());
				topn.setPostContent(set.getKey());
				topn.setNumberOfInteractions(set.getValue());
		        topnObservList.add(topn);				
			}
			retrievedLikedPostContent.setCellValueFactory(new PropertyValueFactory<TopNPosts, String>("postContent"));
			retrievedPostLikes.setCellValueFactory(new PropertyValueFactory<TopNPosts, Integer>("numberOfInteractions"));			
			retrievedTopNLikedTable.setItems(topnObservList);
			}
		
	/* Return the Top N posts, if the N is larger than the total posts, return all posts */  	
		
	@FXML 
	public void onTopNSharedPosts() throws IOException {
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrieveTopNSharedPosts.fxml"));
    	loader2.setController(this);
        root = loader2.load();
        
		Stage stage = new Stage();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
		} 
		    	
		@FXML 
		public void onRetrieveTopNSharedSubmit() throws NumberFormatException, Exception {
			HashMap<String, Integer> returnedTopNSharedPosts = smHandler.retrieveTopNSharedPosts(Integer.parseInt(retrieveTopNSharedPosts.getText()) );	

		    ObservableList<TopNPosts> topnObservList = retrievedTopNSharedTable.getItems();

			for (Map.Entry<String, Integer> set : returnedTopNSharedPosts.entrySet()) {
				TopNPosts topn = new TopNPosts(set.getKey(), set.getValue());
				topn.setPostContent(set.getKey());
				topn.setNumberOfInteractions(set.getValue());
		        topnObservList.add(topn);				
			}
			retrievedSharedPostContent.setCellValueFactory(new PropertyValueFactory<TopNPosts, String>("postContent"));
			retrievedPostShares.setCellValueFactory(new PropertyValueFactory<TopNPosts, Integer>("numberOfInteractions"));			
			retrievedTopNSharedTable.setItems(topnObservList);
			}	
   }