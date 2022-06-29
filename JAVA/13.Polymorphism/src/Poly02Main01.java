

import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main01 {
	public static void main(String[] args) {
		//Dog 객체를 생성 : UpCasting ▶ 객체를 생성할 때 상위클래스(부모) 쪽으로 생성
		Animal animal = new Dog(); 
		animal.cry();
		
		
		//Cat 객체를 생성 : UpCasting ▶ 객체를 생성할 때 상위클래스 쪽으로 생성
		animal = new Cat();
		animal.cry();   //cry 이가 Cat으로 작동되니까! animal을 Cat으로 다시 바꿔주는거야 
		((Cat)animal).night(); //DownCasting :UpCasting 했던 것을 다시 원래 타입으로 돌려놓는다!
	}//main()
}//class
