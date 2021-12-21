package model.service.dto;

import java.util.Date;

public class ProjectNoticeDTO {
	
	private int noticeId;
	private int projectId;
	private Date noticeDate;
	private String noticeContent;
	
	public ProjectNoticeDTO() {}
	
	public ProjectNoticeDTO(int projectId, String noticeContent) {
		this.projectId = projectId;
		this.noticeContent = noticeContent;
	}

	public ProjectNoticeDTO(int noticeId, Date noticeDate, String noticeContent) {
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
