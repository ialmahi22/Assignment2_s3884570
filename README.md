### Assignment 2 Data Analytics Hub #
##### Ibrahim Almahi Ibrahim Mohammed: S3884570

#### Overview
This project aims to build Java code to provide GUI applications for the end users to perform various `Data Analytics Hub` tasks, the tasks include:
* Providing the capability for the user to sign up or register for the social media data analytics hub applications, the username has to be unique
* Providing the capability for the users to log in to the GUI application
* Enabling the users to edit and update their information
          * Change the username
          * Update the first or last name
          * Change the password 
* Providing the capability for the user to opt in to upgrade to be a VIP user
* Displaying different dashboards for the normal user compared to the VIP user, the VIP user dashboard has PieCharts offering insights on the number of likes and shares for the social media posts. In addition to that, both the normal user and the VIP user dashboards expose GUI applications to

 			1. Add social media post to the collection, the post is added to the CSV file `posts.csv`, which is stored in the path `Assignment2_s3884570\src\SocialMediaHub\files`
   			2. Retrieve a social media post from the collection in the CSV file, by providing the post ID as input
   			3. Remove a social media post from the collection in the CSV file, by providing the post ID as input
   			4. Retrieve the top N liked posts 
   			5. Retrieve the top N shared posts 

- Test the code quality for any errors or bugs using Junit tests and suite
- Exceptions handling to provide meaningful messages in case users provide illegal input to the Data Analytics Hub

The project code is built taking into consideration the Object-oriented programming principles of abstraction and encapsulation, by which the main classes are hidden from the end users and the data manipulation is only done via the code built for this purpose.

The design follows the MVC design pattern.
#### The main code Components and directory structure
##### `src\SocialMediaHub.java`:
#####`Main.java`:
* This is the main Java code that provides entry to the application
* It starts JavaFX GUI window by loading the FXML file `resources/RegistrationLogin.fxml`

#####`RegistrationLoginController.java`:
* This is the javafx controller for the registration and login page
* It has the method to verify that for the new registration, the chosen username is not taken
* It stores the newly registered users in the file `SocialMediaHub.files\users.txt`
* as part of the login procedure, it checks that the user username and password are correct
* Upon successful login, depending on the user's type (VIP or normal), the corresponding dashboard is opened

#####`NormalUserDashboard.java`:
* This is the Javafx controller for normal users
* It contains the code/methods to upgrade the user to become VIP, it contains alert methods to get the confirmation from the user to become VIP
* It has the tasks to open the corresponding GUI application to update the user's information as well as do the operations on the social media posts. Several FXML files are loaded to perform these tasks

#####`VIPUserDashboard.java`:
* This is the Javafx controller for the VIP users
* When this controller is called/initialised after the successful VIP user login, it auto-populate piecharts to categorize the distribution of the number of likes and shares for the social media posts
* The FXML files used to perform the rest of the operations on the social media are shared between the normal user and VIP user dashboards

##### `src\SocialMediaHub.java.SocialMediaPosts`:
###### `SocialMediaPostsHandler.java`:
* This class contains the methods to add, remove, and retrieve social media posts as well as retrieving the top N shared and liked posts
* It implements an interface `postsFileProcessor` that provides methods to manipulate the social media posts. The interface uses JCF such as ArrayList, Hashmap, and LinkedHashmap to perform these functionalities. For example, LinkedHashmap is used to return the order of top N liked/shared posts
* This class is used by the JavaFX controllers `NormalUserDashboardController.java` and `VIPUserDashboardController.java` to interact with the social media collection

###### `TopNPosts.java`:
* This class provides setter and getter method for the social media post content and the number of likes/shares
* Its used by the JavaFX tableview columns to display the retrieve top N liked/shared posts in the GUI as tables

###### `Junit Test Cases`:
###### `SocialMediaPostsHandlerTest.java`:
* It incorporates test cases to tests the capabilities of adding, removing, and retrieving social media posts as well as getting the top N shared and liked posts
* Expected failures have also been tested by implementing test cases with invalid user inputs to make sure our code throws the appropriate exceptions in such cases.
  
#### How to run the program
###### From Windows Command Prompt:
* Open the Windows `Command Prompt` application
* Navigate to the destination folder containing the project files, for example:
  `C:\Ibrahim Data\\Assignment2_s3884570\src`
* Compile the Java code:
  `javac Main.java`

###### From Eclipse IDE:	
* Press the cursor in the main `Assignment2_s3884570` folder
* Click the green run button to run the application, the analyzer menu options will appear in the console

#### Assignment 2 Github Repository
* The code has been maintained and the changes are regularly pushed to the below Github repository:
`https://github.com/ialmahi22/Assignment2_s3884570.git`

#### References
* (No date) GitHub. Available at: https://github.com/javacodingcommunity/JavaFxLogInForm/blob/main/loginForm/src/sample/LogIn.java (Accessed: 20 October 2023). 
* Gleidsonmt (no date) GLEIDSONMT/DashboardFx: Javafx dashboard, GitHub. Available at: https://github.com/gleidsonmt/DashboardFx (Accessed: 20 October 2023). 
