package mybsaone;

public class MybsaoneDTO {
	/*
	 * e.EMPLOYEE_ID 사번, e.FIRST_NAME || ' ' || LAST_NAME 이름, e.EMAIL 이메일,
	 * d.department_id, e.PHONE_NUMBER 휴대전화, d.DEPARTMENT_NAME 부서명, c.COUNTRY_NAME
	 * || ' ' || STATE_PROVINCE || ' ' || CITY || ' '||STREET_ADDRESS || ' '
	 * ||POSTAL_CODE 전체주소
	 SELECT MAX(salary) 부서최대급여, min(salary) 부서최소급여, ROUND( avg(salary),2) 부서평균급여, department_id 
                              FROM employees e GROUP BY department_id) sal
	 */
	
//	private int employee_id, department_id,salary ;
//	private String first_name, last_name, email, phone_number, department_name, country_name, state_province, city, street_address, postal_code;
//	
	
//	private int 사번, 부서, 부서최대급여, 부서최소급여, 부서평균급여;
//	private String 이름, 이메일, 휴대전화, 부서명, 전체주소;
	
	
	private int employee_id, did;
	private String name, email, phone, dname, addr, max_sal, min_sal, avg_sal;

	//int였던 애들은String으로 잠깐 내려놓음 
	
	//getter setter
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
