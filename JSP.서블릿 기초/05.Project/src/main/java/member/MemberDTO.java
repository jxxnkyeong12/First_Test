package member;

public class MemberDTO {
/*	userid   varchar2(50) constraint memberTest_userid_pk primary key,   --회원 아이디
	 name     varchar2(50) not null, -- 회원명
	 userpw   varchar2 (300) not null, -- 비밀번호는 일단 크게 지정
	 gender   varchar2 (3) default '여' not null,  -- 성별 : 남 또는 여 에 해당하는! 3byte (default는 contstrain적용 전에 해야 한다)
	 email    varchar2(50) not null, -- 이메일
	 birth    date , -- 생년월일 ! 공지사항의 날짜와는 성격이 달라서 디폴트 지정 x!
	 phone    varchar2(13), -- '-(하이픈)' 를 쓰면 최대 13, 빼면 최대 11자리까지 들어가
	 address   varchar2(300), -- 주소도 적절히 크게 주면 돼!
	 admin 
	 post 테이블 변경으로 추가했다! - 다음날에 
	*/
	private String userid, name, userpw, gender, email, birth, phone, address, post;

	
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	//getter setter
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
	
	
}//class
