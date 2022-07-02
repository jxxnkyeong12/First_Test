import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex09 {
	//파일(그림, 영상, 음원)에서 바이트 단위(InputStream)로 입출력하는 스트림
	//FileInputStream,FileOutputStream - in의 반대가 out이니까 ! but 문서 타입은 안돼! 
	//그림 파일을 읽어서 출력하는 프로그램 : Copy & Paste
	//원본이미지 준비 : 이미지를 현재 프로젝트(IO Project)에 다운로드 ->pic.jpg
	//경로설정(위치, 주소)을 하지 않으면 무조건 현재 프로젝트에서 작업이 이루어진다.
	//경로설정(위치, 주소)을 할 경우에는 절대경로로 표기해줘라.
	//▶ D:\\Study_Java\\workspace\\17.IO\\pic.jpg    '\'이걸 '\\'입력해줘!(지금은 주석처리해서 1번 나오는거지 원래는 2번 나와~그리고 안되면 /이걸로 다시 바꿔줘야해)
	//최종적으로 동작이 완료되면 프로젝트를 새로고침(프로젝트 > 마오 > Refresh하거나 단축키 F5)
	
	public static void main(String[] args) {
		
		
		try {
			
			FileInputStream fis = new FileInputStream("pic.jpg");//1.try캐취 문 안에 안넣으면 이게 딱 이 프로젝트 안에서만 찾아서 작동이 안돼. 그래서 여기 넣어주는거야
			FileOutputStream fos = new FileOutputStream("copy01.jpg"); // 2.사본파일이 되는거야!
			
			int data, cnt =0;    //3.
			while((data =fis.read()) != -1) {   //4. -1: 실패, 종료, End Of File -fis.read 를 읽어들이고 그걸 data에 넣고 -1하지 않으면 돌려돌려~
				cnt++; // 5. 접근횟수 (파일의 크기와 같아)
				System.out.println(data);  //이미지의 픽셀값(RGB 코드값)
				fos.write(data); //6. data 값이 int 니까 int 찾아서 넣어줘! - data값을 기준으로 파일을 출력
			}//while
			
			fos.close();
			fis.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main()
}//class
