import java.util.Arrays;

public class Ex_String01 {
	//String Class : 문자열을 조작하기 위한 기능을 담고 있는 클래스
	//SunMicroSystem(Oracle) 업체에서 미리 제작하여 제공 ▶ API(Library)
	//JRE System Library > java.base > java.lang > String.class
	//API문서(설명서) > www.oracle.com > Java API Documents
	//https://docs.oracle.com/en/java/javase/11/docs/api/index.html
	
	
	public static void main(String[] args) {
		String str1 ="apple"; 				//apple 문자열을 str1 변수에 할당
		String str2 = new String("APPLE"); 	//APPLE 문자열을 str2 객체에 할당
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		
		//■length() : 문자열의 길이를 구해주는거
		System.out.println("str1의 길이 : " + str1.length());  //출력값 : 5 (문자가 5개니까!)
		
		//■toUpperCase() : 대문자로 변경해줘
		System.out.println("str1을 대문자로 변경 :" + str1.toUpperCase());
		
		//■toLowerCase() : 소문자로 변경해주는거야
		System.out.println("str2를 소문자로 변경 : " + str1.toLowerCase());
		
		//■substring() : 특정 문자 추출할때 사용해 (범위를 지정할수 있어)
		System.out.println("문자열 추출 1 : " + str1.substring(1));	//index 1부터 끝까지 추출 - pple  (index는 0부터 시작하니까)
		System.out.println("문자열 추출 2 : " + str1.substring(1, 3));		//index 1부터 3의 앞까지만 추출 
					//▶ a p p l e 
					//	 0 1 2 3 4
					// str.substring(1); → pple
					// str.substring)1,3); →pp
		
		
		//■CharAt() : 문자열에서 특정 문자 한글자만 추출 (딱 그 값만 가져와)
		System.out.println("문자열 추출 3 : " +  str2.charAt(3)); //index에 위치한 문자 추출
		System.out.println("문자열 추출 4 : " +  str2.substring(3, 4));	//index 3부터 4의 앞까지 추출
		
		//■indexOf() : 특정 문자의 존재여부 ▶ 존재 : index 값을 반환, 실패 : -1 
		System.out.println("문자열의 위치값을 알아보자 1 : " + str2.indexOf("L"));     //출력값 : 3 → index3에 위치
		System.out.println("문자열의 위치값을 알아보자 2 : " + str2.indexOf("B"));	   //출력값 : -1 → 존재하지 않는다. 그래서 못찾았다..!
		
		//■split() : 문자열을 분리 ▶결과는 항상 String[] 로 리턴된다.
		String[] sp1 = str1.split(""); //기준값을 안주면 걍 , 로 문자를 쪼개버려
		System.out.println("문자열 분리 1 :" + Arrays.toString(sp1));
		
		String str3 = "가나@다라@마바"; 
		String[] sp2 = str3.split("@"); 
		System.out.println("문자열 분리 2 :" + Arrays.toString(sp2));
		
		//■replace() : 문자열 치환(찾아 바꾸기)
		System.out.println("문자열 치환1 : " + str2.replace("P", "@@")); //P → @@ 
		System.out.println("문자열 치환2 : " + str2.replace("PP", "@@")); //PP → @@ 
		
		//■trim() : 좌우의 공백 제거
		String str4 = "   abc   def   ";
		System.out.println("str4 : " + str4);  //   abc   def   (원래는 뒤에도 3칸이 띄어져있어)
		System.out.println("str4.trim() : " + str4.trim()); //적용하면 좌우 만 제거!
		System.out.println("공백 제거 전 문자열의 길이를 뽑아줘 : " + str4.length()); //3+3+3+3+3 =15
		System.out.println("공백 제거 후 문자열의 길이를 뽑아줘 : " + str4.trim().length());  //.을 연속으로 찍어주면 왼쪽 3개 오른쪽 3개 결과만 보여줘!
		
		
	}//main()
}//class
