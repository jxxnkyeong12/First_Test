package hr;

import java.util.List;

public interface HrService {  
	
	
	
	 //사원목록 등록 - 신규저장
	int employee_insert(EmployeeVO vo);
	
	//사원목록조회(여러명 이니까 list)
	List<EmployeeVO> employee_list();
	
	//사원상세조회
	EmployeeVO employee_detail(int employee_id);
	
	//사원정보변경저장
	int employee_update(EmployeeVO vo);
	
	//사원정보삭제
	int employee_delete(int employee_id);
	
}//class
