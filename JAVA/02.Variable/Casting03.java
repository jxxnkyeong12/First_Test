public class Casting03 {
	public static void main(String[] args) {
		//String 클래스를 이용하여 문자 10(str1)과 문자 20(str2)을 더하기 연산
		String str1 = "10";
		String str2 = "20";
		System.out.println(str1 + str2);	//출력값 : 1020 ▶ Concatenation(결합, 연결)
		
		//문자 10(str1)을 정수 10(num1)으로 변환
		//int num1 = (int) str1;	//오류 발생 why? Casting 연산자를 사용 할 수 없어서 (String(Class)->int(PDT) 는 자바에서 불가하다)
		//String 타입(Class)을 기본 데이터 타입(PDT)으로 변환해 주는 클래스 ▶ Wrapper Class
		int num1 = Integer.parseInt(str1);	//변수 num1에는 정수 10이 저장
	    int num2 = Integer.parseInt(str2);  //변수 num2에는 정수 20이 저장
	    System.out.println(num1 + num2);    //출력값 : 30
		System.out.println(Integer.parseInt(str1) + Integer.parseInt(str2));
		
		//String 클래스를 이용하여 문자 12.3(str3)과 문자 45.67(str4)을 더하기 연산
		String str3 = "12.3";         //String str3 = "12.3" str4 ="45.67"; 나열로도 가능
		String str4 = "45.67";
		System.out.println(str3 + str4);    //출력값 : 12.345.67 ▶ Concatenation(결합, 연결)
		
		double num3 = Double.parseDouble(str3);		//String -> double
		double num4 = Double.parseDouble(str4);		//Wrapper Class 
		System.out.println(num3 + num4);       //출력값 :  57.97
		System.out.println(Double.parseDouble(str3)+ Double.parseDouble(str4));
		
	}//main()
}//class
