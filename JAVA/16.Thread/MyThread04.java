 //자바에서는 다중 상속이 불가능 하다
//이미 다른 클래스를 상속받은 상태에서는 Thread Class 상속 불가능 ▶ Thread 구현할 수 없다.
//이러한 문제점을 해결하기 위해 Runnable Interface 제공 ▶ 재정의(Override)가 필수

public class MyThread04 implements Runnable{ //딱 여기까지만 쓰면 MyThread04에 빨간줄 들어와, 그러니까 override 해줘!

	@Override
	public void run() {
		for(int i = 1; i<=30; i++) {
			System.out.print(i + ", ");
		}//for
		System.out.println();
		
	}//run

}//class

class MyThread05 implements Runnable{

	@Override
	public void run() {
		for(char i ='a'; i<='z'; i++) {
			System.out.print(i+ ", ");
		}//for
		System.out.println();
	}//run
}//중첩 class
