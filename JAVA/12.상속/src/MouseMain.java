import com.hanul.mouse.Mouse;
import com.hanul.mouse.OpticalMouse;
import com.hanul.mouse.WheelMouse;

public class MouseMain {
	public static void main(String[] args) {
		System.out.println("Mouse Class");
		Mouse m = new Mouse(); 	//Mouse 객체 생성
		m.clickLeft();			//clickLeft() 메소드 호출
		m.clickRight();			//clickRight() 메소드 호출
		System.out.println("==============================");
		
		System.out.println("WheelMouse Class");
		WheelMouse wm = new WheelMouse();
		wm.clickLeft(); 	//상속받은 상위클래스(Mouse)의 메소드 호출
		wm.clickRight();  	//상속받은 상위클래스(Mouse)의 메소드 호출
		wm.scroll(); 		//자기 자신(WheelMouse)의 메소드 호출
		System.out.println("==============================");
				
		System.out.println("OpticalMouse");
		OpticalMouse om = new OpticalMouse();  //OpticalMouse 객체 생성	
		om.clickLeft();
		om.clickRight();
		om.scroll();
	}//main()
}//class
