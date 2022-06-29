public class Operator03 {
	public static void main(String[] args) {
		//비교연산자 : 대소관계, 동등관계
		//대소관계 : >(gt), >=(ge), <(lt), <=(le)
		//동등관계 : ==(eq), !=(ne)
		//연산의 결과는 true, false로 반환된다. ▶ 조건식 작성에 사용
		
		int num1 = 5, num2 = 10;  	//선언, 할당, 초기화 , 나열
		System.out.println(num1 > num2);     //출력값 : false
		System.out.println(num1 >= num2);    //출력값 : false
		System.out.println(num1 < num2);     //출력값 : true
		System.out.println(num1 <= num2);    //출력값 : true
		System.out.println(num1 == num2);    //출력값 : false
		System.out.println(num1 != num2);    //출력값 : true

		
	}//main()
}//class
