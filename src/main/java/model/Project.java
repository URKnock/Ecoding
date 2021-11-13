package model;

import java.time.LocalDate;

public class Project {

	//컬럼 전체 추가, null 가능 필드 표시
		private int projectId; //PK ==> 필수
		private int creatorId; //FK ==> 필수
		private int rewardId; //FK ==> 필수
		private String title; // ==> 필수
		private String image; //이미지 경로
		private String simpleInfo; //간단 설명

		private String[] category;
		private String[] hashTag;
		private String[] ecoTag;
		private double ecoScore; //NUMBER(10, 9)

		private int targetPrice; // ==> 필수
		private int currentPrice; //자동 생성 
		
		private LocalDate startDate; //자동 생성
		private LocalDate endDate; // ==> 필수
		private LocalDate paymentDate; // ==> 필수
		private LocalDate deliveryDate; // ==> 필수
		
		private String detailInfo; // ==> 필수
		private String planInfo; // ==> 필수
		private String exchangeInfo; 
		
		private String projectVideo; //영상 경로
		private String projectFile; //인증 정보 및 기타서류의 경로 
		
		public Project(int projectId, int creatorId, int rewardId, String title, String image, String simpleInfo,
				String[] category, String[] hashTag, String[] ecoTag, double ecoScore, int targetPrice, int currentPrice,
				LocalDate startDate, LocalDate endDate, LocalDate paymentDate, LocalDate deliveryDate, String detailInfo,
				String planInfo, String exchangeInfo, String projectVideo, String projectFile) {
			super();
			this.projectId = projectId;
			this.creatorId = creatorId;
			this.rewardId = rewardId;
			this.title = title;
			this.image = image;
			this.simpleInfo = simpleInfo;
			this.category = category;
			this.hashTag = hashTag;
			this.ecoTag = ecoTag;
			this.ecoScore = ecoScore;
			this.targetPrice = targetPrice;
			this.currentPrice = currentPrice;
			this.startDate = startDate;
			this.endDate = endDate;
			this.paymentDate = paymentDate;
			this.deliveryDate = deliveryDate;
			this.detailInfo = detailInfo;
			this.planInfo = planInfo;
			this.exchangeInfo = exchangeInfo;
			this.projectVideo = projectVideo;
			this.projectFile = projectFile;
		}

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public int getCreatorId() {
			return creatorId;
		}

		public void setCreatorId(int creatorId) {
			this.creatorId = creatorId;
		}

		public int getRewardId() {
			return rewardId;
		}

		public void setRewardId(int rewardId) {
			this.rewardId = rewardId;
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

		public String getSimpleInfo() {
			return simpleInfo;
		}

		public void setSimpleInfo(String simpleInfo) {
			this.simpleInfo = simpleInfo;
		}

		public String[] getCategory() {
			return category;
		}

		public void setCategory(String[] category) {
			this.category = category;
		}

		public String[] getHashTag() {
			return hashTag;
		}

		public void setHashTag(String[] hashTag) {
			this.hashTag = hashTag;
		}

		public String[] getEcoTag() {
			return ecoTag;
		}

		public void setEcoTag(String[] ecoTag) {
			this.ecoTag = ecoTag;
		}

		public double getEcoScore() {
			return ecoScore;
		}

		public void setEcoScore(double ecoScore) {
			this.ecoScore = ecoScore;
		}

		public int getTargetPrice() {
			return targetPrice;
		}

		public void setTargetPrice(int targetPrice) {
			this.targetPrice = targetPrice;
		}

		public int getCurrentPrice() {
			return currentPrice;
		}

		public void setCurrentPrice(int currentPrice) {
			this.currentPrice = currentPrice;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public LocalDate getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}

		public LocalDate getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(LocalDate deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public String getDetailInfo() {
			return detailInfo;
		}

		public void setDetailInfo(String detailInfo) {
			this.detailInfo = detailInfo;
		}

		public String getPlanInfo() {
			return planInfo;
		}

		public void setPlanInfo(String planInfo) {
			this.planInfo = planInfo;
		}

		public String getExchangeInfo() {
			return exchangeInfo;
		}

		public void setExchangeInfo(String exchangeInfo) {
			this.exchangeInfo = exchangeInfo;
		}

		public String getProjectVideo() {
			return projectVideo;
		}

		public void setProjectVideo(String projectVideo) {
			this.projectVideo = projectVideo;
		}

		public String getProjectFile() {
			return projectFile;
		}

		public void setProjectFile(String projectFile) {
			this.projectFile = projectFile;
		}
}
