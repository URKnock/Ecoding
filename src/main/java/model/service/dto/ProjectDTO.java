package model.service.dto;

//import java.time.LocalDate;
import java.util.Date;

public class ProjectDTO {
	private int projectId;
	private String title;
	private String image;
	private String creatorImage;
	private String creatorName;
	private String creatorEmail;
	private int pricePercent;
	private long remainTime;
	private int countSupporter;
	private Date paymentDate;
	private String simpleInfo;
	
	public ProjectDTO(int projectId, String title, String image,
			String creatorImage, String creatorName, Date paymentDate) {
		this.projectId = projectId;
		this.title = title;
		this.creatorImage = image;
		this.creatorImage = creatorImage;
		this.creatorName = creatorName;
		this.paymentDate = paymentDate;
	}
	
	public ProjectDTO(int projectId, String title, String image,
			String creatorImage, String creatorName, String creatorEmail,
			int pricePercent, long remainTime, int countSupporter) {
		this.projectId = projectId;
		this.title = title;
		this.image = image;
		this.creatorImage = creatorImage;
		this.creatorName = creatorName;
		this.creatorEmail = creatorEmail;
		this.pricePercent = pricePercent;
		this.remainTime = remainTime;
		this.countSupporter = countSupporter;
	}
	
	public ProjectDTO(int projectId, String title, String image, String simpleInfo, int pricePercent) {
		this.projectId = projectId;
		this.title = title;
		this.image = image;
		this.simpleInfo = simpleInfo;
		this.pricePercent = pricePercent;
	}
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatorImage() {
		return creatorImage;
	}
	public void setCreatorImage(String creatorImage) {
		this.creatorImage = creatorImage;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getCreatorEmail() {
		return creatorEmail;
	}
	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	public int getPricePercent() {
		return pricePercent;
	}
	public void setPricePercent(int pricePercent) {
		this.pricePercent = pricePercent;
	}
	public long getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(long remainTime) {
		this.remainTime = remainTime;
	}
	public int getCountSupporter() {
		return countSupporter;
	}
	public void setCountSupporter(int countSupporter) {
		this.countSupporter = countSupporter;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getSimpleInfo() {
		return simpleInfo;
	}
	public void setSimpleInfo(String simpleInfo) {
		this.simpleInfo = simpleInfo;
	}

}
