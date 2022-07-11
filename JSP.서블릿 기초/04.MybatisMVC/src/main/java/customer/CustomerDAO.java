package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	//JDBC api(lib) 사용 -> Connection초기화, Statement(전송) 초기화 쿼리 넣기 - > 전송 -> ResultSet(결과), int(결과)
	
	
	// Mybatis ↑ (이용, 관리, 가독성 등등의 장점을 추가한 API)
	//환경설정이 좀 까다롭다는 단점이 있음
	//■ xml 파일로 환경설정, String sql x = > xml mapper라는 쿼리의 집합 파일을 만들어서 관리 ■
	// 자바 파일이나 여러가지 방식으로 환경설정을 할수가 있으나 제일 간단한 방법은 xml 을 이용하는거야(쌤 생각)
	
	
	//환경 설정
	//1. maven에서 해당하는 api를 프로젝트를 넣어주기(jar파일 자동으로 땡겨와) - pom.xml
	//■ 프로젝트에 JDBC(ojbc11)는 반드시 있어야함 ■
	//2. mybatis 문서를 보고 dtd(xml) 먼저 만들기  https://mybatis.org/mybatis-3/ko/getting-started.html
	
	
	
	private static SqlSession sql; // 전공 결과 처리를 하는 객체 (sql세션 팩토리 이용해서 초기화)
	static {
		try {
			String resource = "mybatis/config.xml";  // 위치 다시 좋게 넣어줘  mybatis dtd 설정이 들어있는 파일(이파일을 이용해서 환결설정을 로딩)
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sql =sqlSessionFactory.openSession(); //Connection객체 이용해서 통신열기랑 같은 처리 소문자 s!!!!
		} catch (IOException e) {
			System.out.println("mybatis 패키지 오류났어");
			e.printStackTrace();
		}
		
	}
	
	
	public void test() {   //sql.selectOne("mapperNamespace.sql(id)")
		int result = sql.selectOne("test.selectTest");//목록이 아니라( 데이터베이스를 조회했을때 row(행) 갯수가 1개인것만 조회!)
		System.out.println(result);
	}
	
	
	public List<CustomerDTO> getList() {
		//sql.update, sql.delete, sql.selectone, seclectlist( return타입이 List)
		List<CustomerDTO> list = sql.selectList("cus.listselect");
	//	System.out.println(list.size());
	
		//list.add(new DTo ) 하면 새고할때마다 수가 늘어남.... 그리고 이제 이거 쓸일 거의 없다함 ㅎㅎㅎ
	
		
		return list;
	}


	public int insert(CustomerDTO dto) {
		//sql맵퍼에 파라메터(사용할변수들)를 보내는 방법 (하나만 넘길수있음) ex)String <-1, HashMap<-1, ArrayList<-1개로 인식해
		int result = sql.insert("cus.insert",dto); //int나 string을 보낼때 이걸로
		//sql.insert(null, dto) 오브젝트타입
		sql.commit(); //Mybatis는 Auto Commit 속성이 기본적으로 false임
	return result;
	
	}
	
	public int update(CustomerDTO dto) {
		int result = sql.update("cus.update",dto);
		return result;
	}//update
	
}//class
