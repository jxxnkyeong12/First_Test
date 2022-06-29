import java.io.InputStreamReader;

public class Ex06 {
	//키보드에서 여러 문자를 입력받아 출력하시오.
	//▶단, 입력한 글자중에 'q'라는 문자가 입력되면 종료하시오. (Ctrl+C가 아닌 q가 입력되면 종료되게 해보자)
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in); //문자 단위 입력 스트림
		System.out.print("여러 문자를 입력하세요 : ");  
		try {
			int data ;
			while((data = isr.read()) != 'q') {// q라는 문자가 입력될때까지 돌릴것이다!
				System.out.println("입력하신 문자는 " + (char)data + "입니다."); //그래서 출력물 보면 전에는 입니다.신문자는 입력하진 어쩌고- 말 이상하게 나왔는데
																				// q에서 딱 끝나버리니까 그런 이상하게 쓰여진 글들 안나오고 깔끔하게 종료되었습니다! 가 나와
			}//while
			System.out.println("종료되었습니다."); 
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		
	}//main()
}//class
