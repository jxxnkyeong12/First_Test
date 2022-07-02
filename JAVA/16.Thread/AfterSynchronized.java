public class AfterSynchronized {
	public static void main(String[] args) {
		//공유객체 생성
		MyData1 myData = new MyData1(); //1.
		
		//Thread 객체 생성
		Thread plusThread01 = new PlusThread1(myData);	//UpCasting -2 이쪽으로 넘어와
		Thread plusThread02 = new PlusThread1(myData);
		
		//실행
		plusThread01.start();
		plusThread02.start();
	}//main()
}//class

//쓰레드
class PlusThread1 extends Thread{
	private MyData1 myData;
	public PlusThread1(MyData1 myData) {
		this.myData = myData;
	}
	
	@Override
	public void run() { //3. run override해주기
		myData.plusData();
		System.out.println(getName() + "실행결과 : " + myData.data); //밑에 data! 3에 1을 더해서 4로 출력돼 
	}//run
}//class

//공유객체
class MyData1{
	int data = 3;
	
	public synchronized void plusData() {	//synchronized : 동기화
		int myData = data;
		try {
			Thread.sleep(2000);	//2000ms : 2초
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = myData + 1;				
	}//plusData()
}//class