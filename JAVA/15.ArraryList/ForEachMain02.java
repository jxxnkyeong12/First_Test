import java.util.ArrayList;
import java.util.Iterator;

import com.hanul.member.MemberDTO;

public class ForEachMain02 {
	public static void main(String[] args) {
		//회원정보(이름, 나이, 주소, 전화번호 ▶ MemberDTO.java)를 ArrayList<> 컬렉션 배열에 저장하시오.
		//name, age, addr, tel
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		list.add(new MemberDTO("나길동", 25, "광주시 북구 용봉동", "010-3333-3333"));
		
		//ArrayList<>의 내용을 출력하시오 : 단순 for문
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() + "\t"); 
			System.out.print(list.get(i).getAge() + "\t");
			System.out.print(list.get(i).getAddr() + "\t");
			System.out.print(list.get(i).getTel() + "\n");
		}//for
		
		System.out.println("======================================================");
		
		//ArrayList<> 의 내용을 출력하시오 : 단순 for문
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i); //dto로 접근할수 있게 처리했다! list get i번지 값을 dto로 받겠다!
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		System.out.println("======================================================");
		
		//ArrayList<>의 내용을 출력하시오 : 향상된 for문
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
			
		}
	}//main()
}//class
