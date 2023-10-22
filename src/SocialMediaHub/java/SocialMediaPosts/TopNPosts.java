/*

 * TopnNPosts class:
 * This class is used to provide setters and getters for social media posts content and number of interactions (like or shares)
 * It's utilised by the javafx controllers in the methods to retrieve the top N shared or liked posts, its required to 
 * set the setCellValueFactory values for the tables used to display the results
 * 
 * Version: v1.0
 *
 * Date: 20 Oct 2023
 * 
 * Copyright to RMIT, Oct 2023
 */

package SocialMediaHub.java.SocialMediaPosts;

public class TopNPosts {
	public String postContent;
	public int numberOfInteractions;

    public TopNPosts(String postContent, int numberOfInteractionsr) {
        this.postContent = postContent;
    }


	public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getNumberOfInteractions() {
        return numberOfInteractions;
    }

    public void setNumberOfInteractions(int numberOfInteractions) {
        this.numberOfInteractions = numberOfInteractions;
    }

}
