package SocialMediaHub.java.SocialMediaPosts;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SocialMediaPostsHandlerTest {
	SocialMediaPostsHandler smHandler  = new SocialMediaPostsHandler();
	Integer postID =888;
	String postContent = "TestUnit Post Content";
	String postAuthor = "Author is JUnit";
	Integer postLikes = 999;
	Integer postShares = 999;
	Integer topNPosts = 3;
	LocalDateTime postDate = LocalDateTime.now();	
	
	final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final InputStream original = System.in;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");


    /* Setup the class objects, runs before all */
//	@BeforeAll
//	public void setup() {
//
//	}

	// Reset the objects, runs after all
//	 @AfterAll
//	 public void tearDown() throws Exception {
//			Integer postID = null;
//			String postContent = null;
//			String  postAuthor = null;
//			Integer postLikes = null;
//			Integer postShares = null;
//			LocalDateTime postDate = null;
//			}	
//	
	@Test
	public void testAddPost() throws Exception {
        System.setOut(new PrintStream(outputStream));
    	smHandler.addPost(postID, postContent, postAuthor, postLikes, postShares, postDate);
    	
	    assertTrue(outputStream.toString()
	    	      .trim().contains("The post has been added to the collection!"));
	    		
	}


	@Test
	public void testRetrievePost() throws Exception {
        /* enter post id from the posts collection */
		postID = 10;
    	String returnedPost = smHandler.retrievePost(10);
    	Integer returnedPostID = Integer.parseInt(returnedPost.split(",")[0]);
    	System.out.print(returnedPost);
    	
    	assertTrue(returnedPostID == 10);

	}
	
	/* Test that in the case of the post ID is incorrect, the code throws exception */
	@Test
	public void testRetrievePostInputMismatchException() throws Exception {
	    Throwable exception = assertThrows(InputMismatchException.class, () -> smHandler.retrievePost(2999));
	    assertEquals("Invalid input post ID, please ensure you provide valid post ID!", exception.getMessage());
   		
	}
	@Test
	public void testRemovePost() throws Exception {
        System.setOut(new PrintStream(outputStream));
    	smHandler.removePost(postID);
    	
	    assertTrue(outputStream.toString()
	    	      .trim().contains("The post has been removed from the collection!"));
	    		
	}	

	@Test
	public void testRetrieveTopNLikedPosts() throws Exception {
    	HashMap<String, Integer> returneTopnLikedPosts = smHandler.retrieveTopNLikedPosts(topNPosts);
    	
	    assertTrue(returneTopnLikedPosts.size() == topNPosts);
	    		
	}	

	@Test
	public void testRetrieveTopNSharedPosts() throws Exception {
    	HashMap<String, Integer> returneTopnSharedPosts = smHandler.retrieveTopNLikedPosts(topNPosts);
    	
	    assertTrue(returneTopnSharedPosts.size() == topNPosts);
	    		
	}


}
