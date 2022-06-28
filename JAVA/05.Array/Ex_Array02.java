public class Ex_Array02 {
	public static void main(String[] args) {
		
		//정수 3개를 저장할 배열(arr[])을 선언하고 
		//동시에 모든 요소에 10을 할당하시오 ▶ 배열의 선언 및 초기화
		int[] arr = {10, 10, 10}; 	//정수형 배열(arr[])을 선언하고 동시에 값을 할당
		
		int[] arr1;  			//배열의 선언
		//arr1 = {10, 10, 10};	//오류 why? 배열의 생성단계가 누락됐기 때문에 오류가 떠
		arr1 = new int[] {10, 10, 10}; 	//배열의 생성 및 초기화 (new! 이 단계 중요!)
 		
		//배열(arr[])의 모든 요소의 합(sum)을 구하여 출력하시오.
		int sum = arr[0] + arr[1] + arr[2];
		
		
		//배열(arr[])의 모든 요소의 합(total)을 구하여 출력하시오.
		int total = 0;										//결과가 저장될 곳
		for (int i = 0; i < arr1.length; i++){ 			//Ctrl+ spac 눌러서 완성시키고 sum구할때는 arr1을 arr로 바꿔줘
			total = total + arr1[i];		//total += arr1[i];
    
	    }//for
		
		System.out.println("배열 (arr[])의 총합 : " + sum);
		System.out.println("배열 (arr[])의 크기(길이) : " + arr.length);
		System.out.println("배열 (arr1[])의 총합 : " + total);
	}//main()
}//class

/*
 ○배열(Array) : 참조형 자료구조 ▶ 객체화(객체를 생상하여 접근)
  - 동일한 기억공간을 메모리에 연속적으로 생성하는 자료구조 :  리스트(선형) 구조
  - 같은 타입을 갖는 변수들의 집합체 ★
  - 배열을 선언하고 생성한 후 , 나중에 내용물(원소값)을 채우는 방식 ▶ Ex_ Array01.java
  - 배열을 선언하는 동시에 배열안의 내용물(원소값)을 같이 채우는 방식 ▶ Ex_Array02.java
  - 배열의 접근은 반드시 요소번호(index)로 접근하며, index는 항상 0부터 시작 ★
  - 배열의 크기(길이) : 배열명.length ★
  - 배열의 마지막 index  : 배열명. length은 -1
  
  
  

 */

