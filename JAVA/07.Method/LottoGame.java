import java.util.Arrays;
import java.util.Random;

public class LottoGame {
	//메소드(getNumber()) 호출
	
	public static void main(String[] args) {
		LottoGame game = new LottoGame();	//ⓐ sumMachine에서 왔슴다. 밑에 static없애고 싶으면 이거 해주고
	 for (int i = 0; i<5; i++) {          //맨 마지막에 하는 단계! 5줄 나오게 하는 거 
		int[] lotto = game.getNumber();    //①   ⓑ for문에 get.~이걸 넣어버리면 계속 돌아버려서 여기다가 만들어줘
		System.out.println(Arrays.toString(lotto));  
		
	   }//for
	 	
	}//main()
	
	//번호 생성 후 결과를 리턴하는 메소드 정의
	public int[] getNumber() {
		int[] lotto = new int[6];	//번호가 저장될 배열 선언 및 생성
		Random random = new Random(); 	//무작위로 번호를 생성하기 위한 Random 객체 생성
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(45)+1; 	//0~45개의 정수를 무작위로 만들어 준다 근데 뒤에 +1해줘야 1~45개!
			for(int j = 0;  j< i; j++) {		//번호 중복검사
				if(lotto[i] == lotto[j]) {
					i = i-1; //i -=1; //다시i 값 뽑게하고 브레이크 걸자
					break;
				}//if
				
			}//for
		}//for
		Arrays.sort(lotto);  //배열(lotto[])의 원소값을 오름차순으로 정렬
		return lotto;
	}//getNumber
	
}//class
