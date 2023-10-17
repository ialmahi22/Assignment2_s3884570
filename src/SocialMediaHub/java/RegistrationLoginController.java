package SocialMediaHub.java;

import java.awt.event.ActionEvent;
//
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistrationLoginController {

    // Strings which hold css elements to easily re-use in the application
    protected static
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    
    private Stage stage;
    private Scene scene;
    private Parent root;    

    // Import the application's controls
    @FXML
    private Button cancelButton;
    @FXML
    private Button LoginButton;    
    @FXML
    private Label invalidLoginCredentials;
    @FXML
    private Label invalidRegistrationCredentials;
    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;
    @FXML
    private TextField RegisterationUsernameField;
    @FXML
    private TextField RegisterationFirstNameField;
    @FXML
    private TextField RegisterationLastNameField;    
    @FXML
    private TextField RegisterationPasswordField;
    @FXML
    private TextField RegisterationConfirmPasswordField;
    
    public static boolean[] verifyRegisterandLogin(String user, String password, String file, String type) throws FileNotFoundException
    {
    	boolean verifyLoginOutcome = false;
    	boolean verifyRegistrationOutcome = false;
    	String tmpUser = "";
    	String tmpFirstName = "";
    	String tmpLastname = "";
    	String tmpPassword = "";

    		Scanner scan = new Scanner(new File(file));
    		scan.useDelimiter("[,\n]");
    		
    		while(scan.hasNext())
    		{
    			tmpUser = scan.next();
    			tmpFirstName = scan.next();
    			tmpLastname = scan.next();
    			tmpPassword = scan.next();
    			
    			if(type.equals("registration"))
    				{
    				
    				if(tmpUser.trim().equals(user.trim()))
    						{
    							verifyRegistrationOutcome = false;;
      						}    				
    			    }
    			else if(type.equals("login") && tmpUser.trim().equals(user.trim()) && tmpPassword.trim().equals(password.trim()))
    					{
    				verifyLoginOutcome = true;

    					}   			
    		
    		}
    		scan.close();
    		

    		return new boolean[] { verifyLoginOutcome, verifyRegistrationOutcome };
    	}

    // Creation of methods which are activated on events in the forms
    @FXML
    protected void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onRegisterButton() throws IOException {

        if (RegisterationUsernameField.getText().isBlank() || RegisterationFirstNameField.getText().isBlank() || 
        		RegisterationLastNameField.getText().isBlank() ||  RegisterationPasswordField.getText().isBlank() || RegisterationConfirmPasswordField.getText().isBlank()) {
            invalidRegistrationCredentials.setText("Please fill in all fields!");
            invalidRegistrationCredentials.setStyle(errorMessage);
            invalidLoginCredentials.setText("");

            if (RegisterationUsernameField.getText().isBlank()) {
                RegisterationUsernameField.setStyle(errorStyle);
            }  else if (RegisterationPasswordField.getText().isBlank()) {
                RegisterationPasswordField.setStyle(errorStyle);
            } else if (RegisterationConfirmPasswordField.getText().isBlank()) {
                RegisterationConfirmPasswordField.setStyle(errorStyle);
            }
        } else if (RegisterationConfirmPasswordField.getText().equals(RegisterationPasswordField.getText())) {
        	// verify whether the same usename exists
        	String filename = ("src/SocialMediaHub/files/users.txt");

        	boolean[] registerOutcome  = verifyRegisterandLogin(RegisterationUsernameField.getText().toString(),RegisterationPasswordField.getText().toString(), filename, "registration") ;
        	// check the registration verification results, second returned boolen is false
        	if(!registerOutcome[1]) {              
	        	// The verification is successful, store the users information in the users file
	        	StringBuilder build = new StringBuilder();
	        	build.append(RegisterationUsernameField.getText().toString() + "," + RegisterationFirstNameField.getText().toString() + 
	        			"," + RegisterationLastNameField.getText().toString() + "," + RegisterationPasswordField.getText().toString() + "\r\n");
	
	        	File credentials = new File(filename);
	        	FileWriter fw = new FileWriter(credentials, true);
	        	BufferedWriter br = new BufferedWriter(fw);
	        	br.write(build.toString());
	        	br.close();
	        	fw.close();
	        	
	        	// display success registration message in the user's GUI
	            invalidRegistrationCredentials.setText("Registration completed successfully!");
	            invalidRegistrationCredentials.setStyle(successMessage);
	            RegisterationUsernameField.setStyle(successStyle);
	            RegisterationPasswordField.setStyle(successStyle);
	            RegisterationConfirmPasswordField.setStyle(successStyle);
	            invalidLoginCredentials.setText("");
        	}
        	else {
	        	// The username provided is taken by previous registered users, display the failure message
	            invalidRegistrationCredentials.setText("Username is take, please choose different username");
	            invalidRegistrationCredentials.setStyle(errorStyle);
	            RegisterationUsernameField.setStyle(errorStyle);
	            RegisterationPasswordField.setStyle(errorStyle);
	            RegisterationConfirmPasswordField.setStyle(errorStyle);
	            invalidLoginCredentials.setText("");
        	}
	            
        } else {
            invalidRegistrationCredentials.setText("The Passwords don't match!");
            invalidRegistrationCredentials.setStyle(errorMessage);
            RegisterationPasswordField.setStyle(errorStyle);
            RegisterationConfirmPasswordField.setStyle(errorStyle);
            invalidLoginCredentials.setText("");
        }
    }
    
    @FXML
    private void onLoginButton() throws IOException {
        if (loginUsernameTextField.getText().isBlank() || loginPasswordPasswordField.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidRegistrationCredentials.setText("");

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
        } else {
        	String filename = ("src/SocialMediaHub/files/users.txt");

        	boolean[] loginOutcome = verifyRegisterandLogin(loginUsernameTextField.getText().toString(),loginPasswordPasswordField.getText().toString(), filename, "login");
        	
        	// check the login verification results, first returned boolen
        	if(loginOutcome[0]) {
        		// display success registration message in the user's GUI
                invalidLoginCredentials.setText("Login Successful!");
                invalidLoginCredentials.setStyle(successMessage);
                loginUsernameTextField.setStyle(successStyle);
                loginPasswordPasswordField.setStyle(successStyle);
                invalidRegistrationCredentials.setText("");

                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../resources/UserDashboard.fxml"));
                root = loader1.load();
                
                UserInterfaceController userInterfaceController = loader1.getController();
                userInterfaceController.setUsernameLabel(loginUsernameTextField.getText().toString());

                Stage stage = (Stage) LoginButton.getScene().getWindow();
                
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();               		
        	}
        	
        	else {
                invalidLoginCredentials.setText("Invalid username or password!");
                invalidLoginCredentials.setStyle(errorMessage);
                loginUsernameTextField.setStyle(errorStyle);
                loginPasswordPasswordField.setStyle(errorStyle);
                invalidRegistrationCredentials.setText("");
        	}
        	



        }

    }    	 
}