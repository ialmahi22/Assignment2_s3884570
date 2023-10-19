//SocialMEdiaPostsHandler.java
package SocialMediaHub.java.SocialMediaPosts;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaPostsHandler implements postsFileProcessor {
	
	// method to process the integer input fields and handles the exception
	public static void handleNumericInput(String message, int var, Scanner scan){
	try {
		System.out.println(message);
		var = scan.nextInt();	
		// consume the remaining empty newline from previous scan
        scan.nextLine();
     
	    }
	
    catch (InputMismatchException exc) {
    	System.out.println("Invalid input format, Please start over by entering integer type input value");  
    	
    	// stop program execution by throwing the exceptionS
    	throw exc;
    	}  
	}
	
	// method to process the string input fields and throws exception if the content is numeric or empty/null
	public static void handleStringInput(String message, String var, Scanner scan){
		// process the post content scanner
	    try {

			System.out.println(message);
			var = scan.nextLine();
	        
	        }
    	catch (InputMismatchException exc) {
    		System.out.println("Invalid input format, Please start over by entering String type input value");  
    	
    		// stop program execution by throwing the exceptionS
    		throw exc;
    		}  			
	    
		// check if the post content are only digits
	    boolean containsDigitsOnly = var.matches("[0-9]+");
	    if (containsDigitsOnly) {
           // stop program execution by throwing the exception
	    	throw new IllegalArgumentException("You entered digits only input, Please start over by entering String type input value");
	    	}  
	    else if (var == null || var.isEmpty()){
	        throw new IllegalArgumentException("Your input is empty or null, Please start over by entering String type input");

	      }
	}

	// method to process the string input fields and throws exception if the content is numeric or empty/null
	public static LocalDateTime handleDateInput(String var){
		// process the post content scanner
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
		final LocalDateTime postFormattedDate;
	    try {
            postFormattedDate = LocalDateTime.parse(var, formatter);	        
	        }
    	catch (InputMismatchException exc) {
    		System.out.println("Invalid date format, Please start over by entering String type of format DD/MM/YYYY HH:MM");  
    	
    		// stop program execution by throwing the exceptionS
    		throw exc;
    		}  			
	    
		return postFormattedDate;
	}


	public void addPost( Integer postID, String postContent, String  postAuthor, Integer postLikes, Integer postShares, LocalDateTime postDate ) throws Exception {
		
		postsFileProcessor.addPost(postID, postContent, postAuthor, postLikes, postShares, postDate );

	  }	

	public void removePost( Integer postID ) throws Exception {		
		postsFileProcessor.removePost(postID );
	  }

	public String retrievePost( Integer postID ) throws Exception {		
		
		String returnedPost = postsFileProcessor.retrievePost(postID );
		return returnedPost;
	  }
			
	
	// Below code used to get the top N liked posts, it utilises code from the returnPostsCollection section 
	// of the interface postsFileProcessor
	public HashMap<String, Integer> retrieveTopNLikedPosts( Integer numberOfPosts ) throws Exception {		
		
		ArrayList<String> postsCollection = postsFileProcessor.returnPostsCollection( );
		HashMap<String, Integer> returnedTopLikedPosts = postsFileProcessor.getTopNPosts("likes", numberOfPosts, postsCollection );

		return returnedTopLikedPosts;
	  }	

	// Below code used to get the top N liked posts, it utilises code from the returnPostsCollection section 
	// of the interface postsFileProcessor
	public HashMap<String, Integer> retrieveTopNSharedPosts( Integer numberOfPosts ) throws Exception {		
		
		ArrayList<String> postsCollection = postsFileProcessor.returnPostsCollection( );
		HashMap<String, Integer> returnedTopSharedPosts = postsFileProcessor.getTopNPosts("shares", numberOfPosts, postsCollection );

		return returnedTopSharedPosts;
	  }	
	}	
interface postsFileProcessor {
	static String filename = ("src/SocialMediaHub/files/posts.csv");
    
