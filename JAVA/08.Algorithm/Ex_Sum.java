import java.util.Arrays;

public class Ex_Sum {
	public static void main(String[] args) {
		//정수형 배열(arr[])의 원소값의 누적합(sum)을 구하여 출력
		int[] arr = {3,2,4,1,5};			//정수형 배열을 선언하고 값을 할당 : 초기화
		
		Ex_Sum ex = new Ex_Sum();   		//Ex_Sum 객체를 생성
		int sum	= ex.getSum(arr); 					//누적합을 계산하는 메소드를 호출 
		ex.display(arr,sum);   				//arr와sum 결과를 출력하는 메소드를 호출
	}//①main()

	



	//누적합(sum)을 계산하고 결과를 리턴하는 메소드를 정의 
	public int getSum(int[] arr) {
		int sum = 0; 				//결과가 저장될 변수를 초기화
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];		//누적합 계산 : sum += arr[i];
			
		}//for
		return sum; 	//void가 오면 안돼 그러니까 int 로 바꿔줘
	}//②getSum
	
	//결과를 출력하는 메소드를 정의하자
	public void display(int[] arr, int sum) {
		System.out.println("배열의 원소값 : " + Arrays.toString(arr)); //Arrays.toString int타입! 해줘
		System.out.println("원소의 누적합 : " + sum);
	}//③display()
	
}//class




/*
public static void main(String[] args) {
	int[] arr = {3, 2, 4, 1, 5};

	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
		sum = sum + arr[i];
	}

	System.out.println("배열의 원소값 : " + Arrays.toString(arr));
	System.out.println("원소의 누적합 : " + sum);
}//main()
*/



