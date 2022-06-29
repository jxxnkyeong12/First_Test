public class Variable03 {
	public static void main(String[] args) {
		//정수형 데이터 타입 : byte(1), short(2), int(4), long(8)
		byte num1 = 100;	//1Byte : -128 ~ 127
		System.out.println("변수 num1의 값 :" + num1);
		
		short num2 = 10000;	//2Byte : -32, 768 ~ 32, 767
		System.out.println("변수 num2의 값 :" + num2);
		
		int num3 = 100000;	//4Byte : -2,147,483,648 ~ 2,147,483,647
		System.out.println("변수 num3의 값 :" + num3);
		
		long num4 = 1234567890123456789L; 	//8Byte ▶ 값을 할당할 때 반드시 접미사로 L을 붙인다.
		System.out.println("변수 num4의 값 :" + num4);

	}//main()
}//class
