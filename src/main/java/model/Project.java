package model;

import java.util.Date;

public class Project {
		private int projectId; //PK ==> 필수
		private String ecoerId; //FK ==> 필수
		private String title; // ==> 필수
		private String image; //이미지 경로
		private String simpleInfo; //간단 설명

		private String category;
		private String hashTag;
		private String ecoTag;
		private double ecoScore; //NUMBER(10, 9)

		private int targetPrice; // ==> 필수
		private int currentPrice; //자동 생성 
		
		private Date startDate; //자동 생성
		private Date endDate; // ==> 필수
		private Date paymentDate; // ==> 필수
		private Date deliveryDate; // ==> 필수
		
		private String detailInfo; // ==> 필수
		private String planInfo; // ==> 필수
		private String exchangeInfo; 
		
		private String projectVideo; //영상 경로
		private String projectFile; //인증 정보 및 기타서류의 경로 
		
		public static String[] columns = 
		{"project_id", "ecoer_id",
		 "title", "image", "simple_info",
		 "category", "hashtag", "ecotag",
		 "eco_score", "target_price", "current_price",
		 "start_date", "end_date", "payment_date", "delivery_date",
		 "detail_info", "plan_info", "exchange_info",
		 "project_video", "project_file"
		}; //DB에 정의된 컬럼들의 명칭으로 할 것 (총 20개)
		public static int cols = columns.length;
		
		public Project() {
			
		}
		
		public Project(String title, String simpleInfo, String category, String hashTag, String ecoTag,
				int targetPrice, Date startDate, Date endDate, Date paymentDate, Date deliveryDate,
				String detailInfo, String planInfo, String exchangeInfo) {
			this.title = title;
			this.simpleInfo = simpleInfo;
			this.category = category;
			this.hashTag = hashTag;
			this.ecoTag = ecoTag;
			this.targetPrice = targetPrice;
			this.startDate = startDate;
			this.endDate = endDate;
			this.paymentDate = paymentDate;
			this.deliveryDate = deliveryDate;
			this.detailInfo = detailInfo;
			this.planInfo = planInfo;
			this.exchangeInfo = exchangeInfo;
		}

		public Project(int projectId, String ecoerId, String title, String image, String simpleInfo,
				String category, String hashTag, String ecoTag, double ecoScore, int targetPrice, int currentPrice,
				Date startDate, Date endDate, Date paymentDate, Date deliveryDate, String detailInfo,
				String planInfo, String exchangeInfo, String projectVideo, String projectFile) {
			super();
			this.projectId = projectId;
			this.ecoerId = ecoerId;
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

		public Object getWithIndex(int index) {
			switch(index) {
			case 0: return getProjectId();
			case 1: return getEcoerId();
			case 2: return getTitle();
			case 3: return getImage();
			case 4: return getSimpleInfo();
			case 5: return getCategory();
			case 6: return getHashTag();
			case 7: return getEcoTag();
			case 8: return getEcoScore();
			case 9: return getTargetPrice();
			case 10: return getCurrentPrice();
			case 11: return getStartDate();
			case 12: return getEndDate();
			case 13: return getPaymentDate();
			case 14: return getDeliveryDate();
			case 15: return getDetailInfo();
			case 16: return getPlanInfo();
			case 17: return getExchangeInfo();
			case 18: return getProjectVideo();
			case 19: return getProjectFile();
			}
			return null;
		}
		
		public void setWithIndex(int index, Object data) {
			switch(index) {
			case 0:
				setProjectId((int)data);
				break;
			case 1:
				setEcoerId((String)data);
				break;
			case 2:
				setTitle((String)data);
				break;
			case 3:
				setImage((String)data);
				break;
			case 4:
				setSimpleInfo((String)data);
				break;
			case 5:
				setCategory((String)data);
				break;
			case 6:
				setHashTag((String)data);
				break;
			case 7:
				setEcoTag((String)data);
				break;
			case 8:
				setEcoScore((double)data);
				break;
			case 9:
				setTargetPrice((int)data);
				break;
			case 10:
				setCurrentPrice((int)data);
				break;
			case 11:
				setStartDate((Date)data);
				break;
			case 12:
				setEndDate((Date)data);
				break;
			case 13:
				setPaymentDate((Date)data);
				break;
			case 14:
				setDeliveryDate((Date)data);
				break;
			case 15:
				setDetailInfo((String)data);
				break;
			case 16:
				setPlanInfo((String)data);
				break;
			case 17:
				setExchangeInfo((String)data);
				break;
			case 18:
				setProjectVideo((String)data);
				break;
			case 19:
				setProjectFile((String)data);
				break;
			}
		}

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public String getEcoerId() {
			return ecoerId;
		}

		public void setEcoerId(String ecoerId) {
			this.ecoerId = ecoerId;
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

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getHashTag() {
			return hashTag;
		}

		public void setHashTag(String hashTag) {
			this.hashTag = hashTag;
		}

		public String getEcoTag() {
			return ecoTag;
		}

		public void setEcoTag(String ecoTag) {
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

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}

		public Date getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(Date deliveryDate) {
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
