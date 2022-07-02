import java.util.ArrayList;

import com.hanul.member.MemberDAO;
import com.hanul.member.MemberDTO;

public class MemberMain {
		public static void main(String[] args) {
			
			//Collection 자료구조. -무한배열이 아니라 컬렉션! 
		//■회원정보(이름, 나이, 주소, 전화번호 ▶ MemberDTO.java)를 ArrayList<> 컬렉션 배열에 저장하시오. 
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));   //클래스 타입 - 객체화 ->객체 생성
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		list.add(new MemberDTO("나길동", 25, "광주시 북구 용봉동", "010-3333-3333"));
					
		//Element == 요소 == 대문자로 시작하는것
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("ad");
		strList.add(new String("ad"));
		
		
		
		//■회원정보 출력 : display() ▶ MemberDAO.java : com.hanul.member package
		MemberDAO dao = new MemberDAO(list);
		dao.display();
		
		
		//■회원 나이의 오름차순으로 정렬 후 출력하시오 : ageAscSort()
		dao.ageAscSort();
		dao.display();
		
		//■회원 나이의 오름차순으로 정렬 후 출력하시오 : ageAscSort()
		dao.nameDescSort();
		dao.display();
	}//main(
}//class
