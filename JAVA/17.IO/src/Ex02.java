import java.io.InputStream;

public class Ex02 {
	//1.키보드에서 영문자 1글자를 입력받아 출력하세요 - scanner의 기능은 잠시 잊어버려라
	public static void main(String[] args) {
		InputStream is	= System.in;  //2.바이트 단위(기반)로 입력하는 기본 스트림이다!
		System.out.print("영문자 1글자를 입력하세요 : ");
		try {
			int data = is.read();
			System.out.println(data);		//3.출력 : 65 - 아스키코드로 나옴
			System.out.println((char)data); //출력 : A Casting해줘
			
			data = is.read();				//4.Enter : CR(Carriage Return)
			System.out.println(data);		//출력 : 13
			System.out.println((char)data); //(char)data 빈공백으로 1개 + println 으로 줄바꿈 1개 해서 밑에 공백 2줄이 나와
			System.out.println("=============================");
			
			
			data = is.read();				//5.Enter : LF(Line Feed)
			System.out.println(data);		//출력 : 10 아스키코드
			System.out.println((char)data); //Line Feed 1개 + (char)data 빈공백으로 1개 + println 으로 줄바꿈 1개 해서 밑에 공백 3줄이 나와
			
		} catch (Exception e) {  //3.모든 예외를 처리
			e.printStackTrace(); //4.발생했던 예외를 상세하게 출력해주세요
		}
		
		
	}//main()
}//class


/*
 - 사용자가 문자를 입력  → Enter입력
 - Enter를 입력하는 것은 프로그램의 종료(Terminate, Ctrl + C)가 아니다. 
 - CR(Carriage Return) : 커서를 줄의 맨앞으로 이동
 - LF(Line Feed) : 커서를 한 줄 아래로 이동 시켜준다
  
  
  
 */ 
