package model.service.dto;

import java.time.LocalDate;

public class ProjectDTO {
	private int projectId;
	private String title;
	private String image;
	private String creatorImage;
	private String creatorName;
	private int pricePercenet;
	private long remainTime;
	private int countSupporter;
	private LocalDate paymentDate;
	
	public ProjectDTO() {
		super();
	}

	/*
	public ProjectDTO(int projectId, String title) {
		super();
		this.projectId = projectId;
		this.title = title;
	}

	public ProjectDTO(int projectId, String title, String image,
			String creatorImage, String creatorName, LocalDate paymentDate) {
		this.projectId = projectId;
		this.title = title;
		this.creatorImage = image;
		this.creatorImage = creatorImage;
		this.creatorName = creatorName;
		this.paymentDate = paymentDate;
	}
	
	*/
	public ProjectDTO(int projectId, String title,
			String image, String creatorImage, String creatorName,
			int pricePercenet, long remainTime, int countSupporter) {
		this.projectId = projectId;
		this.title = title;
		this.image = image;
		this.creatorImage = creatorImage;
		this.creatorName = creatorName;
		this.pricePercenet = pricePercenet;
		this.remainTime = remainTime;
		this.countSupporter = countSupporter;
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
	public int getPricePercenet() {
		return pricePercenet;
	}
	public void setPricePercenet(int pricePercenet) {
		this.pricePercenet = pricePercenet;
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
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
