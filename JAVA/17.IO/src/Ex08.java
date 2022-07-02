import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08 {
	//키보드에서 문자열을 여러번 입력받아 출력
	//버퍼를 활용 : InputStream -> InputStreamReader -> BufferedReader
	//단, 'bye' 문자열이 입력되면 종료 되도록하는거야
 public static void main(String[] args) {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //1.★★ 제일 중요!!★★
	  try {   //2.
		while(true) {
			System.out.print("문자열을 입력하세요 : ");//4.
			String msg = br.readLine(); //5.
			
			//■
//			if(msg == "bye") {  //7. //10.문자열은 비교연산자를 사용할 수 없다.
//				System.out.println("종료되었습니다.");//8.
//				break;//9. ■근데 여기까지만 하고 cmd창에서 확인해보면 문자라서 동작이 아예 안돼 ㅎ...문자는 비교연산이 안돼잖아...
//			}//if
			
//			if(msg.compareTo("bye") == 0) {  //11. 문자열 비교 연산! 같은 값 돌릴땐 0으로 해라
//				System.out.println("종료되었습니다.");
//				break;
//			}
			
			
			//■
			//12. 다른 방법 하나 더! equals! 같냐 같지 않냐
//			if(msg.equals("bye")) { //13.근데 이러면 only 소문자 bye만 써야 종료가 되니까
//				System.out.println("종료되었습니다.");
//				break;
//			}
			
			
			//■
			//13. ex_string03.참고 대소문자 상관없이 bye 입력하면 끝내버리기
			if(msg.equalsIgnoreCase("bye")) {
				System.out.println("종료되었습니다.");
				break;
			}//if
			
			System.out.println("입력하신 문자열은 " + msg + "입니다.");//6.
		}//while 
		  
		
		
		  
	} catch (Exception e) {
		e.printStackTrace();//3.
	}//try
	 
	 
 	}//main()
}//class
