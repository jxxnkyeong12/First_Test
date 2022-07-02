import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		//ArrayList<> list 컬렉션 객체에 정수 10, 20,30,40,50을 저장(add())하고 출력(get())하시오 [어? 패턴 발생했네? 그럼 for문 돌리자]
		//ArrayList<Integer> list = new ArrayList<Integer>();		//일반적인 객체 생성방식 : is A ▶ A a = new A(); 스캐너스캐너 뉴 스캐너! 
		ArrayList<Integer> list = new ArrayList<>();				//생성자 메소드에서 타입에서는- 객체를 생성할때 '<~~>'을 생략 가능하다 할당되는 쪽에 만들어 놓으면 ㅇㅋㅇㅋ
		 
		
		for (int i = 1; i <= 5; i++) { //접근할 수 있는 list로 접근하자
			list.add(i*10);    //new Integer(i + 1) *10;  ▶ AutoBoxing : PDT, String Type
			
		}//for
		//■단순 for문 출력
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list["+i+"]의 값 : " + list.get(i));
		}
		
		System.out.println("==========================================");
		
		//■향상된 for문 출력
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		
		//■ 단순 for문, 향상된 for문 결과(출력문)는 똑같아- 
		System.out.println();
		System.out.println("==========================================");
		
		//■Boxing된 list 출력 [Boxing타입 - 기본데이터 타입과 String 타입만 가능 - 낯익은 모습 ArraytoString 형태가 나와]
		System.out.println("list<>의 값 : " +  list);
	}//main()
}//class
