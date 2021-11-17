package model.service.dto;

public class CommunityDTO {
	private int communityId;
	private String name;
	
	public CommunityDTO() {
	}

	public CommunityDTO(int communityId, String name) {
		this.communityId = communityId;
		this.name = name;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
