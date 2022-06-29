public class Ex_if_els_if {
	public static void main(String[] args) {
		//성별코드(code)가 1이면 '남자', 2이면 '여자'
		//3이면 '남자', 4이면 '여자', 그 외에는 오류메세지를 출력
		
		int code = 5;
		if(code == 1) {
			System.out.println("남자 입니다.");
		} else if(code == 2) { 
			System.out.println("여자 입니다.");
		} else if(code == 3) {
			System.out.println("남자 입니다.");
		} else if(code == 4) {
			System.out.println("여자 입니다.");
		} else {
			System.out.println("성별코드가 잘못 입력되었습니다!");
		}
	
		System.out.println("==============");
		
		
		if(code == 1 || code == 3) {	//논리연산자
			System.out.println("남자 입니다");
		} else if(code == 2 || code == 4) {
			System.out.println("여자 입니다.");
		} else {
			System.out.println("성별코드가 잘못 입력되었습니다!");
		}
		
		
	
	}//main()
}//class





/*
★ 다중 if문 : 여러개의 조건을 판단하여, 해당 조건을 만족할 경우 실행

if(조건식1){
 	조건식1이 참일때 실행되는 문장;
} else if(조건식2) {
	조건식2가 참일때 실행되는 문장;
} else if(조건식N) {
	조건식N이 참일때 실행되는 문장;
} else { 
 	거짓일때 실행되는 문장;
}


*/