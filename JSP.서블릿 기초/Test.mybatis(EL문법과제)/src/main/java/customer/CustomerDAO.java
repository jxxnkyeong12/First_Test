package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
//①JDBC api(lib)사용 -> Connection초기화 , Steatment(전송)초기화, -> rs(결과) , int 결과!
	
	//현장에선 이 2개중에 뭘 쓸지 몰라
	
//②mybatis 는 위의것을 이용해서 관리나 가독성 등등의 장점을 추가한 API)
	//- 근데 이건 환경설정이 좀 까다로워(단점)
	//xml 파일로 환경설정, String sql x -> xml.mapper라는 쿼리의 집합 파일을 만들어서 관리! 훨씬 간편하게 사용할수 있ㅎ어
	//자바 파일이나 여러가지 방식으로 환경설정을 할 수가 있으나 제일 간단한 방법은 xml을 사용하는것(쌤 생각)
	
	
	//환경설정
	//1. maven에서 해당하는 api를 프로젝트에 넣어주기 (jar) pom.xml ■ 프로젝트에 JDB(ojdbc11)는 반드시 있어야함!■
	//2.mybatis 문서를 보고 dtd(xml)먼저 만들기 https://mybatis.org/mybatis-3/ko/getting-started.html

	
private static	SqlSession sql; //전송 결과 처리를 하는 객체 (sqlSessionFactory를 이용해서 초기화)
	static {  //제일먼저 실행되게 static걸어주기
		
		try {
			String resource = "mybatis/config.xml"; //mybatis dtd설정이 들어있는 파일(이 파일을 이용해서 환경설정을 로딩) 오타주의하자...ㅎ
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

  public void test() {// sql.selectOne("mapperNamesapce.sql(id)")
	  int result = sql.selectOne("test.selectTest"); //목록이 아니라 (데이터베이스 조회했을때 행갯수가 1개인것을 조회)
	  System.out.println(result);
  
  }
  public List<CustomerDTO> getList(){
	 //sql.update, sql.delete, sql.selecton (한건만 조회할때), selectList (리턴타입이 List 니까 그냥 list로 써주면 돼~)
	  List<CustomerDTO> list = sql.selectList("cus.listselect");
	  System.out.println(list.size());
	  return list;
  }//getList()

}//class
