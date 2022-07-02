public class Sleep extends Thread{
	
	//생성자 메소드 초기화
	private int num;		//3 멤버변수 만들어주고
	public Sleep(int num) {  //2 Main의 new Sleep(1) 1전달받는 값을 int num으로 만들어서 넣어줘!
		this.num = num;    //4
	}
	
	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			System.out.print(num + ", ");
			try {//★
				sleep(1000);  //★1000ms : 1초 (쓰레드를 제어하고 있다!)★
			} catch (InterruptedException e) {//★
				e.printStackTrace();
			}
		}//for
	
	}//run()
	
}//class
