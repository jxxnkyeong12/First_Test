import java.io.InputStream;

public class Ex03 {
	//1.키보드에서 영문자 여러 글자를 입력받아 출력하시오.
	public static void main(String[] args) {
		InputStream is = System.in;
		System.out.print("영문자 여러 글자를 입력하세요 : ");
		try {   //2. 예외가 발생하니까 try catch구문을 만들어줘
//			while(true) { //4.입력받은 글자가 몇 글자인지 알 수 없다.  그래서 while문 돌려버리기!
//				int data = is.read(); //5.
//				System.out.println("입력하신 영문자는 " + (char)data + "입니다."); //6.
//				
//				if(data == -1) {  //7.Ctrl +C (입력이 -1로 받아 -> 강제종료) 했을때 break명령을 통해 종료 시키자
//					System.out.println("종료되었습니다.");
//					break;  //8.
//				}//if
//			}//while 9. 주석처리해보기
			
			int data;//10.코드가 더 간결해지는 방법 시작!
			while((data =is.read()) != -1) { //11.읽어드린 다음에 data에 넣을거야 근데 -1(Ctrl+C)누를때까지 계속 돌릴거야!
				System.out.println("입력하신 영문자는 " + (char)data + "입니다.");//12.
			}//while
				System.out.println("종료되었습니다.");//13. 더 코드가 간결해진다
		} catch (Exception e) {
			e.printStackTrace();  //3.
		}
		
		
	}//main()
}//class
