package testtable;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestTableDAO {

private static	SqlSession sql;  //sqlSession이다! 팩토리 아니야!
	static {
		
		String resource = "testconfig/test.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
			sql =sqlSessionFactory.openSession(true); //AutoCommit 설정을 true로 줌
			//commit 연결했던 것을 sql에 담아서 이제 내가 쓸거야!
		} catch (IOException e) {
			System.out.println("연결오류!");
			e.printStackTrace();
		}//try
		
	}//static
	
	
	public int testList() {
		return sql.selectOne("test.testselect");//한건 조회는 selectOne!
	}//test
	
}//class
