package mybaticSaone;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaticDAO {
 
	private static SqlSession sql;
	//제일먼저 실행되게 static걸어주기
	static {
		try {
			String resource = "mybatis/configMybat.xml"; //mybatis dtd설정이 들어있는 파일(이 파일을 이용해서 환경설정을 로딩) 오타주의하자...ㅎ
			//InputStream inputStream;
			InputStream	inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  //아래에 있던거 여기 안으로 같이 넣어주기!
			//session -연결 통로는 열고 ! connection객체 역할을 한다고 보면 돼 설정에 의해!
			sql = sqlSessionFactory.openSession();//Connection객체 이용해서 통신열기랑 같은 처리!
			//sql= 열린 세션을 받아온다!
		
		} catch (IOException e) {
			System.out.println("mybaits 설정파일 오류!");
			e.printStackTrace();
		}
	}
	
	
	public List<MybaticDTO> getList() {
		List<MybaticDTO> list = sql.selectList("myb.mybselect");   
		//Mapped Statements collection does not contain value for myb/mybselect
		//접근은 /이게 아니라 .이다..
		
		System.out.println(list.size());
		System.out.println("getList MyDTO잘 거쳤니?");
		return list;
	}//
}//class
