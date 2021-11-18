package model;

public class Reward {

	private int reward_id;
	private int project_id;
	private String name;
	private int reward_price;
	private String reward_info;
	

	public Reward(String name, int reward_price) {
		super();
		this.name = name;
		this.reward_price = reward_price;
	}

	public Reward(int reward_id, int project_id, String name, int reward_price, String reward_info) {
		this.reward_id = reward_id;
		this.project_id = project_id;
		this.name = name;
		this.reward_price = reward_price;
		this.reward_info = reward_info;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReward_price() {
		return reward_price;
	}

	public void setReward_price(int reward_price) {
		this.reward_price = reward_price;
	}

	public String getReward_info() {
		return reward_info;
	}

	public void setReward_info(String reward_info) {
		this.reward_info = reward_info;
	}
}
