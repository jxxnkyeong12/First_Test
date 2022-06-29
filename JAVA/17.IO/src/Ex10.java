import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex10 {
	//버퍼를 이용한 이미지 파일을 복사 : 입출력의 속도 향상
	//FileInputStream → BufferedInputStream
	//FileOutputStream → BufferedOutputStream
	//버퍼의 기본크기 : 1024Byte
	//마지막 버퍼에는 기본 크기보다 작은 용량이 버퍼에 남아 있다.
	//따라서 마지막 버퍼에 남아 있는 내용을 반드시 강제전송(flush())하고 종료(close())까지 해줘야 해!
	public static void main(String[] args) {
		try {
			String inputPath = "D:\\Study_Java\\workspace\\17.IO\\pic.jpg";		////원본파일의 경로 (역슬래시 알아서 2개가 떠~)
			String outputPath = "D:\\Study_Java\\workspace\\17.IO\\copy02.jpg";	//사본 파일의 경로
			
			FileInputStream fis = new FileInputStream(inputPath);		//원본파일을 읽는다
			FileOutputStream fos = new FileOutputStream(outputPath);	//사본파일을 생성
			
			BufferedInputStream bis = new BufferedInputStream(fis);		//입력버퍼 생성
			BufferedOutputStream bos = new BufferedOutputStream(fos);	//출력버퍼 생성
			
			int data, cnt = 0;
			while((data = bis.read()) != -1) {
				cnt++;
				System.out.println(data);
				bos.write(data);
			}
			
			bos.flush(); // 마지막 버퍼에 남아 있는 내용을 강제 전송(flush)하는 메소드야
			bos.close(); //이것도 맨 마지막 단계얌
			bis.close(); //이것도 마지막에 똑같이 해줘!!
			
			fos.close();
			fis.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main()
}//class
