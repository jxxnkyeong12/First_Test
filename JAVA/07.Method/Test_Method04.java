import java.util.Scanner;

public class Test_Method04 {
	//임의의 정수 두개를 입력(num1, num2) 받은 후 
	//두 정수 사이의 홀수의 합계(oddSum)을 구하여 결과를 리턴하는 메소드(getOddSum())를 호출
	//두 정수 사이의 짝수의 합계(evenSum)을 구하여 결과를 리턴하는 메소드(getEvenSum())를 호출
	//결과를 출력하는 메소드(display())를 호출 
	public static void main(String[] args) {
		
		//입력
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		//처리 : 메소드 호출
		int oddSum = getOddSum(num1,num2);
		int evenSum = getEvenSum(num1,num2); //①display보다 먼저 와 있으면 좋긴해 근데 이걸 
		
		System.out.println();
		
		//출력
		System.out.println("첫 번째 정수 : " + num1);
		System.out.println("두 번째 정수 : " + num2);
		if(num1 > num2) { //이래버리면 값이 안나와서
			System.out.println("첫 번째 정수는 작은수, 두 번째 정수는 큰 수를 입력하세요!"); //오류메세지 출력하게 만들기
		}else {
			display(oddSum, evenSum); //②처리문을 여기에 넣어도 좋다.
		}//if
	
		System.out.println();
		
	}//main()
	//두 정수 사이의 홀수의 합계(oddSum)을 계산하고 리턴하는 메소드(getOddSum())을 정의
	public static int getOddSum(int num1, int num2) {
		int oddSum = 0;
		for(int i = 1; i<=num2; i++) {
			if(i % 2 !=0) {
				oddSum = oddSum + i;
			}//if
		}//for
		return oddSum;
				
	}//getOddSum
	
	//두 정수 사이의 짝수의 합계(evenSum)을 계산하고 결과를 리턴하는 메소드(getEvenSum())을 정의
	public static int getEvenSum(int num1 , int num2) {
	    int evenSum = 0;
		for(int i = 1; i<=num2; i++) {
			if(i % 2 ==0) {
				evenSum = evenSum + i;
			}//if
		}//for
		return evenSum;
	}//getEvenSum
	
	//결과를 출력하는 메소드(display())를 정의
	public static void display(int oddSum, int evenSum) {
		System.out.println("홀수의 합 : " +  oddSum);
		System.out.println("짝수의 합 : " +  evenSum);
	}//display
	
}//class
