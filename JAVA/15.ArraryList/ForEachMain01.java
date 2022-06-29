public class ForEachMain01 {
	public static void main(String[] args) {
		int[] score = {95, 80, 72, 83, 66};
		
		//배열의 총합(sum) : ■단순 for문사용해보기 -> 배열(Array[] 적용

		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];  //sum = sum + score[i];
		}
		System.out.println("배열의 총합 : " +  sum);  //출력문 배열의 총합 : 396
		
		//배열의 총합(result) : ■향상된 for문을 사용해보기 -> 컬렉션(ArrayList<>) 적용
		int result = 0;
		for (int i : score) {
			result += i;  // 왜 여기는 그냥 i로 쓸까? [i]가 아니라? ▶ 향상된 for문은 밑에서 설명했듯이 index가 불필요해서! [] 이거 안해줘!!!!! 그리고 i말고 다른거 넣어도 상관없엉 ㅎ z라던가 y라던가... 
		}//for
		System.out.println("배열의 총합 : " + result);  //출력문 배열의 총합 : 396
	}//main()
}//class


/*
○ 단순 for문 : index가 필요해

 	for(초기값(시작값); 조건식(최종값); 증감값) {
 		~~body(반복변수)~~;
 	}//for
 
 ex) for(int i = 0; i< arr.length; i++){
 		arr[i] = 10;
 	}
 ○ 향상된 for문 : 단순 for문을 간소화 ▶ index가 불필요 
   	for(Type 식별자 : 배열명 ){
   		~~ body(식별자)~~;
   	}
 
 ex) for(int i : arr){      //타입 : int, 식별자 : arr(배열명)
 	 	 syso(i);
 	
 	}
 */
