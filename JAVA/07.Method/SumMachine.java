import java.util.Scanner;

public class SumMachine {
	//시작값(startNum)과 종료값(endNum)을 입력받은 후 
	//starNum과 endNum을 매개변수로 전달하는 makeSum() 메소드를 호출
	public static void main(String[] args) {
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값을 입력하세요 : ");
		int startNum = Integer.parseInt(scanner.nextLine());	//▶기울기=static이 걸려있단 뜻
		System.out.print("종료값을 입력하세요 : ");
		int endNum = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		//메소드 호출
		//makeSum(starNum, endNum); 		//②밑에 static을 지우니 오류가 뜸 - why? makeSum() 메소드에 static이 없어서.
								  			//③makeSum이 기울기로 쓰이면 static에 걸려있다란 뜻.
		SumMachine sm = new SumMachine();	//④밑에 static을 지우고 싶으면 SumMachine 객체 생성 
		sm.makeSum(startNum, endNum); 		//⑤생성된 객체안에 있는 메소드를 호출 ->그러면 밑에 static지워도 예외 안떠
	}//main()
	
	//시작값부터 종료값까지 누적합(sum)을 계산하고 출력하는 메소드를 정의 : makeSum()
	public void makeSum(int startNum, int endNum) { //①static 제거
		int sum = 0;
		for(int i = startNum; i<= endNum; i++) {
			sum +=i;
		}//for
			System.out.println("시작값 : " + startNum);
			System.out.println("종료값 : " + endNum);
			System.out.println("누적합 : " + sum);
	}//makeSum()
}//class
