public class Ex_Array01 {
	public static void main(String[] args) {
		//정수를 저장할 배열(arr[])을 선언하고 
		//저장할 배열의 크기(길이)를 3으로 생성하고
		//모든 요소에 10을 할당하고 출력하시오
		int[] arr; 			//정수형 배열 arr을 선언했다. ▶ int arr[];
		arr = new int[3];	//배열의 생성: 배열의 크기(길이)가 결정 - 지정한 크기는 이제 못 바꿔! (그래서 이게 단점)
		//int[] arr = new int[3]; //배열의 선언 및 생성 한줄로 쓰기
		
		arr[0] = 10; 	//배열(arr[])의 0번지(index)에 값(10)을 할당
		arr[1] = 10; 	//배열(arr[])의 1번지(index)에 값(10)을 할당
		arr[2] = 10; 	//배열(arr[])의 2번지(index)에 값(10)을 할당
		
		System.out.println("arr[0]의 값 : " + arr[0]);
		System.out.println("arr[0]의 값 : " + arr[1]);
		System.out.println("arr[0]의 값 : " + arr[2]);
		
	}//main()
}//class
