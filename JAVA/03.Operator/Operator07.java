public class Operator07 {
	public static void main(String[] args) {
		//Escape Sequence : 프로그램에서 사용되는 특수기호 연산자 ▶ 출력문
		//역슬래쉬(\, ￦)를 먼저 입력하고 사용한다.
		System.out.println("1. HelloWorld");
		System.out.println("2. Hello" + "\t" + "World");	//\t :Tab → 일정간격을 띄어쓰기(8칸)
		System.out.println("3. Hello\tWrold"); //문자열 출력문 안에 연결해서 사용가능
		System.out.println("4. Hello" + "\b" + "World");   //\b: Back Space 지우개~
		System.out.println("5. Hello" + "\r" + "World");   //\r: Carriage Return(행의 처음으로 커서를 이동)
		System.out.println("6. Hello" + "\n" + "World");   //\n: New Line (줄바꿈, Line Feed)
		System.out.println("7. Hello" + "\'" + "Wolrd");   //\': 홑따옴표를 표시
		System.out.println("8. Hello" + "\"" + "Wolrd");   //\": 쌍따옴표를 표시
		System.out.println("9. Hello" + "\\" + "Wolrd");   //\\: 역슬래쉬 기호를 표시
		
		System.out.println("번호" + "\t" + "이름" + "\t" + "주소");
		System.out.println("1" + "\t" + "홍길동" + "\t" + "광주광역시 서구 농성동");
		System.out.println("100" + "\t" + "박문수" + "\t" + "광주시 서구 경열로 3");
		
		System.out.println("나는 자바를 공부하고 있습니다!");
		System.out.println("나는 '자바'를 공부하고 있습니다!");
		System.out.println("나는 \'자바\'를 공부하고 있습니다!");
		System.out.println("나는 " + "\'자바\'" + "를 공부하고 있습니다!");
		
		
	}//main()
}//class
