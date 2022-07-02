
public class MyThread03Main {
	public static void main(String[] args) {
		//하나의 작업(MyThread03.java)이 동시에 실행되게끔 하자
		//Thread Class는 하나만 만들고, 객체를 여러개 만들어서 실행하면 된다
		MyThread03 thread0 = new MyThread03();   //1.
		MyThread03 thread1 = new MyThread03();
		MyThread03 thread2 = new MyThread03();
		
		
		//3.
		thread0.setName("첫 번째 : "); //setName() : Thread의 이름을 바꿔준다
		thread1.setName("두 번째 : ");
		thread2.setName("세 번째 : ");
		
		
		//2.Thread의 실행은 start() 메소드 호출
		thread0.start();
		thread1.start();
		thread2.start();
		
		
		
	}//main()
}//class


/*
2번까지만 했을때 출력결과물, 뒤죽박죽 동물원~
Thread-1[1]
Thread-0[1]
Thread-2[1]
Thread-0[2]
Thread-0[3]
Thread-1[2]
Thread-0[4]
Thread-2[2]


3번까지 해서 다시 실행하면 , 여전히 뒤죽박죽이다 ㅎㅎ
첫 번째 : [1]
두 번째 : [1]
세 번째 : [1]
두 번째 : [2]
첫 번째 : [2]
두 번째 : [3]
두 번째 : [4]
두 번째 : [5]
두 번째 : [6]
두 번째 : [7]

*/