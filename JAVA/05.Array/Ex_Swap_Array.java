import java.util.Arrays;

public class Ex_Swap_Array {
	public static void main(String[] args) {
		//배열(arr1[])에 저장된 데이터를 출력
		int[] arr1 = {1, 2, 3, 4, 5};		//정수형 배열 (arr1[])을 선언하고 초기화 
		
		
		System.out.print("arr1[] 배열의 값 : [");
		for (int i = 0; i < arr1.length; i++) {
			if(i == arr1.length -1) {
				System.out.print(arr1[i]+"]");
				
			}else {
				System.out.print(arr1[i]+", ");
			}//if
			
			//System.out.print(arr1[i]+", ");
		}//for
		
		System.out.println();
		
		System.out.println("arr1[] 배열의 값 : " + Arrays.toString(arr1));
		
		//배열(arr1[])에 저장된 데이터를 역순으로 출력하시오
		int[] arr2 = new int[arr1.length];	//임시 배열(arr2[])을 선언 및 생성
		arr2[0] = arr1[4];
		arr2[1] = arr1[3];
		arr2[2] = arr1[2];
		arr2[3] = arr1[1];
		arr2[4] = arr1[0];
		
		 for (int i = 0; i < arr2.length; i++) { 
			arr2[i] = arr1.length - i;      //Test 한거..ㅎ  - 이건 그냥 인덱스 값이 없어!
		}//for 
		System.out.println("arr2[] 배열의 값 : " +  Arrays.toString(arr2));
		
		
		//배열(arr1[])에 저장된 데이터를 역순으로 출력하시오
		int[] arr3 = new int[arr1.length];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[arr1.length - (i + 1)];  //선생님이랑 같이 한거 - 인덱스 값이 들어가 있어!
			
		}
		System.out.println("arr3[] 배열의 값 : " +  Arrays.toString(arr3));
		
	}//main()
}//class





