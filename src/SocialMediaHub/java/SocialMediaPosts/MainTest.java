package SocialMediaHub.java.SocialMediaPosts;
import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.*;

import org.junit.Test;
import org.junit.*;

public class MainTest {
    SocialMEdiaPostsHandler main = new SocialMEdiaPostsHandler();  
    
	final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final InputStream original = System.in;
    
	final int postID = 100;
	final String postContent = "This junit test post content";
	final String postAuthor = "This junit test post content";
	final int postLikes = 255;
	final int postShares = 255;
	final String stringPostDate = "17/07/2023 10:00";
	final LocalDateTime postDate  = LocalDateTime.now();
	
	Post testPost = new Post(postID, postAuthor, postAuthor, postLikes, postShares, postDate);

    // Setup the class objects, runs before all
	@Before
	public void setup() {
		testPost.setPostID(postID);
		testPost.setPostContent(postContent);
		testPost.setPostAuthor(postAuthor);
		testPost.setPostLikes(postLikes);
		testPost.setPostShares(postShares);
		testPost.setPostDate(postDate);
	}
	
	// Reset the objects, runs after all
	 @After
	 public void tearDown() throws Exception {
		 System.setIn(original);    

		 testPost=null;
	 }	 	 
	
	// Test menu option 1, the post addition option with all inputs are valid
	@Test
	public void testMenuOption1Success() throws Exception  {
	
	    String[] args = null;
	    int option = 1;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + postID + "\n" + postContent + "\n" + postAuthor + "\n"  + postLikes + "\n" + postShares + "\n"  + stringPostDate + "\n" ;
	    System.out.println(choice);
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("The post has been added to the collection!"));
	}

	// Test menu option 1, the post addition option with an invalid input, post id string instead of int
	@Test (expected=InputMismatchException.class)
	public void testMenuOption1Exception() throws Exception  {	
	    String[] args = null;
	    int option = 1;
	    String invalidPostID = "test";
	    System.setOut(new PrintStream(outputStream));	    
	    String choice = option + "\n"  + invalidPostID + "\n" + postContent + "\n" + postAuthor + "\n"  + postLikes + "\n" + postShares + "\n"  + stringPostDate + "\n" ;
	    System.out.println(choice);
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    System.out.println(outputStream.toString());
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Invalid input format, Please start over by entering integer type input value"));
	}
	
	// Test menu option 2, delete post option of the menu, post ID exists in the collection
	@Test
	public void testMenuOption2Success() throws Exception  {	
	    String[] args = null;
	    int option = 2;
	    int validPostId = 10;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + validPostId;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("The post has been deleted successfully!"));
	}
	
	// Test menu option 2, delete post option of the menu, post ID doesn't exist in the collection
	@Test (expected=IllegalArgumentException.class)
	public void testAnalyzerOption2Exception() throws Exception  {	
	    String[] args = null;
	    int option = 2;
	    int validPostId = 100;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + validPostId;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Sorry the post does not exist in the collection!"));
	}
	// Test menu option 3, the post retrieval menu option, post ID exists in the collection
	@Test
	public void testMenuOption3Success() throws Exception  {	
	    String[] args = null;
	    int option = 3;
	    int validPostId = 10;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + validPostId;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Please find below the retrieved post details!"));
	}
	
	// Test menu option 3, the post retrieval menu option, post ID doesn't exist in the collection
	@Test (expected=IllegalArgumentException.class)
	public void testAnalyzerOption3Exception() throws Exception  {	
	    String[] args = null;
	    int option = 3;
	    int validPostId = 100;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + validPostId;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Sorry the post does not exist in the collection!"));
	}	

	//Test menu option 4, the top N most liked posts, N is less than the total posts in the collection
	@Test
	public void testMenuOption4SmallNValue() throws Exception  {	
	    String[] args = null;
	    int option = 4;
	    int top = 2;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + top;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Please find the top " + top + " liked posts in the collection"));
	    
	}
	
	// Test menu option 4, the top N most liked posts, N is more than the total posts in the collection
	public void testMenuOption4SLargeNValue() throws Exception  {	
	    String[] args = null;
	    int option = 4;
	    int top = 100;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + top;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Only 5 posts exist in the collection. Showing all of them."));
	}	
	//Test menu option 5, the top N most shared posts, N is less than the total posts in the collection
	@Test
	public void testMenuOption5SmallNValue() throws Exception  {	
	    String[] args = null;
	    int option = 5;
	    int top = 2;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + top;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Please find the top " + top + " shared posts in the collection"));
	    
	}
	
	// Test menu option 5, the top N most shared posts, N is more than the total posts in the collection
	public void testMenuOption5SLargeNValue() throws Exception  {	
	    String[] args = null;
	    int option = 5;
	    int top = 100;
        System.setOut(new PrintStream(outputStream));
	    String choice = option + "\n"  + top;
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Only 5 posts exist in the collection. Showing all of them."));
	}	

	// Test menu option 6, exist option
	public void testMenuOption6() throws Exception  {	
	    String[] args = null;
        System.setOut(new PrintStream(outputStream));
	    String choice = "6";
	    System.out.println(choice);
	    System.out.println(outputStream.toString());
	    InputStream in = new ByteArrayInputStream(choice.getBytes());
	    System.setIn(in);
	    SocialMEdiaPostsHandler.main(args);
	    assertTrue(outputStream.toString()
	    	      .trim().contains("Thanks for using Social Media Analyzer!"));
	}	
}
