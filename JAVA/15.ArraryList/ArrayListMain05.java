
import java.util.ArrayList;

public class ArrayListMain05 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(); //너는 무조건 String타입만 받아라 
		
		list.add(new String("AAA")); 	//정상적인 구현방식
		list.add("BBB");  				//AutoBoxing ->type이 String이니까! 가능해~
		list.add("CCC");
		System.out.println(list);      //출력값 [AAA, BBB, CCC]
		
		list.add(1, "DDD");				//오버로딩으로 인덱스를 추가!! index 위치값에 값이 저장되고, 기존값은 자연스럽게 뒤로 이동! 
		System.out.println(list);		//출력값 [AAA, DDD, BBB, CCC]
		
		list.set(1, "EEE"); 			//index 위치값이 수정
		System.out.println(list);       //출력값 [AAA, EEE, BBB, CCC]
		
		list.remove(1);					//index에 위치한 값이 삭제 된다. 뒷쪽의 값이 앞으로 이동된다
		System.out.println(list);		//출력값 [AAA, BBB, CCC]
		
		list.removeAll(list);			//list의 전체값이 삭제
		System.out.println(list);      //출력값 [] 
	
 	}//main()
}//class
