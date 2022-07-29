package hr;

import java.util.List;

public interface HrService {  
	
	
	
	 //사원목록 등록 - 신규저장
	int employee_insert(EmployeeVO vo);
	
	//사원목록조회(여러명 이니까 list)
	List<EmployeeVO> employee_list();
	//특정부서에 속한 사원목록조회(여러명 이니까 list)
	List<EmployeeVO> employee_list(int department_id);
	
	//추가! 부서목록조회( 사원들의 있는 부서목록 )
	List<DepartmentVO> employee_department_list();
	//추가! 부서목록조회( 회사의 전체 부서목록 )
	List<DepartmentVO> department_list();
	
	//사원상세조회
	EmployeeVO employee_detail(int employee_id);
	
	//사원정보변경저장
	int employee_update(EmployeeVO vo);
	
	//사원정보삭제
	int employee_delete(int employee_id);
	
}//class
