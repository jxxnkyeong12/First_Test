import java.util.Scanner;

public class Ex_Cnt {
	//두 개의 정수를 입력받아(num1, num2) 두 수 사이의 정수의 개수를 구하고 출력하세요
	
	public static void main(String[] args) {
		//두 개의 정수를 입력 받자
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 번째 정수를 입력하세요 : ");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.println("두 번째 정수를 입력하세요 : ");
		int num2 = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		Ex_Cnt ex = new Ex_Cnt();
		int cnt = ex.getCnt(num1, num2);    //개수를 구하는 메소드를 호출
		ex.display(num1, num2, cnt); 		//출력 메소드
	}//main
	
	//두 수 사이의 정수의 개수를 구하는 메소드를 정의
	public int getCnt(int num1 , int num2) {
		int cnt = 0; 		//결과가 저장될 변수를 초기화
		for(int i = num1; i <=num2; i++) {
			cnt = cnt + 1; 	//개수를 구하기
			//cnt += 1;			
			//cnt++; 		//이게 개발자들이 잘써 ㅎ
		}//for
		return cnt;
	}//getCnt()
	
	//출력 메소드를 정의 하자 
	public void display(int num1, int num2, int cnt) {
		 System.out.println("첫 번째 정수 : " + num1);
		 System.out.println("두 번째 정수 : " + num2);
		 System.out.println("두 수 사이의 정수 개수 : " + cnt);
		 
	}//display()
}//class



/*
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("첫 번째 정수를 입력하세요 : ");
	int num1 = Integer.parseInt(scanner.nextLine());
	System.out.print("두 번째 정수를 입력하세요 : ");
	int num2 = Integer.parseInt(scanner.nextLine());
	scanner.close();

	int cnt = 0;
	for(int i = num1; i <= num2; i++) {
		cnt = cnt + 1;
		//cnt += 1;
		//cnt++;
	}//for

	System.out.println("첫 번째 정수 : " + num1);
	System.out.println("두 번째 정수 : " + num2);
	System.out.println("두 수 사이의 정수의 개수 : " + cnt);
}//main() 
*/

