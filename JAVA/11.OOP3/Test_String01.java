public class Test_String01 {
	//주어진 문자형 숫자(str) 의 각 자릿수를 분리하여 합계(sum)을 구하시오.
	//예 : "12345" → 1+ 2 + 3 + 4 + 5 ▶ 15
	public static void main(String[] args) {
		String str = "12345";
		
		
		//split() - 쪼개면 배열로 만들어 , for문 접근, Integer.parseInt();
		String[] strs = str.split("");
		int sum = 0;
		for (int i = 0; i < strs.length; i++) {
			//sum += strs[i];   //sum += strs[i]; 이건 문자열인데 문자열은 더하기를 못하잖아 ㅠ 그래서 이 형식은 못써 Integer.parseInt(); 이걸로 변환!
			sum += Integer.parseInt(strs[i]);
		}//split
		
		
		//charAt(), for, length();
		int result = 0;
		for (int i = 0; i < strs.length; i++) {
			result += str.charAt(i) - '0'; //UniCode(ASCII Code) 참조 0을 빼줘야 제대로 값이 나와 
		}
		
		System.out.println("문자열 : " + str);
		System.out.println("자릿수 합계 : "  + sum);
		System.out.println("자릿수 합계 : " + result);
	}//main()
}//class
