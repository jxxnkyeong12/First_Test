package hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class HrDAO implements HrService { //쿼리문 실행~!

	@Autowired @Qualifier("hr") private SqlSession sql;  //이것때문에 오류 뜰거야
	
	@Override
	public int employee_insert(EmployeeVO vo) {
		return 0;
	}

	@Override
	public List<EmployeeVO> employee_list() {
		return sql.selectList("hr.list");
	}

	@Override
	public EmployeeVO employee_detail(int employee_id) {
		return sql.selectOne("hr.detail", employee_id); //조건절에 사용할 사원정보 파라메터로 보내기 위해 employee_id
	}

	@Override
	public int employee_update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int employee_delete(int employee_id) {
		return sql.delete("hr.delete", employee_id);
	}

	@Override
	public List<DepartmentVO> employee_department_list() {
		return sql.selectList("hr.employee_department_list");
	}

	@Override
	public List<EmployeeVO> employee_list(int department_id) {
		return sql.selectList("hr.department_employee_list", department_id);
	}

	@Override
	public List<DepartmentVO> department_list() {
		return sql.selectList("hr.department_list");
	}

}
