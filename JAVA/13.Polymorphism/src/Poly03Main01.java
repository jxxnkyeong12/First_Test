import com.hanul.poly03.Radio;
import com.hanul.poly03.RemoCon;
import com.hanul.poly03.Tv;

public class Poly03Main01 {
	//Tv Radio 소리를 올리고 내린후에 인터넷에 접속하시오
	public static void main(String[] args) {
		//① UpCasting
		RemoCon remoCon = new Tv();  //부모쪽으로 객체 생성
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
		System.out.println("①========================");
		
		remoCon = new Radio();
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
		System.out.println("②========================");
		
		//② 다형성 인수로 처리해보자 : 일반적인 방식으로 객체 생성
		Tv tv = new Tv();
		Radio radio = new Radio();
		
	
		Poly03Main01 poly = new Poly03Main01();
		poly.play(tv);
		poly.play(radio);
		System.out.println("③========================");
		//③ 다형성 배열 : 일반적인 방식으로 객체 생성
		RemoCon[] remoCons = {tv, radio};
		for (int i = 0; i < remoCons.length; i++) {
			remoCons[i].volUp();
			remoCons[i].volDown();
			remoCons[i].internet();
		}
	}//main()

	private void play(RemoCon remoCon) {  
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
	}//play()
		
}//class
