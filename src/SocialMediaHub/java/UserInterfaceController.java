package SocialMediaHub.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import SocialMediaHub.java.*;
import SocialMediaHub.java.SocialMediaPosts.SocialMediaPostsHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//SocialMediaPostsHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



interface updateUserInformation {

    
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

public class UserInterfaceController implements updateUserInformation{
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
    
    // post removal fxml gui
    @FXML
    private Button RemovePostSubmit;
    @FXML
    private TextField removePostID;
    @FXML
    private Label invalidPostID; // shared with retrieve a post
    
    // Retrieve a post
    @FXML
    private Button RetrievePost;
    @FXML
    private Button RetrievePostSubmit;
    @FXML
    private TextField retrievePostID;    
    @FXML
    private Label retrievedPost;
    
    // Retrieve TOP N Liked Posts
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

    // Retrieve TOP N Shared Posts
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
        
        UserInterfaceController UserInterfaceController = loader2.getController();

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

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/AddPost.fxml"));
        root = loader2.load();
        
        UserInterfaceController UserInterfaceController = loader2.getController();

        Stage stage = (Stage) AddPost.getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    	} 
    	
	    	@FXML
			private void onAddPostSubmit() throws NumberFormatException, Exception {
	        	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
	        	smHandler.addPost(Integer.parseInt(postID.getText()), postContent.getText().toString(), loggedUser, 
	        			Integer.parseInt(postLikes.getText()), Integer.parseInt(postShares.getText()), postDate.getValue().atStartOfDay() );
	        	invalidPostInput.setText("The post has been added successfully");
	        	invalidPostInput.setStyle(successMessage);
	    	    }        	
	
	    	
	    	@FXML
			private void onBackButton() {
	    		
	    	}
	    	
	
	    @FXML
    	private void onRemovePost() throws IOException {    

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RemovePost.fxml"));
        root = loader2.load();
        
        UserInterfaceController UserInterfaceController = loader2.getController();

        Stage stage = (Stage) RemovePost.getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    	} 
    	
	    	@FXML
			private void onRemovePostSubmit() throws NumberFormatException, Exception {
	        	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
	        	smHandler.removePost(Integer.parseInt(removePostID.getText()) );
	        	invalidPostID.setText("The post has been removed successfully");
	        	invalidPostID.setStyle(successMessage);
	    	    }        	
	
    
	@FXML
	 private void onRetrievePost() throws IOException {    

		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrievePost.fxml"));
	    root = loader2.load();
	        
	     UserInterfaceController UserInterfaceController = loader2.getController();

	     Stage stage = (Stage) RetrievePost.getScene().getWindow();
	        
	     scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();        
	  } 
	    	
		@FXML
		private void onRetrievePostSubmit() throws NumberFormatException, Exception {
			SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
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
	@FXML
	private void onTopNLikedPosts() throws IOException {
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrieveTopNLikedPosts.fxml"));
        root = loader2.load();
		        
	    UserInterfaceController UserInterfaceController = loader2.getController();

	    Stage stage = (Stage) TopNLikedPosts.getScene().getWindow();
	       
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();        
	} 
	    	
		@FXML
		private void onRetrieveTopNLikedSubmit() throws NumberFormatException, Exception {

		
			SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
			
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
		
		@FXML
		private void onTopNSharedPosts() throws IOException {
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../resources/RetrieveTopNSharedPosts.fxml"));
	        root = loader2.load();
			        
		    UserInterfaceController UserInterfaceController = loader2.getController();

		    Stage stage = (Stage) TopNSharedPosts.getScene().getWindow();
		       
		    scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();        
		} 
		    	
			@FXML
			private void onRetrieveTopNSharedSubmit() throws NumberFormatException, Exception {
				SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
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