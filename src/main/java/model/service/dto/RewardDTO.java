package model.service.dto;

public class RewardDTO {

	private int rewardId;
	private int project_id;
	private String name;
	private int rewardPrice;
	private String rewardInfo;
	
	public RewardDTO(int rewardId, int project_id, String name, int rewardPrice, String rewardInfo) {
		this.rewardId = rewardId;
		this.project_id = project_id;
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

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
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
