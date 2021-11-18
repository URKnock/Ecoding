package model.service.dto;

public class ProjectNoticeDTO {
	
	// project_id는 DTO에서 제외
	
	private int noticeId;
	private String noticeDate;
	private String noticeContent;
	
	public ProjectNoticeDTO(int noticeId, String noticeDate, String noticeContent) {
		this.noticeId = noticeId;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
	}
	
	public int getNoticeId() {
		return noticeId;
	}
	
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
