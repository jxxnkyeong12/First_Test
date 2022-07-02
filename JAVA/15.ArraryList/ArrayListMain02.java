import java.util.ArrayList;

import com.hanul.array.Test;

public class ArrayListMain02 {
	public static void main(String[] args) {
		//ArrayList<> 컬렉션이라는 객체(이름을 list로 준 객체)를 생성하겠다 → 무엇을 쓸지 모를때 무조건 Object Type : 모든 객체 다 받아 준다
		ArrayList<Object> list = new ArrayList<Object>();// <E>아직 몰라요! 그럼 Object를 줘!
		list.add(new Integer(100));   //Element(요소)는 반드시 클래스 타입만 허용한다. ▶ 객체화  [9버전이후부턴 이렇게 안해도 돼 근데 이게 원칙이긴 해!]
		list.add(new String("Apple")); 
		list.add(new Test());
		
		for (int i = 0; i < list.size(); i++) {  //[동작을 시켜보자 - for로 접근] 
			Object object = list.get(i);   //list라는 컬렉션 배열에 i번째 인덱스[리터럴] 값을 가져온다 - 근데 값을 모르겠다 그러면 Object Type으로 받아준다 [근데 이렇게 해버리면 어디서 도는지 몰라]
			
			if (object instanceof Integer) { 			 //object 타입이 integer이면 [instanceof - object타입이 Integer 타입이냐 비교]
				System.out.println((Integer)object);	//Integer 타입으로 Casting 한후에 값을 출력
				
 			}else if(object instanceof String) {		//object의 타입이 String 타입이면
 				System.out.println((String)object); //String 타입으로 Casting 한 후에 object값 출력
 				
 			}else if(object instanceof Test) {	//object 타입이 Test이면
 				((Test)object).display();		//Test 타입으로 Casting 한후에 값을 출력(display)
 			}//if
		}//for
		System.out.println("==============================");
		
		//ArrayList<> 컬렉션 객체 생성(list2<>) : 특정 클래스(Test.Java)만 저장하기 위해 타입에 제한을 걸고 쓰는게 더 나아.
		ArrayList<Test> list2 = new ArrayList<Test>();  //얘는 이제 Test만 만들어야 해 무조건. integer String이런거 안돼
		list2.add(new Test());
		//list2.add(new String("Apple")); //바로 오류가 돼. why? 나는 String 을 쓰고 싶으면 컬렉션을 새로 만들면 돼
		
		list2.get(0).display();  //add가 1개밖에 없으니 1개의 출력문만 나와
		
	}//main()
}//class
