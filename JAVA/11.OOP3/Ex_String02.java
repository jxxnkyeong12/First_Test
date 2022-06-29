public class Ex_String02 {
	//문자열의 대소관계 비교 : compareTo()
	//문자열의 동등관계 비교 : equals(), equalsIgnoreCase()
	public static void main(String[] args) {
		String str1 = "APPLE";
		String str2 = "ORANGE";
		String str3 = "APPLE";
		String str4 = "apple";
		
		//if(str1 > str2)  ▶ 오류 : 문자열은 비교연산자를 사용할 수 없다.
		//문자열의 비교는 compareTo() 메소드를 활용 : 유니코드 값으로 비교
		//compareTo(), compareToIgnoreCase() 결과 : 양수, 0, 음수
		
		int result  = str1.compareTo(str2);
		System.out.println(result); 		//-14(음수) : str2가 더 크다 A-65 O-79 -14차이 나! 왼쪽이 더 작아

		result = str1.compareTo(str3);
		System.out.println(result);   		//0 : str1과 str3은 같다.
		
		result = str4.compareTo(str1);
		System.out.println(result);   		//32(양수) : str4가 더 크다. a - 97 , A - 65
		
		result = str4.compareToIgnoreCase(str1);	//대소문자 구분없이 비교
		System.out.println(result);			//0 : str4와 str1은 같다.
		
		//문자열이 같은지 다른지(동등관계)를 비교
		//if(str1.compareTo(str3) == 0) {		//▶str1과 str3은 같다 → equals() : true, false
		if(str1.equals(str4)) {                 //▶이게 위에 말과 같은거야! true
			System.out.println(str1 + "과" +  str4 + "은 같다");
		}else {
			System.out.println(str1 + "과" +  str4 + "은 같지 않다");
		}//if
		
		if(str1.equalsIgnoreCase(str4)) {		//▶대소문자 구분없이 비교해주세요	그래서 같다가 나와.
			System.out.println(str1 + "과" +  str4 + "은 같다");
		}else {
			System.out.println(str1 + "과" +  str4 + "은 같지 않다");
			
		}//if
	}//main()
}//class
