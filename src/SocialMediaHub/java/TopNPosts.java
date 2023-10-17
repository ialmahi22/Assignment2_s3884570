package SocialMediaHub.java;

public class TopNPosts {
	public String postContent;
	public int numberOfInteractions;

    public TopNPosts(String postContent, int numberOfInteractionsr) {
        this.postContent = postContent;
        this.numberOfInteractions = numberOfInteractions;

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
