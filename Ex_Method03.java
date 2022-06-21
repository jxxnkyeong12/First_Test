public class Ex_Method03 {
	public static void main(String[] args) {
		getSum(10,20);		//getSum(int, int) 메소드 호출
		System.out.println("===================");
		
		getSum(10,20, 30); 		//getSum(int, int, int) 메소드 호출
		System.out.println("===================");
		
		getSum(10.5, 20.7);   	//getSum(double, double) 메소드 호출
		System.out.println("===================");
		
		
		getSum(10, 10.5);		//getSum(int, double) →getSum(double, double) 
								//밑에 더블더블이 이미 만들어져 있고 double안에 int가 있으니까 이렇게 만들어도 빨간밑줄 안들어와
								//이것만 만들고 바로 실행시켜 보면 consol에 나와. 
	}//main()
	//getSum(int, int) 메소드 정의
	public static void getSum(int x, int y) {
		System.out.println("첫 번째 인수 : " + x);
		System.out.println("두 번째 인수 : " + y);
		System.out.println("두 인수의 합 : " + (x+y));
	}//getSum
	//getSum(int, int, int) 메소드 정의 -오버로딩 발생
	public static void getSum(int x, int y, int z) {
		System.out.println("첫 번째 인수 : " + x);
		System.out.println("두 번째 인수 : " + y);
		System.out.println("세 번째 인수 : " + z);
		System.out.println("세 인수의 합 : " + (x+y+z));
	}//getSum()
	public static void getSum(double x , double y) {
		System.out.println("첫 번째 인수 : " + x);
		System.out.println("두 번째 인수 : " + y);
		System.out.println("세 인수의 합 : " + (x+y));
	}//getSum()
}//class
