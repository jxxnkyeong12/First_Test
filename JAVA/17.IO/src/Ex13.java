import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex13 {
	//member.txt 파일에서 라인단위로 내용을 읽어서 ▶ 버퍼를 활용 : BufferedReader(readLine())
	//memberCopy01.txt 파일에 출력(저장)= 파일로 만들어라 ▶ BufferedWriter(출력하기 위해선 이게 필요해) -> flush() : 마지막 버퍼를 강제 전송하자
	//파일 복사 해라 : member.txt -> memberCopy01.txt  
	
	public static void main(String[] args) {
		
		try {
			//파일 입력을 위한 준비단계 : FileReader, BufferedReader
			String inputPath = "D:\\Study_Java\\workspace\\17.IO\\member.txt";  //1. 원본파일 위치 만들어짐 -'\\'역슬래시를 '/'슬래시로 써도 돼!
			FileReader fr = new FileReader(inputPath); //2.파일 입력 스트림
			BufferedReader br = new BufferedReader(fr); //3.입력 버퍼
			
			//파일 출력을 위한 준비단계 : FileWriter, BufferedWirter
			String outputPath = "D:\\Study_Java\\workspace\\17.IO/memberCopy01.txt"; //사복파일 위치
			FileWriter fw = new FileWriter(outputPath); //파일 출력 스트림
			BufferedWriter bw = new BufferedWriter(fw); //출력 버퍼
			
			
			//열려진 파일의 내용을 읽어 들이자 (readLine()) 저장할 변수를 초기화 시켜놓자
			String line = null; //클래스 타입을 초기화 하고 싶을땐 null주면 돼!
			
			
			//파일의 내용을 읽고 파일에 출력(저장)하는 로직
			while((line =br.readLine()) != null) { //br.readLine 호출하고() - line 변수 할당하고 - line 변수안에 하나로 묶어주고 null이 아니라면
				bw.write(line); //출력은 write가 담당하니까 
				bw.newLine(); //이거 안해주면 copy에 한줄로 나와버려 (readLine이 Enter앞까지만 인식해서) 
							  //bw.write("\n") 줄바꿈
			}
			
			//마지막 버퍼의 내용을 강제전송(flush())후 스트림 종료(close())
			bw.flush();
			bw.close();
			fw.close();
			
			br.close();
			fr.close();
			System.out.println("memberCopy01.txt 파일이 생성되었습니다.");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}//main()
}//class
