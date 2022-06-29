import java.util.ArrayList;

import com.hanul.member.MemberDTO;

public class ForEachMain03 {
	public static void main(String[] args) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		list.add(new MemberDTO("나길동", 25, "광주시 북구 용봉동", "010-3333-3333"));
		
		//■ArrayList<> 값을 출력 : 교환전
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}
		/*홍길동	27	광주시 서구 농성동	010-1111-1111
		김길동	29	광주시 남구 봉선동	010-2222-2222
		나길동	25	광주시 북구 용봉동	010-3333-3333
		======================================================*/
		System.out.println("======================================================");

		
		//■swap : 교환 -> 임시변수(temp), 수정(set())
		//list.get(0); //홍길동 데이터를 가져온단 소리야
		MemberDTO temp = list.get(0);
		list.set(0, list.get(1));  //1번지 값으로 바꿔주세요
		list.set(1, temp); //1번지 값에 temp값을 주겠슴다
		
		//ArrayList<> 값을 출력 : 교환 후
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}
		
		/*김길동	29	광주시 남구 봉선동	010-2222-2222
		홍길동	27	광주시 서구 농성동	010-1111-1111
		나길동	25	광주시 북구 용봉동	010-3333-3333*/

	}//main()
	
}//class
