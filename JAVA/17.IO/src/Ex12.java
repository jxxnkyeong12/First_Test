import java.io.BufferedReader;
import java.io.FileReader;

public class Ex12 {
	//버퍼를 활용하여 파일(member.txt)에서 문자 단위로 입출력하는 스트림 구현해보자 Ex11이 출력하면 한줄로 쭉 나와버렸거든. 그걸 다시 가로로 만들어 보려고 하는거야
	//FileReader ▶ BufferdeReader, FileWriter ▶ BufferedWriter
	//BufferedReader에서 readLine() 메소드를 활용하면 한 줄 단위로 입력된다.
	//member.txt파일에서 데이터를 읽어서 화면에 출력
	
	public static void main(String[] args) {
		try {  //1.
			FileReader fr = new FileReader("member.txt"); // 3.원본파일
			BufferedReader br = new BufferedReader(fr); //4. 입력버퍼 (한번 더 접근)
			
			String line = null; //5. 초기화 시켜주고
			int cnt = 0; //6.
			while((line = br.readLine()) != null) {  //7. null-> 더이상 읽을게 없다. 
				cnt++;  //8.
				System.out.println(line); //9.
			}
			
			br.close(); //10.
			System.out.println("접근횟수 : " + cnt);//11.
		} catch (Exception e) {
			e.printStackTrace(); //2.
		}
		
		
	}//main()
	
	
}//class
