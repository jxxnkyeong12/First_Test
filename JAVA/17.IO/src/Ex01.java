import java.io.IOException;
import java.io.InputStream;

public class Ex01 {
	//1.키보드에서 영문자 1글자를 입력받아 출력하세요 - scanner의 기능은 잠시 잊어버려라
	public static void main(String[] args) {
		InputStream is = System.in;  //2.입력하면 inputStream is가 받는다.
									 //3.노드 스트림 : 가장 먼저 연결되는 스트림
		System.out.print("영문자 1글자를 입력하세요 : ");//4.int타입으로 받아달라고 안내메시지가 떠
														//5. 근데 빨간줄 떠 - try catch블록해줘	
		try {
			int data = is.read();
			System.out.println("입력하신 영문자는 " + data + "입니다."); //6.출력값 : A를 입력하면 '65'아스키코드 값으로 나와버려 (int니까!) 8.엔터값도 생각해줘야해~
			System.out.println("입력하신 영문자는 " + (char)data + "입니다."); //7. Casting - int타입을 char타입으로 바꿔버린다! 출력값 : A
		} catch (IOException e) {
			
			e.printStackTrace();   //예외를 메모리에서 추적하여 상세하게 출력
		}  //try
		
		
		
	}//main()
}//class
