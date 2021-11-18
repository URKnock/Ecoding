package model.service.dto;

public class RewardDTO {

	// project_id 제외
	
	private int rewardId;
	private String name;
	private int rewardPrice;
	private String rewardInfo;
	
	public RewardDTO(int rewardId, String name, int rewardPrice, String rewardInfo) {
		this.rewardId = rewardId;
		this.name = name;
		this.rewardPrice = rewardPrice;
		this.rewardInfo = rewardInfo;
	}

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRewardPrice() {
		return rewardPrice;
	}

	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public String getRewardInfo() {
		return rewardInfo;
	}

	public void setRewardInfo(String rewardInfo) {
		this.rewardInfo = rewardInfo;
	}
	
}
