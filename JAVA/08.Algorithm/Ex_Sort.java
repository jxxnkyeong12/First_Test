import java.util.Arrays;

public class Ex_Sort {
	public static void main(String[] args) {
		//정수형 배열(arr[])의 원소값을 오름차순으로 정렬 : ascSort()
		//정수형 배열(arr[])의 원소값을 내름차순으로 정렬 : descSort()
		int[] arr = {3,2,4,1,5};
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		
		Ex_Sort ex = new Ex_Sort(); //객체 생성
		int[] ascArr = ex.ascSort(arr);
		System.out.println("오름차순 정렬 : " + Arrays.toString(ascArr));
		
		int[] descArr =ex.descSort(arr);
		System.out.println("내림차순 정렬 : " + Arrays.toString(descArr));
		
		Arrays.sort(arr); 		//배열(arr[])을 무조건 오름차순으로 정렬
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
	
	}//main()
	
	//오름차순으로 정렬하는 메소드(작은것에서 큰것으로)
	public int[] ascSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {  //int j = i를 i+1로 바꿔주면 선택정렬이 돼
				if(arr[i] > arr[j]) {			//부등호 방향을 i가 더 크게 ( > )하면 오름차순이 돼! 반대면 내림차순~!
				int temp = arr[i];			//Swap:교환 이 이뤄지는 과정 
					arr[i] = arr[j];	//i에 j값을 할당
					arr[j] = temp;
				}//if
			}//for j
		}//for i
		return arr;
	}//ascSort()
	
	//내림차순으로 정렬하는 메소드(큰것에서 작은것으로)
	public int[] descSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {  //int j = i를 i+1로 바꿔주면 선택정렬이 돼
				if(arr[i] < arr[j]) {			//부등호 방향을 i가 더 작게 ( < ) 내림차순~!
				int temp = arr[i];			//Swap:교환 이 이뤄지는 과정 
					arr[i] = arr[j];	//i에 j값을 할당
					arr[j] = temp;
				}//if
			}//for j
		}//for i
		return arr;
		
	}//descSort
}//class
