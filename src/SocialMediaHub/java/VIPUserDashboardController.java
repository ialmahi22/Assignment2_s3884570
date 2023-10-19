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
//    private final String user = new SimpleObjectProperty<>() ;

//    public String userProperty() {
//    	welcomUsername.setText(user);
//        return user ;
//    }
//    
//	public VIPUserDashboardController(String user) {
//		super(user);
//	}

//
//	public void setCommonDashboardController(CommonDashboardController commonDashboardController ) {
//		this.commonDashboardController = commonDashboardController;
//	}
//	}
	
//    public void someMethod() {
//        // Access the variable in the parent controller
//
//    }
    
	// Declare FXML parameters
    @FXML
    private Label welcomUsername;   
    
	@FXML
	private PieChart postsSharesPieChart;
	@FXML
	private PieChart postsLikesPieChart;
	
	public String loggedUser;
	public void setUser(String username) {
		welcomUsername.setText(username);
		loggedUser = username;
		}

      
    // Create intialise to load the data before the window is populated
    public void initialize(URL url, ResourceBundle resourceBundle) {       
    	HashMap<String, Integer> returnedTopNLikedPosts;
    	int twoDigitsValue = 0;
    	int threeDigitsValue = 0;
    	int fourDigitsValue = 0;    	
		try {
			returnedTopNLikedPosts = smHandler.retrieveTopNLikedPosts(100);
	    	for (Map.Entry<String, Integer> set : returnedTopNLikedPosts.entrySet()) {
	    		if (set.getValue() > 0 && set.getValue() < 100) {
	    			twoDigitsValue = twoDigitsValue + 1;
	    		} 
	    		else if(set.getValue() >= 100 && set.getValue() < 1000) {
	    			threeDigitsValue = threeDigitsValue + 1;
	    		}
	    		else {
	    			fourDigitsValue = fourDigitsValue + 1;
	    		}
	    	}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	ObservableList<PieChart.Data> postsPieChartData = FXCollections.observableArrayList(
    					new PieChart.Data("Less than 100 likes", twoDigitsValue),
    					new PieChart.Data("Less than 1000 likes", threeDigitsValue),
    					new PieChart.Data("More than 1000 likes", fourDigitsValue));

     	ObservableList<PieChart.Data> postsSharesPieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Less than 100 shares", twoDigitsValue),
				new PieChart.Data("Less than 1000 shares", threeDigitsValue),
				new PieChart.Data("More than 1000 shares", fourDigitsValue));
    	
//    	postsPieChartData.forEach(data ->
//    			data.nameProperty().bind(
//    					Bindings.concat(
//    							data.getName(), "Number: ", data.pieValueProperty()
//    							)
//    					)
//    			);
    	postsSharesPieChart.getData().addAll(postsSharesPieChartData);
    	postsLikesPieChart.getData().addAll(postsPieChartData);
        }        
    
    

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
//	        	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
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
	    	
		@FXML 
		public void onRetrievePostSubmit() throws NumberFormatException, Exception {
//			SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
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
		
//			SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
			
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