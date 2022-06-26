public class Test_Array02 {
	public static void main(String[] args) {
		//초기화된 배열(arr[])에서 홀수의 합(oddSum)과 짝수의 합(evenSum)을 구하여 출력
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int oddSum = 0, evenSum = 0;     //for, if이용해서 
			
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {			//if(i % 2에거 i가 아니야 arr[i]를 넣어줘야지!!!
				oddSum +=arr[i];
		    } else {					//짝수이면
				evenSum +=arr[i];
			}//if
		 }//for
		
		System.out.println("홀수의 합 : " + oddSum);
		System.out.println("짝수의 합 : " + evenSum);
		
		
	}//main()
}//class
