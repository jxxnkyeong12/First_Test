import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception_Try_Catch01 {
	public static void main(String[] args) {
		//3개의 길이(크기)를 갖는 정수형 배열(arr[])을 선언 및 생성한 후, 
		//임의의 값(10, 20, 30)을 할당하고 출력
		int[] arr = new int[3];	    //배열의 선언 및 생성
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//arr[3] = 40;   //ArrayIndexOutOfBoundsException :배열을 벗어났다. 미확인 예외
		
		System.out.println("arr[0]의 값 : " +  arr[0]);
		System.out.println("arr[1]의 값 : " +  arr[1]);
		System.out.println("arr[2]의 값 : " +  arr[2]);
		//System.out.println("arr[3]의 값 : " +  arr[3]);
		
		//String str1 = 100;	// 에러 
		String str1 = "100";	//문자 100을 초기화
		System.out.println("str1의 값 : " + str1);
		int pstr1 = Integer.parseInt(str1); //문자 100을 정수 타입으로 변환
		System.out.println("pstr1의 값 : " + pstr1);
		
		String str2 = "100a";
		System.out.println("str2의 값 : " + str2);
		//int str2 = Integer.parseInt(str2);
		//System.out.println("patr2의 값 : " + pstr2);
		//NumberFormatException : 미확인 예외
		
		int x = 10;
		int y = 0;
		System.out.println("y/x :" + (y/x));	//출력값 : 0
		//System.out.println("x/y : " + (x/y)); 	//ArithmeticException: 미확인 예외(수학적 오류가 나서)
		
		//"abc.txt" 파일을 읽어들이시오 :FileInputStream Class ▶확인예외 (코드 입력하자마자 밑에 빨간줄 뜨는거- 통상)
		try {
			FileInputStream fis = new FileInputStream("abc.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 		//예외가 발생한 시점을 메모리에서 추적하여 상세하게 출력
			System.out.println(e.getMessage());		//예외메세지만 간략하게 출력
			System.out.println("해당 파일이 존재하지 않습니다!");	//예외 메세지를 직접 작성해서 출력
		} 
		
		/* ★★★★★★★★
		  try {
		  	예외가 발생할 가능성이 있는 코드(정상코드)
		  } catch(Exception e) { 
		  	예외가 발생할 시 처리할 코드(대안코드)
		  } finally { ▶ 생략가능 
		  	무조건 실행되어야 할 코드
		  }
		  
		  
		 */
	}//main()
}//class










