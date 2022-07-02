
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex14 {
	//기본 데이터 타입(PDT), 문자열(String)을 byte 형으로 변환하여 입출력
	//DataInputStream, DataOutputStream ▶ 암호화 한 것처럼 표현하는 스트림
	//사용자가 입력한 내용을 파일로 저장 : 변수 초기화 ▶ 파일 출력(FileOutputStream) ▶ byte 타입으로 변환을 (DataOutputStream) 이라 말해
	//파일에 저장된 내용을 읽어서 화면에 출력하고 싶다 : FileInputStream ▶ DataInputStream이 필요 ▶ 변수에 할당한 후 ▶ 화면에 출력
	public static void main(String[] args) {
		try {
			int num1 = 12345;
			double num2 = 3.14;
			String str1 = "apple";
			String str2 = "홍길동";
			
			FileOutputStream fos = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(num1);  	// int 타입이 -> byte로 바뀐거야
			dos.writeDouble(num2);  // double 타입이 -> byte으로 바뀐거
			dos.writeUTF(str1);	    //String 타입이 ->byte 타입으로 변해  (String타입은 writeUTF로 해줘)
			dos.writeUTF(str2);	    //String 타입이 ->byte 타입으로 변해  (String타입은 writeUTF로 해줘)
			
			dos.close();
			fos.close();
			System.out.println("data.txt 파일이 생성 되었습니다");
			
			FileInputStream fis = new FileInputStream("data.txt");
			DataInputStream dis = new DataInputStream(fis);
			int num3 =dis.readInt();  // byte 코드가 ▶ 원래 만들었던 int 로 바뀐다
			double num4 = dis.readDouble(); //byte ->double
			String str3 = dis.readUTF();   //byte -> String
			String str4 = dis.readUTF();
			dis.close();
			fis.close();
			
			System.out.println(num3);
			System.out.println(num4);
			System.out.println(str3);
			System.out.println(str4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//main()

}//class
