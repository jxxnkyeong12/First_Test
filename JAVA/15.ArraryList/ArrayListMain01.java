import java.util.ArrayList;
import java.util.Arrays;

import com.hanul.array.Test;

public class ArrayListMain01 {
	public static void main(String[] args) {
		//3개의 크기(길이)를 갖는 정수형 배열(arr[])을 선언 및 생성하시오.
		int[] arr = new int[3];
		
		//배열(arr[])에 10,20,30d이라는 값을 할당하시오
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;  //패턴발생..! 10씩
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i+1) *10;
		}//for
		
		
		//■배열(arr[])의 내용을 출력하시오.
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"]의 값 : " + arr[i]);
		}
		System.out.println("arr[]의 값 : "+ Arrays.toString(arr));  //static 관련 메소드라 toString을 객체화 시키지 않아도 바로 사용할 수 있다. (arr)- 식별자!
	
		
		System.out.println("===========================================");
		
		//■Test.java 타입 5개를 저장할 수 있는 배열(test[])을 선언 및 생성 : com.hanul.array package
		Test[] test = new Test[5];  //배열의 선언단계 test는 이름이야~  String[] strs = new String[5]; 배열 생성! 근데 꼭 길이값을 줘야해
																	//  Type []   id  = new Type[num];
		for (int i = 0; i < test.length; i++) { // 객체화 시켜서 접근해야 - 근데 위에보면 arr이를 배열로 [] 다 이렇게 정리해놨는데. 이걸 하기 싫으니까 for문을 돌려서 코드 길이를 줄일 수 있다!
			test[i] = new Test(); //객체를 생성한거야 시킨거야
			
		}
		
		for (int i = 0; i < test.length; i++) {
			test[i].display(); //test i 번지야 display해줘
		}
		System.out.println("===========================================");
		
		
		//■Test.java 타입을 갖는 크기(길이)에 제한 없는 컬렉션 배열(무한배열) 생성해라▶ ArrayList<>
		ArrayList<Test> list = new ArrayList<Test>(); //Resizable 길이에제한 x! <E>! E가 요소값! type은 클래스로 써! 객체화 되었다!
		list.add(new Test()); //add():삽입메서드  -길이가 1개 들어온거야 클래스 생성
		list.add(new Test()); //add():삽입  -길이가 2
		list.add(new Test()); //add():삽입  -길이가 3
		list.add(new Test()); //add():삽입  -길이가 4
		list.add(new Test()); //add():삽입  -길이가 5
		for (int i = 0; i < list.size(); i++) { 	////size() : ArrayList<> 크기(길이) 값을 구해주는 메소드   [배열은 for문으로 접근하니까 for문 돌력! length가 아니라 !]
			list.get(i).display();					//get() : 출력(가져온다) [list i번지 값을 가져오겠습니다.그리고 display하겠습니다.]
				
		}
	
	}//main()
	
}//class




/*

○ Array [] : 배열
	- 순차적(index)으로 어떤 자료를 저장한다. 
	- 자료의 타입이 동일해야 된다.
	- 배열의 크기(길이)를 먼저 선언해야 된다.
	- 배열의 생성 단계에서 객체화 되어야 한다. ▶ new란 키워드 활용 
	- 주요한 키워드 : length → 배열의 크기 (길이)를 구해주는거 ▶ 단순 for문으로 접근한다  



○ ArrayList <> : 컬렉션 자료구조(무한배열)
	- 순차적(index)으로 어떤 자료를 저장한다.
	- 자료의 타입이 달라도 된다(단, 클래스 타입만 저장된다)
	- 배열의 크기(길이) 선언하지 않는다.
	- 배열의 생성 단계에서 객체화 되어야 한다. ▶ new란 키워드 활용
	★★- 주요한 메소드 : size() → 길이/ add() → 삽입/ get() → 출력 / 
		                  set() → 입력된 데이터 값을 수정할 수 있어./ remove() → 삭제 ▶ 향상된 for문

*/