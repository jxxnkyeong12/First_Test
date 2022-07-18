package member;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	//■쿼리문실행기능을 가진 클래스 : SqlSessionTemplate-> SqlSession의 인터페이스를 구현하고 있어
	public static SqlSession sql;
	static { //static 초기화!
		String resource = "config/config.xml";
		try {
			Resources.getResourceAsStream(resource);  //resource를 stream의 형태로 읽어들인다
			SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
										//객체생성, sqlfactoryBulider에 build를 통해 만들어 내는데 만들어낼 정보가 Resources.getResourceAsStream(resource)얘야
			sql =factory.openSession(true); //auto commit! 
		} catch (IOException e) {
			System.out.println("연결오류!");
			e.printStackTrace();
		}//try
	}//static
	
	
	
	//CRUD(Create, Read, Update, Delete) 생성 조회 변경 삭제 처리를 CRUD 라고 한다! 
	//회원가입 - Create -> insert into 하면 1행이 삽입되었습니다! 가 뜨잖아. 그니까 반환하는 데이터는 숫자데이터!
	public int member_join(MemberDTO dto) {
		
		return sql.insert("member.join", dto); //어떤 태그를 통해서 어떤값(dto)을 저장할 것인지 파라메터로 지정;
	}
	
	//내정보보기 - Read -> select 
	public MemberDTO member_myinfo(String userid) {
		//조회한다는건 어디에다가 써먹으려고 하는거! 데이터를 조회해서 알려줘야 하는 데이터는 내 정보 전체!(MemberDTO)
		
		return null;
	}
	//아이디 중복 확인
	public int member_id_check(String userid) {//아이디가 있는지 없는지 판단해야 하니까 파라메터로 아이디값을 받아와야한다
		return sql.selectOne("member.id_ckeck", userid); //어떤 태그를 통해서, 조건절에 사용할 id에 해당하는 데이터를 파라메터로 넘겨줘야 한다.
	}
//	--아이디가 admin인 회원의 존재여부 확인 
//	select userid from memberTest where userid='admin'; --이렇게 쓰면 문자열과null이 반환돼
//	select count(userid) from memberTest where userid='admin'; --근데 count를 쓰면 0아니면 1이 무조건 반환! 

	
	
	//내정보 변경 - Update 
    public int member_update(MemberDTO dto) { //회원정보가 이미 나와있어. 화면에서 입력한 값을 받아온 데이터 객체가 필요해(MemberDTO dto)
    
    	return 0;
    }
    
    //회원탈퇴 - Delete -1행이 삭제되었습니다
    public int member_delete(String userid) { //누구의 정보를 삭제할것인지 조건절이 필요해, 그런 아이디를 갖는 회원의 정보를 삭제하는거!-파라메터로 userid가 필요하다
    	
    	return 0;
    }
    
    
    
}//class
