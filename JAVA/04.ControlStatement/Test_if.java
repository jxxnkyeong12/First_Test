public class Test_if {
	public static void main(String[] args) {
		//점수(score)가 90점 이상이면 'A학점', 80점 이상이면 'B학점'
		//70점 이상이면 'C학점', 60점 이상이면 'D학점', 그외에는 'F학점'
		
		int score = 80;
		if(score >= 90) {
			System.out.println(score + "점은 " + "A학점 입니다." );
		}else if(score >= 80) {
			System.out.println(score + "점은 " + "B학점 입니다.");
		}else if(score >= 70) {
			System.out.println(score + "점은 " + "C학점 입니다");
		}else if(score >= 60){
			System.out.println(score + "점은 " + "D학점 입니다.");
		}else {
			System.out.println(score + "점은 " + "F학점 입니다.");
		}
		
		
		
	}//main()
}//class
