import java.io.InputStreamReader;

public class Ex05 {
	//키보드에서 한글 여러 글자를 입력받아 출력하시오.
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in); //1.
		System.out.print("한글 여러 글자를 입력하세요 : "); //2.
		try {	//3.
			int data;
			while((data =isr.read()) !=-1) { //5. if문과 같애~ 코드 짧게 하니까 좋지! '-1' => 강제종료하기 전까지는 계속 돌릴꺼다
				System.out.println("입력하신 글자는 " + (char)data + "입니다.");
			}//while
				System.out.println("종료되었습니다."); //6.
		} catch (Exception e) { 
			e.printStackTrace(); //4.
		}
		
		
	}//main()
}//class
