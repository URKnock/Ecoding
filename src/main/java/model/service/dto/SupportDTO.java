package model.service.dto;

public class SupportDTO {
	private int supportId;
	private String ecoerId;
	private int projectId;
	private int rewardId;
	private int amount;
	private String bank;
	private String card;
	
	public SupportDTO() {}
	
	public SupportDTO(String ecoerId, int projectId) {
		this.ecoerId = ecoerId;
		this.projectId = projectId;
	}
	
	public SupportDTO(int supportId, String ecoerId, int projectId, int rewardId, int amount, String bank, String card) {
		this.supportId = supportId;
		this.ecoerId = ecoerId;
		this.projectId = projectId;
		this.rewardId = rewardId;
		this.amount = amount;
		this.bank = bank;
		this.card = card;
	}
	
	public SupportDTO(String ecoerId, int projectId, int rewardId, int amount, String bank, String card) {
		super();
		this.ecoerId = ecoerId;
		this.projectId = projectId;
		this.rewardId = rewardId;
		this.amount = amount;
		this.bank = bank;
		this.card = card;
	}

	public int getSupportId() {
		return supportId;
	}

	public void setSupportId(int supportId) {
		this.supportId = supportId;
	}

	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
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
	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
}
