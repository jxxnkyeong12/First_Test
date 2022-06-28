public class Test_Array01 {
	public static void main(String[] args) {
		//정수 3개를 저장할 배열(arr1[])을 선언 및 생성하고,
		//모든 요소(index)에 10을 할당하고 출력하시오. ▶ for문 활용
		int [] arr1 = new int[3]; 			//정수형 배열(arr1[])을 선언하고 생성
		for (int i = 0;  i < arr1.length; i++) {  //0을 i로 바꿔라!!!쫌!! 오타!!!내지마!!
			arr1[i] = 10;				      //배열 arr1[i] 번지 (index)에 10을 할당
			System.out.println("arr1[" + i + "]의 값 : " + arr1[i]);		//arr1[i] 값을 출력 (arr1만 입력하지말고 배열도 입력해줘야지)
		}//for
		
		
		System.out.println();		//빈줄 산입
		
		//정수 3개를 저장할 배열(arr2[])을 선언 및 생성하고, 
		//각각의 요소(index)에 10, 20, 30을 할당하고 출력하시오 ▶for문 활용해
		
		int[] arr2 = new int[3];		//정수형 배열(arr2[])을 선언하고 생성
		for (int i = 0; i < arr2.length; i++) { //인덱스 길이가 몇개냐 - 3을 넣으면 맞아.
			arr2[i] = (i + 1) * 10;
			System.out.println("arr2[" + i + "]의 값 : " + arr2[i]);
		}//for
	}//main()
}//class
