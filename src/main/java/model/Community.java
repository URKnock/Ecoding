package model;

public class Community {
	private String communityId;
	private String name;
	
	public Community() {
		super();
	}

	public Community(String communityId, String name) {
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
