/*

 * VIPUserDashboardController:
 *   Contains the javafx methods to load the normal user dashboards and enable the functionalities for the VIP users, options provided:
 * 1. Piecharts showing the distribution of the shared and liked posts, categorised
 * 2. Update the user's profile information
 * 3. Add social media post
 * 4. Remove social media post
 * 5. Retrieve social media post
 * 6. Retrieve top N liked or shared posts
 * 
 * Version: v1.0
 *
 * Date: 20 Oct 2023
 * 
 * Copyright to RMIT, Oct 2023
 */
package SocialMediaHub.java;

import java.io.IOException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import SocialMediaHub.java.SocialMediaPosts.SocialMediaPostsHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VIPUserDashboardController implements Initializable {
	
	SocialMediaPostsHandler smHandler = new SocialMediaPostsHandler();
    
	/* Declare the parameters/variables defined in the FXML files */
    @FXML
    private Label welcomUsername;       
	@FXML
	private PieChart postsSharesPieChart;
	@FXML
	private PieChart postsLikesPieChart;
	private Scene scene;
    private Parent root; 

    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");
    
    // FXML declarations for the user dashboard
    
    @FXML
    public Button VIPOptIn;
    @FXML
    public Button UpdateUserInfo;
    @FXML
    public Button AddPost;    
    @FXML
    public Button RemovePost;  
    // VIP subscription button
    @FXML
    public Button VIPSubscribe;
    @FXML
    public Label vipSubscriberMessage;
    
    // Update user information
    @FXML
    public Button UpdateSubmit;   
    @FXML
    public Label invalidLoginCredentials;
    @FXML
    public Label invalidRegistrationCredentials;
    @FXML
    public TextField loginUsernameTextField;   
    @FXML
    public TextField updateUserName;
    @FXML
    public TextField updateFirstName;
    @FXML
    public TextField updateLastName;
    @FXML
    public TextField updatePassword;
    @FXML
    public Label invalidUpdateInfo;
    // posts addition/retrieval/deletion fields
    @FXML
    public Button AddPostSubmit;    
    @FXML
    public TextField postID;
    @FXML
    public TextField postContent;    
    @FXML
    public TextField postLikes;      
    @FXML
    public TextField postShares; 
    @FXML
    public DatePicker postDate;
    @FXML
    public Label invalidPostInput; 
    
    // post removal fxml gui
    @FXML
    public Button RemovePostSubmit;
    @FXML
    public TextField removePostID;
    @FXML
    public Label invalidPostID; // shared with retrieve a post
    
    // Retrieve a post
    @FXML
    public Button RetrievePost;
    @FXML
    public Button RetrievePostSubmit;
    @FXML
    public TextField retrievePostID;    
    @FXML
    public Label retrievedPost;
    
    // Retrieve TOP N Liked Posts
    @FXML
    public Button TopNLikedPosts;
    @FXML
    public Button RetrieveTopNLikedSubmit;
    @FXML
    public TextField retrieveTopNLikedPosts;
    @FXML
    public TableView<TopNPosts> retrievedTopNLikedTable;
    @FXML
    public TableColumn<TopNPosts, String> retrievedLikedPostContent = new TableColumn<TopNPosts, String>("postContent");
    @FXML
    public TableColumn<TopNPosts, Integer> retrievedPostLikes = new TableColumn<TopNPosts, Integer>("numberOfInteractions");
    @FXML
    public Label retrievedTopNPostsMessage; // Used to write the message to the user for the top N shared and liked posts

    // Retrieve TOP N Shared Posts
    @FXML
    public Button TopNSharedPosts;
    @FXML
    static Button RetrieveTopNLSharedSubmit;
    @FXML    
    public TableView<TopNPosts> retrievedTopNSharedTable;
    @FXML
    public TableColumn<TopNPosts, String> retrievedSharedPostContent = new TableColumn<TopNPosts, String>("postContent");
    @FXML
    public TableColumn<TopNPosts, Integer> retrievedPostShares = new TableColumn<TopNPosts, Integer>("numberOfInteractions");
    @FXML
    public TextField retrieveTopNSharedPosts;
    	
	
	/* Define the loggeduser and provide a setter to pass the successfully logged on username
	 * the loggedUser will be used in various methods, for example to be used as the key to fetch and update the user's information
    */
	public String loggedUser;
	public void setUser(String username) {
		welcomUsername.setText(username);
		loggedUser = username;
		}

	/* Initialise the VIP user's piechart data, initialiser loads the data when the window/dashboard is opened 
	 * The data plotted in the piechart is categorised based on the number of likes/shares range:
	 * - Likes/Shares from zero to 99
	 * - Likes/Shares from 100 to 999
	 * - Likes/Shares with more than 1000
	 */
      
    public void initialize(URL url, ResourceBundle resourceBundle) {       
    	HashMap<String, Integer> returnedTopNLikedPosts;
    	HashMap<String, Integer> returnedTopNSharedPosts;

    	int twoDigitLikedPosts = 0;
    	int threeDigitLikedPosts = 0;
    	int fourDigitLikedPosts = 0;   

    	int twoDigitSharedPosts = 0;
    	int threeDigitSharedPosts = 0;
    	int fourDigitSharedPosts = 0; 
    	
		try {
			returnedTopNLikedPosts = smHandler.retrieveTopNLikedPosts(1000);
			returnedTopNSharedPosts = smHandler.retrieveTopNSharedPosts(1000);
			
	    	for (Map.Entry<String, Integer> set : returnedTopNLikedPosts.entrySet()) {
	    		if (set.getValue() > 0 && set.getValue() < 100) {
	    			twoDigitLikedPosts = twoDigitLikedPosts + 1;
	    		} 
	    		else if(set.getValue() >= 100 && set.getValue() < 1000) {
	    			threeDigitLikedPosts = threeDigitLikedPosts + 1;
	    		}
	    		else {
	    			fourDigitLikedPosts = fourDigitLikedPosts + 1;
	    		}
	    	}
	    	for (Map.Entry<String, Integer> set : returnedTopNSharedPosts.entrySet()) {
	    		if (set.getValue() > 0 && set.getValue() < 100) {
	    			twoDigitSharedPosts = twoDigitSharedPosts + 1;
	    		} 
	    		else if(set.getValue() >= 100 && set.getValue() < 1000) {
	    			threeDigitSharedPosts = threeDigitSharedPosts + 1;
	    		}
	    		else {
	    			fourDigitSharedPosts = fourDigitSharedPosts + 1;
	    		}
	    	}	    	
		} catch (Exception e) {
			e.printStackTrace();
		}    	

		/* Create observalelist to store the data to be graphed by PieChart */

    	ObservableList<PieChart.Data> postsLikessPieChartData = FXCollections.observableArrayList(
    					new PieChart.Data("Less than 100 likes", twoDigitLikedPosts),
    					new PieChart.Data("Less than 1000 likes", twoDigitLikedPosts),
    					new PieChart.Data("More than 1000 likes", twoDigitLikedPosts));

     	ObservableList<PieChart.Data> postsSharesPieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Less than 100 shares", twoDigitSharedPosts),
				new PieChart.Data("Less than 1000 shares", threeDigitSharedPosts),
				new PieChart.Data("More than 1000 shares", fourDigitSharedPosts));
    	
		/* Add the data to the piechart graphs */
    	postsLikesPieChart.getData().addAll(postsLikessPieChartData);
    	postsSharesPieChart.getData().addAll(postsSharesPieChartData);
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