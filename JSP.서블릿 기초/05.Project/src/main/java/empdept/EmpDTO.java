package empdept;

public class EmpDTO { //DTO라고 쓰고 있지만 웹에서는 이걸 VO(Value Object 라고 해)
	//--EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER, DEPARTMENT_ID
	//EMAIL
	private int employee_id, department_id;
	private String name,  phone, email;
	
	
	//getter setter
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
	
}//class