	static void addPost(Integer postID, String postContent, String  postAuthor, Integer postLikes, Integer postShares, LocalDateTime postDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
    	File csvFile = new File(filename);
    	
    	String formattedPostDate= postDate.format(formatter);
    	
    	try {
    		FileWriter fileWrite = new FileWriter(csvFile, true);
    		fileWrite.append(postID + " ," + postContent + ", " + postAuthor + ", " + postLikes + ", " + 
    				postShares + ", " + formattedPostDate + "\n");	

    		fileWrite.close();
    		
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in adding the new post");
    	}
    }
	static void removePost(Integer postID) {

    	String tmpFile = ("src/SocialMediaHub/files/tmpposts.csv");
    	File currentFile = new File(filename);
    	File newFile = new File(tmpFile);
    	
    	int ID = 0;
    	String content = "";
    	String author = "";
    	int likes = 0;
    	int shares = 0;
    	String postDate = "";
    	try {
    		FileWriter fileWrite = new FileWriter(newFile, true);
    		BufferedWriter bufWrite = new BufferedWriter(fileWrite);
    		PrintWriter printWrite = new PrintWriter(bufWrite);      		       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		// skip the header
    		String skip =  scan.nextLine();
    		
    		printWrite.print(skip + "\n");
    		while(scan.hasNext())
    		{
    			ID = Integer.parseInt(scan.next());
    			content = scan.next();
    			author = scan.next();
    			likes = Integer.parseInt(scan.next());
    			shares = Integer.parseInt(scan.next());
    			postDate = scan.next();

    			if(ID != postID) {
    				printWrite.print(ID + "," + content + "," + author + "," + likes + "," + shares + "," + postDate + "\n");
    				}
    			else {
    				continue;
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
    		System.out.println("Error in removing the post");
    	}
    }

	static String retrievePost(Integer postID) {   	
    	int ID = 0;
    	String content = "";
    	String author = "";
    	int likes = 0;
    	int shares = 0;
    	String postDate = "";
    	String retrievedPost = "";
    	try {       		
    
    		Scanner scan = new Scanner(new File(filename));
    		scan.useDelimiter("[,\n]");
    		
    		// skip the header line
    		scan.nextLine();
    		
    		while(scan.hasNext())
    		{
    			ID = Integer.parseInt(scan.next());
    			content = scan.next();
    			author = scan.next();
    			likes = Integer.parseInt(scan.next());
    			shares = Integer.parseInt(scan.next());
    			postDate = scan.next();

    			if(ID == postID) {
    				retrievedPost = (ID + "," + content + "," + author + "," + likes + "," + shares + "," + postDate);
    				}
    			else {
    				continue;
    			}
    		 }    			
    		scan.close();

    	}
    	catch (Exception e) 
    	{
    		System.out.println("Error in retrieving the post");
    	}
		return retrievedPost;
	}

	static ArrayList<String> returnPostsCollection() 	{
		   ArrayList<String> postsCollection = new ArrayList<>();
	   try {
		   String l = "";
		   BufferedReader buffr = new BufferedReader(new FileReader(filename));
		   
		   while((l = buffr.readLine()) !=null) {
			   postsCollection.add(l + "\n");		
		   }
		   buffr.close();
	   }  

	   catch (FileNotFoundException e) {
	      e.printStackTrace();
	   }
	   catch (IOException e) {
	      e.printStackTrace();
	   }
	return postsCollection;
	}

	// method to sort the collection and get the top N likes or shares
	static LinkedHashMap<String, Integer> getTopNPosts(String type, Integer topN, ArrayList collection){
	    try {
		    			
	    	HashMap<String, Integer> postHashmap = new HashMap<String, Integer>();
	    	LinkedHashMap<String, Integer> returnedTopPosts = new LinkedHashMap<String, Integer>();
    	
			for (int i = 1; i < collection.size(); i++) {
				String[] strValue = collection.get(i).toString().split(",");
	
				if (type == "shares") {
					postHashmap.put(strValue[1], Integer.parseInt(strValue[4]));
					}	
				
				else if(type == "likes") {
					postHashmap.put(strValue[1], Integer.parseInt(strValue[3]));

					}
	            }	
			
			// order the post likes/shares in a decending order
			
		    LinkedHashMap<String, Integer> postLinkedHashmap = postHashmap.entrySet()
			           .stream()             
			           .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			           .collect(Collectors.toMap(e -> e.getKey(), 
			                                     e -> e.getValue(), 
			                                     (e1, e2) -> null, // or throw an exception
			                                     () ->new LinkedHashMap<String, Integer>()));
			    
		    // Add the top N posts in a new MAP to be returned to the JavaFx methods
			if(topN < postLinkedHashmap.size())
			{
				int index = 0;
		        for (Map.Entry<String, Integer> set : postLinkedHashmap.entrySet()) 
		        {
		        	if (index < topN)
		        	{
		        		returnedTopPosts.put(set.getKey() , set.getValue());			            
		        	}	 
		        	index++;	
	            }							
		    }
			else {
				// Since the requested number of posts is more that the number in the collection, will print all of them
				for (Map.Entry<String, Integer> set : postLinkedHashmap.entrySet())
				{
			    	returnedTopPosts.put(set.getKey() , set.getValue());			
				}
			  }			    
		return returnedTopPosts;
			   
	     }
    	catch (InputMismatchException exc) {
    		System.out.println("Invalid top input format, Please start over by entering integer type for top posts");      	
    		// stop program execution by throwing the exceptionS
    		throw exc;
    		}
	}
}
