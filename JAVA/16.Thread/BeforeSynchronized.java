
public class BeforeSynchronized {
	public static void main(String[] args) {
		//공유객체 생성
		MyData myData = new MyData();  //1
		
		
		//Thread 객체 생성
	Thread plusThread01	 = new PlusTread(myData); //UpCastion으로! 2. 이쪽으로 넘어왔어  
	Thread plusThread02	 = new PlusTread(myData); 
	
		//실행
		plusThread01.start();
		plusThread02.start();
		
		
	}//main()
}//class

//쓰레드객체
class PlusTread extends Thread {
	
	
	private MyData myData;
	public PlusTread(MyData myData) {
		this.myData = myData;
	}//PulusTread
	
	@Override
	public void run() {
		myData.plusData();
		System.out.println(getName()+ "실행결과 : " + myData.data);
		
	}//run
}//class



//공유객체
class MyData{
	int data = 3;
	
	public void plusData() {
		int myData	= data;
		try {
		  Thread.sleep(2000); //2000ms : 2초
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = myData + 1;
	}//plusData()
}//class
