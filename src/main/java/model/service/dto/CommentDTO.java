package model.service.dto;

public class CommentDTO {
	private String commentId;
	private String commentDate;
	private String commentContent;
	private String postId;
	private String ecoerId;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(String commentId, String commentDate, String commentContent, String postId, String ecoerId) {
		super();
		this.commentId = commentId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
		this.postId = postId;
		this.ecoerId = ecoerId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
		this.ecoerId = ecoerId;
	}
}
