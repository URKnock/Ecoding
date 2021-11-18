package model;

public class ProjectNotice {

	private int noticeId;
	private int projectId;
	private String noticeDate;
	private String noticeContent;
	
	public ProjectNotice(int noticeId, int projectId, String noticeDate, String noticeContent) {
		this.noticeId = noticeId;
		this.projectId = projectId;
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
