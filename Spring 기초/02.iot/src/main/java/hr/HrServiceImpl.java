package hr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class HrServiceImpl implements HrService {

	@Autowired private HrDAO dao ; //필드선언
	
	
	@Override
	public int employee_insert(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeVO> employee_list() {
		return dao.employee_list();
	}

	@Override
	public EmployeeVO employee_detail(int employee_id) {
		return dao.employee_detail(employee_id);
	}

	@Override
	public int employee_update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int employee_delete(int employee_id) {
		return dao.employee_delete(employee_id);
	}

	@Override
	public List<DepartmentVO> employee_department_list() {
		return dao.employee_department_list(); //dao에 있는 메소드 호출
	}

	@Override
	public List<EmployeeVO> employee_list(int department_id) {
		return dao.employee_list(department_id);
	}

	@Override
	public List<DepartmentVO> department_list() {
		return dao.department_list();
	}

}
