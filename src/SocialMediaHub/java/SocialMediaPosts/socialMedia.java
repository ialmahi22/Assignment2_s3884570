package SocialMediaHub.java.SocialMediaPosts;
import java.util.ArrayList;

public class socialMedia {
  private ArrayList < Post > posts;
  private ArrayList < Post.getPostID > postIDs;


  public socialMedia() {
	  posts = new ArrayList < Post > ();
	  postIDs = new ArrayList < Post.getPostID > ();
  }

  public void addPost(Post post) {
	  posts.add(post);
  }

  public void removePost(Post post) {
	  posts.remove(post);
  }
  
  public ArrayList<Post> getAllPosts() {
	  return posts;
  }  
  
  public ArrayList <Post.getPostID> getPostIDs() {
	  return postIDs;
  }
  
  public ArrayList < Post > getPosts() {
    return posts;
  }

}