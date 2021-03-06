package model.service.dto;

import java.io.Serializable;

public class CreatorDTO extends EcoerDTO  implements Serializable {
	
	private String ecoerId, nickName, image, creatorInfo, account;
	public static String[] columns = { "ecoer_id", "nick_name", "image", "creator_info", "account" };
	public static int cols = columns.length;
	
	public CreatorDTO() {
		
	}

	public CreatorDTO(String nickName, String image) {
		super();
		this.nickName = nickName;
		this.image = image;
	}
	
	public CreatorDTO(String ecoerId, String nickName, String image, String creatorInfo, String account) {
		this.ecoerId = ecoerId;
		this.nickName = nickName;
		this.image = image;
		this.creatorInfo = creatorInfo;
		this.account = account;
	}


	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getEcoerId();
			case 1: return getNickName();
			case 2: return getImage();
			case 3: return getCreatorInfo();
			case 4: return getAccount();
			case 5: return getPassword();
			case 6: return getName();
			case 7: return getAddress();
			case 8: return getPhone();
			case 9: return getEmail();
			case 10: return getIsCreator();
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
		case 5:
			setPassword((String) data);
			break;
		case 6:
			setName((String) data);
			break;
		case 7:
			setAddress((String) data);
			break;
		case 8:
			setPhone((String) data);
			break;
		case 9:
			setEmail((String) data);
			break;
		case 10:
			setIsCreator((char) data);
			break;
		}
	}
	
	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
		this.ecoerId = ecoerId;
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