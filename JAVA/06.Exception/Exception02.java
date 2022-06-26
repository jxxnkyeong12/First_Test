	public class Exception02 {
		public static void main(String[] args) {
		//준비단계 -> 가스불을 켠다 -> 요리시작 -> 요리 끝 - > 가스불을 잠근다 -> 종료
			try {
				System.out.println("준비단계");
				System.out.println("가스불을 켠다");
				System.out.println("요리 시작");
				//int result = 10/0;		//예외발생
				System.out.println("요리 끝");
				//System.out.println("가스불을 잠근다");
				//System.out.println("종료");
				
			} catch (Exception e) {
				System.out.println("예외발생!!!");
				//System.out.println("가스불을 잠근다");
				//System.out.println("종료");
			} finally {   //둘이 공통되는 것들 (무조건 실행돼)
				System.out.println("가스불을 잠근다");
				System.out.println("종료");
				
			}
			
			
			
			
		}//main()
}//class
