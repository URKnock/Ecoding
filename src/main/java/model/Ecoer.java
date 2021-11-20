package model;

public class Ecoer {

	private String ecoerId, name, address, phone, email, password;
	private String isCreator;
	
	public static String[] columns = { "ecoer_id", "password", "name", "address", "phone", "email", "is_creator" };
	public static int cols = columns.length;
	
	public Ecoer() {
		
	}
	
	public Ecoer(String ecoerId, String name, String address, String phone, String email, String password, String isCreator) {
		this.ecoerId = ecoerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.isCreator = isCreator;
	}
	
	public Object getWithIndex(int index) {
		switch(index) {
			case 0: return getEcoerId();
			case 1: return getPassword();
			case 2: return getName();
			case 3: return getAddress();
			case 4: return getPhone();
			case 5: return getEmail();
			case 6: return getIsCreator();
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
			setAddress((String) data);
			break;
		case 4:
			setPhone((String) data);
			break;
		case 5:
			setEmail((String) data);
			break;
		case 6:
			setIsCreator((String) data);
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

	public String getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(String isCreator) {
		//this.isCreator = (isCreator == '1');
		this.isCreator = isCreator;
	}

	@Override
	public String toString() {
		return "Ecoer [ecoerId=" + ecoerId + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", password=" + password + ", isCreator=" + isCreator + "]";
	}

}
