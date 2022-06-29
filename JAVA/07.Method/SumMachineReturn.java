import java.util.Scanner;

public class SumMachineReturn {
	//시작값(startNum)과 종료값(endNum)을 입력받은 후 
	//starNum과 endNum을 매개변수로 전달하는 makeSum() 메소드를 호출
	//결과값(sum)을 리턴받아 출력하시오.
	public static void main(String[] args) {
		//입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값을 입력하세요 : ");
		int startNum = Integer.parseInt(scanner.nextLine());	//▶기울기=static이 걸려있단 뜻
		System.out.print("종료값을 입력하세요 : ");
		int endNum = Integer.parseInt(scanner.nextLine());
		scanner.close();
	
		
		//출력
		System.out.println("시작값 : " + startNum);
		System.out.println("종료값 : " + endNum);
		//System.out.println("누적합 : " + makeSum(starNum, endNum)); ②->static이 없어서 오류가 떠
		SumMachineReturn smr = new SumMachineReturn(); //③SumMachineReturn 객체 생성
		System.out.println("누적합 " + smr.makeSum(startNum, endNum));	//④메소드 호출
		
	}//main()
	
	//시작값부터 종료값까지 누적합(sum)을 계산하고 리턴하는 메소드를 정의 : makeSum()
	private int makeSum(int startNum, int endNum) { //①static 지우기, ⑤SumMachineprivate에서 넘어왔는데 public ->private로 변경
		int sum = 0;
		for(int i = startNum; i<= endNum; i++) {
			sum +=i;
		}//for
		return sum;
	}//makeSum()
}//class
