package model.service.dto;

public class ReplyDTO {
	private int replyId;
	private String replyDate;
	private String replyContent;
	private int postId;
	private String ecoerId;
	
	public ReplyDTO() {

	}

	public ReplyDTO(int replyId, String replyDate, String replyContent, int postId, String ecoerId) {
		this.replyId = replyId;
		this.replyDate = replyDate;
		this.replyContent = replyContent;
		this.postId = postId;
		this.ecoerId = ecoerId;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
		this.ecoerId = ecoerId;
	}
}
