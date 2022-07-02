import java.io.FileReader;

public class Ex11 {
	//파일(텍스트문서, 유니코드)에서 문자 단위로 입출력하는 스트림
	//FileReader, FileWriter
	//한글이 포함된 파일(member.txt)에서 데이터를 읽어서 일단 화면에 출력해보자
	//member.txt 파일 생성 : IO Project > 마오 > New > File : member.txt
	//내용 작성 시 항목간의 구분은 반드시 정해져 있는 약속된 기호로 써야해! TAB 키를 활용한다.
	
	
	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("member.txt");   //2.원본파일
			int data, cnt = 0;
			while((data = fr.read()) != -1) {
				cnt++;
				
				System.out.println((char)data); // char타입으로 캐스팅 시켜줘! 안그럼 숫자로만 된 출력물이 보일것이다
												//tab한 곳은 8칸 보이는데 그냥 띄어쓰기는 1칸만 나와!
			}//while
			fr.close();
			System.out.println("접근횟수 : " +cnt);
		} catch (Exception e) {
			e.printStackTrace(); //1.예외처리하기
		}
		
	}//main()
}//class
