package empdept;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import common.CommonDAO;


public class EmpDAO {

	public static	SqlSession sql;   
	static {   //제일먼저 실행되게 하는거
		String resource = "mybatis/configD.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true); //AutoCommit 설정을 true로 줌
		} catch (IOException e) {
			System.out.println("mybat오류!");
			e.printStackTrace();
		}
		
	}

	
	public List<EmpDTO> getList() {
		List<EmpDTO> list = sql.selectList("ed.edlist");
		System.out.println(list.size());  
		System.out.println("사원 거치나");
		return list;
	}//
	
}//class
