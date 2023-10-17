package SocialMediaHub.java.SocialMediaPosts;
import java.time.LocalDateTime;
import org.junit.*;

public class SocialMediaTest {
	
	private int postID = 100;
	private String postContent = "This junit test post content";
	private String postAuthor = "This junit test post content";
	private int postLikes = 255;
	private int postShares = 255;
	private LocalDateTime postDate = LocalDateTime.now();
	
	socialMedia smPost  = new socialMedia();

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
		 testPost=null;
	 }	
	
	@Test
	public void testAddPost() {
		
		// add a new post attributes
		int testpostID = 444;
		String testpostContent = "From insite the test method";
		String testpostAuthor = "ABC235jhjkkkkl";
		int testpostLikes = 500;
		int testpostShares = 300;
		LocalDateTime testpostDate  = LocalDateTime.now();

		String expectedTestPost = "(" + testpostID + ",'" + testpostContent + "','" + testpostAuthor + "','" + testpostLikes + "','" + testpostShares + "', '" + testpostDate + "')";
		// add the post via the socialMedia class, although the same post content has been used 
		Post formattedTestPost = new Post(testpostID, testpostContent, testpostAuthor, testpostLikes, testpostShares, testpostDate);

		smPost.addPost(formattedTestPost);

		String addedTestPost = formattedTestPost.getPostInfo();

		// verify the post is added successfully
		Assert.assertEquals(expectedTestPost, addedTestPost);
		Assert.assertEquals(1, smPost.getAllPosts().size());

	}

	@Test
	public void testRemovePost() {
		// add the post via the socialMedia class, although the same post content has been used 
		Post formattedTestPost = new Post(postID, postContent, postAuthor, postLikes, postShares, postDate);
		// Add the post first 
		smPost.addPost(formattedTestPost);

        // remove the post
		smPost.removePost(formattedTestPost);
		
		// verify the post is deleted successfully, arraylist size should be zero
		Assert.assertEquals(0, smPost.getAllPosts().size());
	}	

}
