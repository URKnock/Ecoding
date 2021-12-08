package model.service.dto;

public class EcoerDTO {

	private String ecoerId, password, name, code, address, detailAddress, phone, email;
	private boolean isCreator;
	private ReactDTO react;
	
	public static String[] columns = { "ecoer_id", "password", "name", "code", "address", "detail_address", "phone", "email", "is_creator" };
	public static int cols = columns.length;
	
	public EcoerDTO() {
	}
	
	public EcoerDTO(String ecoerId, String password, String name, String code, String address, String detailAddress,
			String phone, String email, boolean isCreator) {
		super();
		this.ecoerId = ecoerId;
		this.password = password;
		this.name = name;
		this.code = code;
		this.address = address;
		this.detailAddress = detailAddress;
		this.phone = phone;
		this.email = email;
		this.isCreator = isCreator;
	}

	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getEcoerId();
			case 1: return getPassword();
			case 2: return getName();
			case 3: return getCode();
			case 4: return getAddress();
			case 5: return getDetailAddress();
			case 6: return getPhone();
			case 7: return getEmail();
			case 8: return getIsCreator();
		}
		return null;
	}
	
	public void setWithIndex(int index, Object data) {
		switch(index) {
		case 0:
			setEcoerId((String) data);
			break;
		case 1:
			setPassword((String) data);
			break;
		case 2:
			setName((String) data);
			break;
		case 3:
			setCode(String.valueOf(data));
			break;
		case 4:
			setAddress((String) data);
			break;
		case 5:
			setDetailAddress((String) data);
			break;
		case 6:
			setPhone((String) data);
			break;
		case 7:
			setEmail((String) data);
			break;
		case 8:
			setIsCreator(((String)data).charAt(0));
			break;
		}
	}
			
	public String getEcoerId() {
		return ecoerId;
	}

	public void setEcoerId(String ecoerId) {
		this.ecoerId = ecoerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(char isCreator) {
		this.isCreator = (isCreator == '1');
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDetailAddress() {
		return detailAddress;
	}
	
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public void setCreator(boolean isCreator) {
		this.isCreator = isCreator;
	}

	public ReactDTO getReact() {
		return react;
	}

	public void setReact(ReactDTO react) {
		this.react = react;
	}

	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	@Override
	public String toString() {
		return "Ecoer [ecoerId=" + ecoerId + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", password=" + password + ", isCreator=" + isCreator + "]";
	}

}
