
public class MyThread04Main {
	public static void main(String[] args) {
		//1.객체 생성 -> 6.일종의 UpCasting!
		//2.MyThread04 run01 = new MyThread04();  //3.MyThread04의 부모는 Runable! 
		Runnable run01 = new MyThread04();  //4.
		Runnable run02 = new MyThread05();  //5
		
		//■Runnable Interface를 상속받아 구현한 Thread는 진짜 쓰레드가 아니다
		//Runnable에는 start()메소드가 정의가 안되어 있다
		//■Thread 객체를 생성하고, Runnable Interface를 상속 받은 클래스를 매개변수로 전달한다.
		//■run01.start(); 는 오류가 돼 ▶ 진짜 쓰레드가 아니다!
		
	Thread thread01	= new Thread(run01); //▲new 하고 어시스트 Thread(Rnnable)로 해주면 진짜 쓰레드가 돼 (이 단계를 거쳐야 함다!)
	Thread thread02	= new Thread(run02);
	Thread thread = new Thread(new MyThread04()); //연쇄
	
		//■Thread의 실행은 start() 메소드를 호출
		thread01.start();
		thread02.start();
		
  	}//main()
}//class
