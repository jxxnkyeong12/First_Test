
public class SleepMain {
	public static void main(String[] args) {
		Sleep sleep0 = new Sleep(1);  //1 ->만들고 Sleep클래스로 으로 넘어가
		Sleep sleep1 = new Sleep(2);
		Sleep sleep2 = new Sleep(3);
		
		
		sleep0.start();
		sleep1.start();
		sleep2.start();
	}//main()
}//class
