import java.util.Scanner;

public class SumMachinePrivate {
	//시작값(startNum)과 종료값(endNum)을 입력받은 후 
	//starNum과 endNum을 매개변수로 전달하는 makeSum() 메소드를 호출
	//단, makeSum() 메소드는 SumMachine.jave, SumMachineReturn.java 클래스를 활용
	public static void main(String[] args) {
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값을 입력하세요 : ");
		int startNum = Integer.parseInt(scanner.nextLine());	//▶기울기=static이 걸려있단 뜻
		System.out.print("종료값을 입력하세요 : ");
		int endNum = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		//SumMachine.java활용
		//makSum() 메소드에 static 있다 : 클래스명. static 메소드명(); ▶ SumMachine.makeSum(); - integer.parseInt 호출하는거야 
		//makSum() 메소드에 static 없다 : 객체를 생성하며 메소드를 호출하면 된다.
		//SumMachine.makeSum(startNum, endNum); 	//오류 : makeSum() 메소드에 static이 없어서야.
		SumMachine sm = new SumMachine(); 		//SumMachine 객체 생성
		sm.makeSum(startNum, endNum);  			//makeSum() 메소드 호출 -이미 만들어진거 재활용중이야
		//public ~~ makeSum(){~~} : 접근제어자가 [public]으로 선언 되어 있었어 ▶ 그래서 외부에서도 사용 가능하게 해줌
		
		
		//SumMachineReture.java 활용
		SumMachineReturn smr = new SumMachineReturn(); //SumMachineReturn 객체 생성
		
		//System.out.println(smr.makeSum(startNum, endNum));	//메소드 호출 : 오류 발생 -> 접근제어자 때문에
		//private~~ makeSum() {~~} : SumMachineReturn 접근제어자가 [private]으로 선언되어 있다 ▶이건 내부에서만! 사용 가능 그래서 여기선 못쓰는거야
	}//main()
}//class
