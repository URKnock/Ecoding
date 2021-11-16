package model.service.dto;

public class PostDTO {
	private int postId;
	private String title;
	private String postDate;
	private String postContent;
	private String postFile;
	private String views;
	private String likes;
	private String reports;
	private String ecoerId;
	private int communityId;
	
	public static String[] columns = { "post_id", "title", "post_date", "post_content", "post_file", "views", "likes", "reports", "ecoer_id", "community_id" };
	public static int cols = columns.length;
	
	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getPostId();
			case 1: return getTitle();
			case 2: return getPostDate();
			case 3: return getPostContent();
			case 4: return getPostFile();
			case 5: return getViews();
			case 6: return getLikes();
			case 7: return getReports();
			case 8: return getEcoerId();
			case 9: return getCommunityId();
		}
		return null;
	}
	
	public void setWithIndex(int index, Object data) {
		switch(index) {
			case 0: setPostId((int) data); break;
			case 1: setTitle((String) data); break;
			case 2: setPostDate((String) data); break;
			case 3: setPostContent((String) data); break;
			case 4: setPostFile((String) data); break;
			case 5: setViews((String) data); break;
			case 6: setLikes((String) data); break;
			case 7: setReports((String) data); break;
			case 8: setEcoerId((String) data); break;
			case 9: setCommunityId((int) data); break;
		}
	}
	
	public PostDTO() {
		
	}

	public PostDTO(int postId, String title, String postDate, String postContent, String postFile, String views,
			String likes, String reports, String ecoerId, int communityId) {
		this.postId = postId;
		this.title = title;
		this.postDate = postDate;
		this.postContent = postContent;
		this.postFile = postFile;
		this.views = views;
		this.likes = likes;
		this.reports = reports;
		this.ecoerId = ecoerId;
		this.communityId = communityId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostFile() {
		return postFile;
	}

	public void setPostFile(String postFile) {
		this.postFile = postFile;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}

	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
		this.ecoerId = ecoerId;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
}
