package member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	//쿼리문실행기능을 가진 클래스 : SqlSessionTemplate
	public static SqlSession sql;
	static {
		String resource = "mybatis/config.xml";
		try {
			SqlSessionFactory factory =
					new SqlSessionFactoryBuilder().
						build( Resources.getResourceAsStream(resource));
			sql = factory.openSession(true); //autocommit 설정 : true 이거 설정안해주니까 sql에 회원가입정보가 저장이 안되서..! 꼭 해주기
		} catch (IOException e) {
			System.out.println("연결이 안됐어!");
			e.printStackTrace();
		}
	}
	
	//CRUD(Create, Read, Update, Delete)
	//회원가입
  public int member_join(MemberDTO dto) {
	  return sql.insert("member.join", dto);
  }//memeber_join()
	
  //내정보보기 
  public MemberDTO member_myinfo(String userid) {
	  
	  return null;
  }
  //아이디 중복 확인
  public int member_id_check(String userid) {
	  return sql.selectOne("member.id_check", userid);
	  //여기서 오류 났던 이유! "member.id_check " 뒤에 띄어쓰기때문에...ㅎ 이름이 다르다고 인식해서 안되는거였다 ㅠ따흐흑
  } 
  
  
  //로그인하기
  public MemberDTO member_login(String id, String pw) {
		HashMap<String, String> map
				=	new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		return sql.selectOne("member.login", map); //로그인은 나 하나잖아 그러니까 1명을 조회해오는거야!
	}
 //아이디에 해당하는 salt조회해오기
  public String member_salt(String id) {
	  return sql.selectOne("member.salt", id);
  }
	  

  
  //내정보변경
  
  public int member_update(MemberDTO dto) {
	  
	  return 0;
  }
  
  //회원탈퇴 (조건절이 필요해)
  public int member_delete(String userid) {
	  
	  return 0;
  }
  
  //전체회원정보 조회
  public List<MemberDTO> member_list() {  //회원 여러명-List<MemberDTO>
	  return sql.selectList("member.list"); //찾아갈태그
  }
  
  //salt처리 안되있던 비번들 변경해주기
  public void member_pw_encrypt(MemberDTO dto) { //반환되는 타입은 int 야. 근데 지금은 임시라서 void!
	   sql.update("member.pw_encrypt", dto); //dto 보내줄 정보 담아주기
  }
  
}//class
