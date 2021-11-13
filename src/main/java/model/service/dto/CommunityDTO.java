package model.service.dto;

public class CommunityDTO {
	private String communityId;
	private String name;
	
	public CommunityDTO() {
		super();
	}

	public CommunityDTO(String communityId, String name) {
		super();
		this.communityId = communityId;
		this.name = name;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
