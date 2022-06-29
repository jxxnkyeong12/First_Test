import java.util.Arrays;

public class Ex_Max_Min {
	//정수형 배열의 원소값의 최대값(max), 최소값(min)을 구하여 출력하세요
	
	public static void main(String[] args) {
		int[] arr = {3,2,4,1,5};			//정수형 배열을 선언하고 값을 할당 : 초기화
		
		
		Ex_Max_Min ex = new Ex_Max_Min();
		int max = ex.getMax(arr); 		//최대값을 계산하는 메소드를 호출
		int min = ex.getMin(arr);		//최소값을 계산하는 메소드를 호출
		
		ex.display(arr, max, min); 	//결과를 출력하는 메소드를 호출
		
		System.out.println("==============================마지막에 한거- 선생님 tip but 배열이 틀어져버림=");
		
		Arrays.sort(arr); 		//배열(arr[])을 오름차순 정렬
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("배열의 최대값 : " +  arr[arr.length-1]);
		System.out.println("배열의 최소값 : " +  arr[0]);
		
	}//main()
	
	//최대값을 계산하고 리턴하는 메소드를 정의하자
	public int getMax(int[] arr) {
		int max = arr[0];		//최대값 저장될 변수를 초기화(무조건0넣고) ▶배열의 첫 번째 index(3)로 할당
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {		//현재의 최대값(max)과 각각의 배열 원소값을 비교
				max = arr[i];		//배열 원소값(arr[i])이 더 크면, 최대값을 변경하겠다(즉, 재할당하겠다)
			}//if
		}//for
		return max;
	}//getMax()
	
	//최소값을 계산하고 리턴하는 메소드를 정의
	public int getMin(int[] arr) {
		int min = arr[0];			//최소값 저장될 변수를 초기화(무조건0넣고) ▶배열의 첫 번째 index(3)로 할당
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}//if
		}//for
		return min;
	}//getMin
	
	//출력 메소드
	
	public void display(int[]arr, int max, int min) {
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("배열의 최대값 : " +  max);
		System.out.println("배열의 최소값 : " +  min);
		
	}//display
}//class




/*
public static void main(String[] args) {
	int[] arr = {3, 2, 4, 1, 5};

	int max = arr[0];
	int min = arr[0];
	for (int i = 0; i < arr.length; i++) {
		if(max < arr[i]) {
			max = arr[i];
		}else if(min > arr[i]){
			min = arr[i];
		}//if
	}//for

	System.out.println("배열의 원소값 : " + Arrays.toString(arr));
	System.out.println("배열의 최대값 : " + max);
	System.out.println("배열의 최소값 : " + min);
}//main() 
*/