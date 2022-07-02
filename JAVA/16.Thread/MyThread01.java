//2.★Thread(쓰레드) : 동시에 작업을 처리하자 란 개념이 따라붙어 ▶Thread Class를 상속받아 구현
public class MyThread01 extends Thread { //3. extends로 Thread 를 상속받아
	
	
	//1.1~30 출력하는 코드 : 4.run() 메소드에서 재정의(Override)
	
	@Override
	public void run() { //5.
		for(int i = 1; i<=30; i++) { //6.
			System.out.print(i + ", ");
		}//for
		System.out.println(); //7. 1부터 30까지 끝나면 빈줄 산입되게 만들었다!
	}//run()
}//class
 


//8.★중첩클래스 : 하나의 *.java 파일에 2개 이상의 클래스를 구현 (접근제어자를 써주면 안돼!) 맨날 들어가는 workspace src 말구 bin파일에 들어가보면 생성되어 있어!
class MyThread02 extends Thread{   //9. Thread Class 상속
	
	//▣a~z까지 출력하는 코드 : 동시에 작동되게 할거니까 반드시 run()메소드에서 재정의(Override)시켜라! 하나의 규칙이고 약속이야
	
	@Override 
	public void run() { //10.
		for(char i ='a'; i<='z'; i++) { //11.문자 하나니까 'char'을 써줘 12.MyThread01Main을 만들어줘!
			System.out.print(i+ ", ");
		}//for
		System.out.println();
	}//run
	
}//class 블럭이 만들어 진다
