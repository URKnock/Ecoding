package model;

public class Support {
	
	private int supportId; //PK ==> 필수
	private int ecoersId; //FK ==> 필수
	private int projectId; //FK ==> 필수 
	private int rewardId; //FK ==> 필수
	private int amount; //결제 총액 ==> 필수
	private String card; //카드 정보 ==> 필수
	
	public Support(int supportId, int ecoersId, int projectId, int rewardId, int amount, String card) {
		super();
		this.supportId = supportId;
		this.ecoersId = ecoersId;
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

	public int getEcoersId() {
		return ecoersId;
	}

	public void setEcoersId(int ecoersId) {
		this.ecoersId = ecoersId;
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
