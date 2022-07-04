import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


			//■put으로 밀어넣고 get으로 빼오고 90%는 이거 쓰고 밑에 set keyset으로 써. 공부할껀 위에꺼다!■
public class Ex04_HashMap {
public static void main(String[] args) {
	
	ArrayList<String> list = new ArrayList<String>();  //1.
	for(int i = 0; i <10 ; i++) { //2.
		list.add("중복");
	}//for
		System.out.println(list.size()); //3.
	//4.ArrayList 중복 된 데이터를 허용함. 사이즈가 10개 나와. 사이즈 체크해보기
		//6. <k, v> 제네릭은 컴마로 구분한다. ArrayList Object Element만 넣을수 있음
		//7.ke, value 요소(객체, 클래스 타입)만 사용할수가 있음
	
		//5-1.hash 맵의 초기화할 준비를 함!
		HashMap<String, String> map = new HashMap<String, String>(); //5.
		map.put("키", "값");  //8.map에다가 데이터를 넣는거put!이란 메소드를 이용한다. -파라매터로 스트링을 두개 입력받아. 결국엔 메소드라고 생각해
		for(int i = 0; i <10 ; i++) { //12.
			map.put("키"+i, "중복"); //15. 이번엔 키에 +i값을 넣어서 엔트리 수가 많이 나오게 할거야 ■근데 이런경우는 어레이리스트 써~ 걍 있다고 보여주시는거
			//13.oracle 컬럼이름, 값 이랑 같은거랭.  
		}//for
		
		
		System.out.println("맵의 크기(엔트리 수) : " + map.size());//9.맵 크기를 몇인지 출력해보자 당연히 1이 나온다. //Entry(엔트리) 하나의 아이템(고유값과 값을 가진)
									//10.엔트리가 몇개 있냐 ==중복되지 않은 데이터를 몇개 가지고 있냐. 란 의미
		System.out.println(map.get("키")); //11.여기엔 인덱스가 없어. 키가 인덱스가 되는거야. 그래서 뺄때는 "키"값을 넣어주면 "값"이란 문자열이 출력되어야해
		//14. JSONObject == 구조 (Json으로 이동해야하는 데이터가 있을 때 HashMap을 이용하면 간편함) hashMap과 제이슨 오브젝트는 key value가 있구나, 비슷하구나 하고 알면 돼 
		
		//Index에 접근해서 모든 객체에 접근할때는 HashMap보다는 ArrayList를 사용.
		
		//따라서 치고 넘어가도 되는 부분 ↓
		// HashMap은 내부에 Keyset<= 키모음 키끼리 비교해서 중복되면 확인처리하기 위한 객체
		Set<String> keySet= map.keySet(); //셋이라는 부모 인터페이스 에다가 map.에서 keyset key모음을 받아 올수 있다
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) { //■keyIterator■: 데이터가 있어야 다음칸으로 넘어갈수 있어. 그럼 체크하는게 true! keyIterator가 넘어가려는데 다음칸이 없다? 예외떠버려
			String key = keyIterator.next(); //hasNext : 돌다리 두드려 보는 지팡이 역할!
			String value = map.get(key);
			System.out.println("key : " +  key + " value : " + value);
		}//while
	}//main()
	
}//class
