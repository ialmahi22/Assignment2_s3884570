package SocialMediaHub.java.SocialMediaPosts;
import java.time.LocalDateTime;

public class Post {
	private int postID;
	private String postContent;
	private String postAuthor;
	private int postLikes;
	private int postShares;
//    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:MM");  
//	private String postDate;
	
	
	private LocalDateTime postDate;
	

  public Post(int postID, String postContent, String postAuthor, int postLikes, int postShares, LocalDateTime postDate) {
    this.postID = postID;
    this.postContent = postContent;
    this.postAuthor = postAuthor;
    this.postLikes = postLikes;   
    this.postShares = postShares;    
    this.postDate = postDate;
  }

  public void setPostID(int id) {
	  this.postID = id;
	  }

  public void setPostContent(String content) {
	  this.postContent = content;
	  }

  public void setPostAuthor(String author) {
	  this.postAuthor = author;
	  }

  public void setPostLikes(int likes) {
	  this.postLikes = likes;
	  }

  public void setPostShares(int shares) {
	  this.postShares = shares;
	  }

  public void setPostDate(LocalDateTime date) {
	  this.postDate = date;
	  }
  
  public interface getPostID {

	}  
  
  public int getPostShares() {
    return postShares;
  }

  public int getPostLikes() {
	    return postLikes;
	  }
  
  public String getPostContent() {
	    return postContent;
	  }
  
  public int getPostID() {
	    return postID;
	  }

  public String getPostInfo() {
	  return "(" + postID + ",'" + postContent + "','" + postAuthor + "','" + postLikes + "','" + postShares + "', '" + postDate + "')"; 
    //return "Post ID: " + postID + ", Post Content: " + postContent + ", Post Author: " + postAuthor + ", Post Likes: " + postLikes + ", Post Shares: " + postShares + ", Post Date: " + postDate;
  }
}