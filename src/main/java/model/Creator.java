package model;

public class Creator extends Ecoer {
	
	private String ecoderId, nickName, image, creatorInfo, account;
	public static String[] columns = { "ecoer_id", "name", "image", "creator_info", "account" };
	public static int cols = columns.length;
	
	public Creator() {
		
	}

	public Creator(String ecoderId, String nickName, String image, String creatorInfo, String account) {
		this.ecoderId = ecoderId;
		this.nickName = nickName;
		this.image = image;
		this.creatorInfo = creatorInfo;
		this.account = account;
	}

	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getEcoerId();
			case 1: return getName();
			case 2: return getImage();
			case 3: return getCreatorInfo();
			case 4: return getAccount();
		}
		return null;
	}
	
	public void setWithIndex(int index, Object data) {
		switch(index) {
		case 0:
			setEcoerId((String) data);
			break;
		case 1:
			setName((String) data);
			break;
		case 2:
			setImage((String) data);
			break;
		case 3:
			setCreatorInfo((String) data);
			break;
		case 4:
			setAccount((String) data);
			break;
		}
	}
	
	public String getEcoderId() {
		return ecoderId;
	}

	public void setEcoderId(String ecoderId) {
		this.ecoderId = ecoderId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreatorInfo() {
		return creatorInfo;
	}

	public void setCreatorInfo(String creatorInfo) {
		this.creatorInfo = creatorInfo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}