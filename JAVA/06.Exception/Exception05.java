import java.io.FileInputStream;

public class Exception05 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("abc.txt");
		
		
		
	}//main()
}//class

/* ★
 ○ throws (throw는 넘겨도 되지만 이건 넘기지마!)
 	- 예외를 처리하는 방법
    - 예외를 회피(예외 미루기)
    - try ~ catch 블럭을 사용하지 않는다.
    - 메소드 선언부에 사용
    	예)  public void xxx(){ ~~body(try_catch)~~} 
    	  	 → public void xxx()throws ○○○Exception, □□□Exception{~~body~~}
 
 */

