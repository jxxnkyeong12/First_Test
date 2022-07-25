package mybaticSaone;

public class MybaticDTO {

	private int employee_id, did;
	private String name, email, phone, dname, addr,
						  max_sal, min_sal, avg_sal;
	
	//getter setter
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMax_sal() {
		return max_sal;
	}
	public void setMax_sal(String max_sal) {
		this.max_sal = max_sal;
	}
	public String getMin_sal() {
		return min_sal;
	}
	public void setMin_sal(String min_sal) {
		this.min_sal = min_sal;
	}
	public String getAvg_sal() {
		return avg_sal;
	}
	public void setAvg_sal(String avg_sal) {
		this.avg_sal = avg_sal;
	}
	
	
	
	
}//class
