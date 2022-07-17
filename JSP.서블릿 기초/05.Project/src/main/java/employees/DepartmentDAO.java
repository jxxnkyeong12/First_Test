package employees;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DepartmentDAO {
	
	private static SqlSession sql;
	static {
		
		String resource = "config/test.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql=	sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			System.out.println("sql연결에서 에러남!");
			e.printStackTrace();
		}//try
	}//static
	
	public List<DepartmentDTO> getList() {
		System.out.println("부서목록 지났어~");
		List<DepartmentDTO> list = sql.selectList("dept.deptlist");
		return list;
	}
	
	
	
	
}//class
