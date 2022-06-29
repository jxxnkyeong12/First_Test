
public class MyThread03 extends Thread{  //1.Thread Class 상속 받게 하자
	@Override
	public void run() {		//2.
	 for(int i = 1; i<=10; i++) { //3.10번 돌아 
		 System.out.println(getName() + "[" + i + "]");  //getName : 현재 실행중인 Thread Name값을 가져온다- 스레드 이름을 출력해준단 뜻이야
	  }//for
	}//run()
}//class
