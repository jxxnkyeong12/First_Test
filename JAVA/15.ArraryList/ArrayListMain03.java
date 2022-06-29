import java.util.ArrayList;


public class ArrayListMain03 {
	public static void main(String[] args) {
		//ArrayList<> list 컬렉션 객체에 정수 10, 20,30,40,50을 저장(add())하고 출력(get())하시오
		//ArrayList<Object> list = new ArrayList<Object>();  //Object : 타입비교 (instanceof) 후 Casting 필요
		
		ArrayList<Integer> list = new ArrayList<Integer>(); 	//Integer 타입으로 제한
		
		list.add(new Integer(10)); //정상적인 구형방식
		list.add(new Integer(20)); // new 키워드로 객체화
		list.add(30);				//int → Integer 자동변환해줘 ▶ AutoBoxing [자동으로 integer라는 상자에 담아넣겠다]
		list.add(40);				//컴파일러(JVM)가 자동으로 처리해줘!
		list.add(50);				//기본 데이터 타입(PDT), String Type만 가능
		
		System.out.println((Integer)list.get(0)); //get 0번지! - [방법 ①]Casting 후 출력			
		System.out.println((Integer)list.get(1)); //get 1번지! - 이게 정상적인 구현 방식이야
		System.out.println(list.get(2));			//[방법 ②]Casting할 필요 없이 원래의 타입으로 변환 ▶ AutoUnBoxing : 값을 바로 입력하자 
		System.out.println(list.get(3));			//			근데 무조건 다 되는게 아니라 기본데이터 타입과 String 타입만 가능해
		System.out.println(list.get(4));
		
		
		
	}//main()
}//class
