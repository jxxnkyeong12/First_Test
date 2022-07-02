
import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main03 {
	public static void main(String[] args) {
		Dog dog = new Dog();		//일반적인 객체 생성 방법
		Cat cat = new Cat();
		
		//생성된 객체를 배열에 초기화 하시오 ▶ 타입[] 식별자 = {~~~~~};
	Animal[] animals = {dog,cat};
		//배열에 등록된 원소의 항목(원소값)의 메소드를 호출(동작)
		for (int i = 0; i < animals.length; i++) {
			animals[i].cry();
			if (animals[i] instanceof Cat) {
				((Cat)animals[i]).night();
			}//if
		}//for
		
	}//main
}//class
