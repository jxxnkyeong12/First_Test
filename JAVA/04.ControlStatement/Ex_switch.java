public class Ex_switch {
	public static void main(String[] args) {
		int score = 77;
		switch(score) {
		  	case 100:
		  		System.out.println("A학점");
		  		break;
		  	case 99:
		  		System.out.println("A학점");
		  		break;
		}//switch → case 비교값을 일일이 작성해야 하는 불편함 그래서 사용x
		
		int code = 1;
		switch(code) {
			case 1:
				System.out.println("남자 입니다");
				break;
			case 2:
				System.out.println("여자 입니다");
				break;
			case 3:
				System.out.println("남자 입니다");
				break;
			case 4:
				System.out.println("여자 입니다");
				break;
			default :
				System.out.println("성별코드가 잘못 입력되었습니다.");
				break;
		}
		
		
	}//main
}//class



/*
○ 선택문(switch ~~ case ~~) : 다중 if문을 간략하게 표현할때

switch(기준값){
	case 값1 : 
		값1이 참일때 실행되는 문장;
		break;
	case 값2 :
		값2가 참일때 실행되는 문장;
		break;
	case 값N :
		값N이 참일때 실행되는 문장;
		break;
	default :
		거짓일때 실행되는 문장;
		break;

}


- 기준값, 비교값(값1, 값2, 값N)은 반드시 정수형의 자료이어야 한다.
- 실행문 뒤에는 반드시 break; 입력
- 제한사항(제약조건)으로 인하여 실무에서는 거의 사용되지 않는다.


*/