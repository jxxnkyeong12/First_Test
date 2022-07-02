import java.util.Arrays;

public class Test_String02 {
	//TAB("\t")을 기준으로 문자열을 분리하고 리턴하는 메소드 호출 : getSplit()이라는 메소드로 호출할거야
	//리턴받은 배열(String[] fruit)을 출력하는 메소드 호출 : display()
	//과일명의 내림차순으로 정렬하는 메소드를 호출해라 : nameDescSort()
	public static void main(String[] args) {
		String str = "포도\t오렌지\t수박\t복숭아\t사과\t파인애플";
		
		//String[] fruit = str.split("\t"); 
		//System.out.println("과일명 : " + Arrays.toString(fruit));
		
		Test_String02 test = new Test_String02();
		String[] fruit = test.getSplit(str); //String []타입으로 받겠다. 무엇을? fruit을! 내가 만든게 아니라 선생님이 일단 깔아주신거
		test.getSplit(str);
		test.display(test.getSplit(str)); //연쇄! 한번에 코드 연쇄시킨걸 보여주신거야. 꼭 써야 하는게 아니라 여러가지 방법이 있다! 하면서 보여주신거!
		test.nameDescSort(fruit);
		
	}//main()
	
	//문자열을 분리하고 리턴하는 메소드 정의: split
	public String[] getSplit(String str) {
		//String[] fruit = str.split("\t");
		return str.split("\t");
		
	}//getSplit()
	
	//출력 메소드 정의
	public void display(String[] fruit) {
		System.out.println("과일명 : " + Arrays.toString(fruit));
	}//display
	
	//과일명의 내림차순 정렬하는 메소드 정의
	
	public void nameDescSort(String[] fruit) {
		for (int i = 0; i < fruit.length; i++) {
			for (int j = i+1; j < fruit.length; j++) {
				//if(fruit[i] < fruit[j])) ▶오류 : 문자열은 비교연사자를 사용할 수 없다.
				if(fruit[i].compareTo(fruit[j]) < 0 ) {
					String temp = fruit[i];
					fruit[i] = fruit[j];
					fruit[j] = temp;
				}
			}//for j
		}//for i
	}//nameDescSort()
}//class
