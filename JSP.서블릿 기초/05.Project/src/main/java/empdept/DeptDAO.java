package empdept;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeptDAO {

public static	SqlSession sql;     //상속받을수있게 public으로 바꿔주기
	
	static {   //제일먼저 실행되게 하는거
		String resource = "mybatis/configD.xml"; //■여기 유의하자 ■
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true); //AutoCommit 설정을 true로 줌
		} catch (IOException e) {
			System.out.println("mybatis오류!");
			e.printStackTrace();
		}
		
	}
	
	public List<DeptDTO> getList() {
		
	List<DeptDTO>list= sql.selectList("dept.deptlist");
		System.out.println(list.size());
		return list;
	}//
	
	
}//class
