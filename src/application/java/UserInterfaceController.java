package application.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



interface updateUserInformation {

    
    static void updatePassword(String user, String newpassword) {
    	String filename = ("src/application/files/users.txt");
    	String tmpFile = ("src/application/files/tmpusers.txt");
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
    		System.out.println("Error");
    	}
    }
//    void speedUp(int a);
//    void applyBrakes(int a);
}

public class UserInterfaceController implements updateUserInformation{
    private Scene scene;
    private Parent root; 
    
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
    
       
    public void setUsernameLabel( String username) {
    	welcomUsername.setText(username);
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
	    	updateUserInformation.updatePassword("ibrahim", "ConjuConju");
		
	    } 

    @FXML
    	private void onAddPost() throws IOException {    	
    } 
    @FXML
    	private void onRemovePost() throws IOException {    	
    } 
    @FXML
    	private void onRetrievePost() throws IOException {    	
    } 
   }