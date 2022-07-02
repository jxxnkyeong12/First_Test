
public class PriorityMain {
	public static void main(String[] args) {
		Priority priority0 = new Priority();
		Priority priority1 = new Priority();
		Priority priority2 = new Priority();
		
		priority0.setPriority(1); //0번 쓰레드에는 1번값을 준거 -최소
		priority1.setPriority(5); //기본
		priority2.setPriority(10); //최대
		
		priority0.start();
		priority1.start();
		priority2.start();
	}//main()
}//class
