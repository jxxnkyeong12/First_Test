public class Ex_for01 {
	public static void main(String[] args) {
		//정수 0부터 10까지 출력하시오.
		//System.out.println(0);
		//System.out.println(1);
		//System.out.println(2);
		//중간생략
		//System.out.println(10);
		
		for(int i = 0; i <= 10; i++) {	//반복변수 i를 0부터 10까지 1씩 증가(반복)
			System.out.println(i);  	//i값을 출력
		}//for
		
		System.out.println("====");
		
		//0부터 10까지의 정수 중에서 짝수만 출력 : for문만 사용
		for(int i = 0; i <=10; i = i + 2) {		//i +=2
			System.out.println(i);
		}//for
		
		System.out.println("====");
		//0부터 10까지의 정수 중에서 짝수만 출력 : for(반복), if(짝수판단)
		for(int i = 0; i <=10; i++) {	//반복변수 i를 0부터 시작하여 10까지 1씩 증가하면서 반복
			if(i % 2 == 0) {			// i를 2로 나눈 나머지가 0이면 (짝수)
				System.out.println(i);	// i 값을 출력
			}//if
		}//for
	}//main()
}//class



/*
★ 반복문(순환문, Loop)
	- for문 : 반복횟수를 알고 있을 때 사용, 가장 많이 사용
	- while문 : 반복횟수를 모를 경우 사용, 선조건 후처리
	- do~while문 : 최소 한번은 실행해야 할 경우, 선처리 후 조건
	
★ for문
	for(초기문(시작값); 조건문(최종값); 반복후작업(증감값)){
		반복할 문장;
	}


*/