public class Exception04 {
	public static void main(String[] args) {
		//1부터 100까지의 누적합(sum)을 구하여 출력하시오 : for(반복)
		//단, 누적합이 512 이상이 되면, 계산을 중지하고 결과를 출력하시오 : if(조건), break(중지)
		int sum = 0;
		for (int i = 1; i<=100; i++) {
			sum += i;
			if(sum >=512) {
				System.out.println("누적합이 512 이상이 되었습니다.");
				System.out.println("누적합은 : " +  sum + ", i : " + i); //i가 몇일때 512에서 멈췄을까? 할때 이거 넣어주면 나와
				break;
			}//if
		}//for
		
		//try ~ catch 블록을 이용하여 예외처리 하시오 ▶ throw
		//throw : 강제로 예외를 발생시켜 catch 블럭으로 예외를 던진다(넘긴다)
		try {
			
			int total = 0;
			for(int i = 1; i <=100; i++) {
				total += i;;
				if(total >= 512) {
				 System.out.println("누적합은 : " +  sum + ", i : " + i); //i가 몇일때 512에서 멈췄을까? 할때 이거 넣어주면 나와
				 throw new Exception("누적합이 512 이상이 되었습니다");  //break; 키워드 대신 trow넣어줌 
				}//if
			}//for
			
		} catch (Exception e) {
			e.printStackTrace();  //예외를 상세하게 출력
			System.out.println(e.getMessage()); 	//예외 메세지만 출력 위에 있는 "누적합이 512 이상이 되었습니다" 끌고와
		}
	}//main()
}//class


/*
근데 이파트는 거의 쓴적 없어서... 패스해도 무관하다
*/