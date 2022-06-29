//쓰레드는 우선순위(Priority)를 설정할 수 있다.
//1(최소,MIN_PROIORITY)부터 10(최대치, MAXPRIORITY)까지 설정
//숫자가 높을수록 우선순위가 높다

//기본값은 5(NORM_PRIORITY)로 설정되어 있다
//getPriority() : 우선 순위를 확인하고자 할때 (출력문)
//setPriority() : 우선 순위를 설정하고자 할때 (실행문)

public class Priority extends Thread{ //Thread Class상속
		@Override
		public void run() {
			for(int i = 1; i<=50; i++) {
				System.out.println(getName() + "우선순위 : " + getPriority() + ", Hello" + i);
				//Thread-N 우선순위 : X, Hello  + i
			}//for
		
		}

}//class
