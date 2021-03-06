package model.service.dto;

public class InterestProjectDTO {
	private String ecoerId;
	private int projectId;
	private boolean isInterest;
	
	public static String[] columns = { "ecoer_id", "project_id" };
	public static int cols = columns.length;
	
	public InterestProjectDTO() {
		
	}

	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getEcoerId();
			case 1: return getProjectId();
		}
		return null;
	}
	
	public void setWithIndex(int index, Object data) {
		switch(index) {
		case 0:
			setEcoerId((String) data);
			break;
		case 1:
			setProjectId((int) data);
			break;
		}
	}
	
	public InterestProjectDTO(String ecoerId, int projectId) {
		this.ecoerId = ecoerId;
		this.projectId = projectId;
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

	public boolean isInterest() {
		return isInterest;
	}

	public void setInterest(boolean isInterest) {
		this.isInterest = isInterest;
	}
	

}
