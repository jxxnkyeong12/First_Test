import java.util.Scanner;

public class Test_Method02 {
	//임의의 실수 2개를 입력(num1, num2) 받아 ▶ Scanner
	//두 실수의 합을 구하여 리턴하는 메소드(getSum())를 호출
	//리턴받은 결과를 출력
	public static void main(String[] args) {
		//두 개의 실수(num1, num2)를 입력받는다
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 실수를 입력하세요 : ");
		double num1 = Double.parseDouble(scanner.nextLine());
		System.out.print("두 번째 실수를 입력하세요 : ");
		double num2 = Double.parseDouble(scanner.nextLine());
		scanner.close();
		
		//getSum() 메소드를 호출하고 결과를 리턴받는다
		double sum = getSum(num1 , num2);
		
		
		
		//결과를 출력
		System.out.println("첫 번째 실수 : " + num1);
		System.out.println("두 번째 실수 : " + num2);
		System.out.println("두 실수의 합 : " + sum);
		System.out.println("두 실수의 합 : " + getSum(num1, num2)); //이렇게 쓰면 코드를 좀더 줄일수 있징
	}//main()
	
	//두 개의 실수를 전달받아 합(sum)을 구하여 리턴하는 메소드를 정의
	public static double getSum(double num1, double num2) {
		//double sum = num1 + num2;
		//return sum;
		return num1 + num2;
	}//getSum
}//class




