
public class MyThread01Main {
	public static void main(String[] args) {
		//1.일반적인 객체생성
		MyThread01 thread01 = new MyThread01();
		MyThread02 thread02 = new MyThread02();  //2.c마크 안에 세모가 있는건- 별도의 .java가 존재하지 않는.
												 //다른 .java클래스 안에 있단 소리야. 중첩클래스형태다!
		
		//4.run() 메소드 호출
		//thread01.run(); //1~30까지 출력하는 메소드
		//thread02.run(); //a~z까지 출력하는 메소드
		
		//5.run() 메소드를 동시에 실행 ▶ start() 메소드를 출동시켜서! 실행
		thread01.start();
		thread02.start(); //동시에 나오니까 뒤죽박죽 섞여서 나오는거!
		
		
	}//main()
}//class
