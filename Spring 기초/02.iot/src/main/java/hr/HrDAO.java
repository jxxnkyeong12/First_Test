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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int employee_update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int employee_delete(int employee_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
