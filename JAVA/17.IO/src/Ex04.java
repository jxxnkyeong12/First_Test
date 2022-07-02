import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex04 {
	//▶키보드에서 한글 1글자를 입력받아 출력하세요
	public static void main(String[] args) {
		InputStream is	= System.in;			//1.바이트 단위 입력 스트림 : 아스키코드, 그림, 영상, 음원 등
		InputStreamReader isr = new InputStreamReader(is); //2. 문자 단위 입력 스트림 : 한글, 한자 텍스트, 유니코드 등 - is라고 읽을꺼야~	
		//InputStreamReader isr = new InputStreamReader(System.in); //3. 근데 결국 (is)가 system.in이랑 같은거여서 연쇄시킬수 있어
		
		System.out.print("한글 1글자를 입력하세요 : ");//4.
		try {
			int data = isr.read();//6.
			System.out.println("입력하신 글자는 " + data + "입니다.");//7.  유니코드값
			System.out.println("입력하신 글자는 " +  (char)data + "입니다."); //8.
		} catch (Exception e) {
			e.printStackTrace();//5.
		}//try
		
		
	}//main()
}//class
