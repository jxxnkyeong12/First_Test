import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.hanul.member.MemberDTO;

public class MemberCopyMain {
	//■Ex13과는 사뭇 다른...중요성.....■
	//member.txt 파일에서 라인단위로 내용을 읽어라. ▶ FileReader, BufferedReader, readLine()
	//라인단위의 각 항목은 TAB으로 구분되어 있다. ▶ split("\t");
	//MemberDTO 타입을 갖는 ArrayList<> 컬렉션 배열 구조를 만들자 ▶ ArrayList<MemberDTO> member;
	//member의 내용을 memberCopy02.txt 파일에 출력(저장시켜주자) ▶ FileWriter, BufferedWrite, flush(), close() 해줘
	
	public static void main(String[] args) {
		try {
			//파일 입력을 위한 준비단계
			String inputPath = "D:\\Study_Java\\workspace\\17.IO\\member.txt";  //1. 원본파일 위치 만들어짐 -'\\'역슬래시를 '/'슬래시로 써도 돼!
			FileReader fr = new FileReader(inputPath); //2.파일 입력 스트림
			BufferedReader br = new BufferedReader(fr); //3.입력 버퍼
			
			
			//열려진 파일의 내용을 읽어서 저장할 변수를 초기화 하고 
			
			
			//TAB으로 split()한 후, MemberDTO(com.hanul.member package) 객체 생성
			//ArrayList<MemberDTO> member 컬렉션 배열에 최종적으로 저장시켜주자
			String line = null;
			MemberDTO dto = null;
			ArrayList<MemberDTO> member = new ArrayList<MemberDTO>();
			while((line= br.readLine()) != null) { //while블록을 통해서 읽어 들일꺼야
				String[] sp =line.split("\t");
				int num = Integer.parseInt(sp[0]); //인덱스 0번지값 가져오라 햇는데 빨간줄 떠
				String name = sp[1];
				int age = Integer.parseInt(sp[2]);
				String addr = sp[3];
				String tel = sp[4];
				dto = new MemberDTO(num, name, age, addr, tel);
				member.add(dto);
			}//while
			
			//파일 출력을 위한 준비단계 거치고
			String outputPath = "D:\\Study_Java\\workspace\\17.IO/memberCopy02.txt"; //사복파일 위치
			FileWriter fw = new FileWriter(outputPath); //파일 출력 스트림
			BufferedWriter bw = new BufferedWriter(fw); //출력 버퍼
			
			//ArrayList<>의 저장된 내용을 파일에 출력!
			int index = 0;
			for (MemberDTO i : member) {  //보통 반복문에선 i를 써주니까~ i로 바꿔줘 걍
				if(index < member.size() -1 ) {  //줄바꿈 처리
					String result = i.getNum() + "\t" + i.getName() + "\t";
					result += i.getAge() + "\t" + i.getAddr() + "\t" + i.getTel() + "\n";// += : 이어 붙이겠다
					bw.write(result);
					bw.flush();
					index++; //-1이니까?
				}else { //마지막 라인 : 줄바꿈 처리를 하지 않는다
					String result = i.getNum() + "\t" + i.getName() + "\t";
					result += i.getAge() + "\t" + i.getAddr() + "\t" + i.getTel();
					bw.write(result);
					bw.flush();
				}//ir
			}//for
			
			
			//스트림 종료
			bw.close();
			fw.close();
			br.close();
			fr.close();
			System.out.println("memberCopy02.txt 파일이 생성되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main()
}//class
