package model;

public class Reward {

	private int reward_id;
	private int project_id;
	private String rewardName;
	private int rewardPrice;
	private String rewardInfo;

	public Reward(String rewardName, int rewardPrice, String rewardInfo) {
		this.rewardName = rewardName;
		this.rewardPrice = rewardPrice;
		this.rewardInfo = rewardInfo;
	}
	
	public Reward(int project_id, String rewardName, int rewardPrice, String rewardInfo) {
		this.project_id = project_id;
		this.rewardName = rewardName;
		this.rewardPrice = rewardPrice;
		this.rewardInfo = rewardInfo;
	}

	public Reward(int reward_id, int project_id, String rewardName, int rewardPrice, String rewardInfo) {
		this.reward_id = reward_id;
		this.project_id = project_id;
		this.rewardName = rewardName;
		this.rewardPrice = rewardPrice;
		this.rewardInfo = rewardInfo;
	}

	public int getReward_id() {
		return reward_id;
	}

	public void setReward_id(int reward_id) {
		this.reward_id = reward_id;
	}
	
	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getrewardName() {
		return rewardName;
	}

	public void setrewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public int getrewardPrice() {
		return rewardPrice;
	}

	public void setrewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public String getrewardInfo() {
		return rewardInfo;
	}

	public void setrewardInfo(String rewardInfo) {
		this.rewardInfo = rewardInfo;
	}
}
