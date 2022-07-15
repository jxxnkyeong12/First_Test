package member;

public class MemberDTO {
//	userid, name, userpw, gender, email, birth, phone, address, admin
	private String userid,name, userpw, gender, email, salt, salt_pw
				 , birth, phone, address, admin, post;

	public String getPost() {
		return post;
	}



	
	public String getSalt() {
		return salt;
	}




	public void setSalt(String salt) {
		this.salt = salt;
	}




	public String getSalt_pw() {
		return salt_pw;
	}

	public void setSalt_pw(String salt_pw) {
		this.salt_pw = salt_pw;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
	
}//class
