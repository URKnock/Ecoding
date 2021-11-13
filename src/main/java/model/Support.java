package model;

public class Support {
	
	private int supportId; //PK ==> 필수
	private int ecoerId; //FK ==> 필수
	private int projectId; //FK ==> 필수 
	private int rewardId; //FK ==> 필수
	private int amount; //결제 총액 ==> 필수
	private String card; //카드 정보 ==> 필수
	
	public Support(int supportId, int ecoerId, int projectId, int rewardId, int amount, String card) {
		super();
		this.supportId = supportId;
		this.ecoerId = ecoerId;
		this.projectId = projectId;
		this.rewardId = rewardId;
		this.amount = amount;
		this.card = card;
	}

	public int getSupportId() {
		return supportId;
	}

	public void setSupportId(int supportId) {
		this.supportId = supportId;
	}

	public int getEcoerId() {
		return ecoerId;
	}

	public void setEcoersId(int ecoerId) {
		this.ecoerId = ecoerId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
}
