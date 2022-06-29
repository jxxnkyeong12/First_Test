import com.hanul.animal.Cat;	//하드코딩해버리면 dog, cat 에 빨간줄 나와. 방법 ① 마우스 올리면 import하겠슴다 누르면 돼. ②Ctrl + Shift + o 누르면 알아서 찾아와
import com.hanul.animal.Dog;

public class AnimalMain {
	public static void main(String[] args) {
		Dog dog = new Dog("멍멍이", 3);		//Dog 객체를 생성하고 초기화
		Cat cat = new Cat("야옹이", 2);		//Cat 객체를 생성하고 초기화
		
		System.out.println("강아지 이름 : " + dog.getName() + "\t나이 : " + dog.getAge());
		System.out.println("고양이 이름 : " + cat.getName()+ "\t나이 : " +  cat.getAge());
		
		dog.setName("방울이");
		dog.setAge(5);
		System.out.println("강아지 이름 : " + dog.getName() + "\t나이 : " + dog.getAge());
	}//main
}//class
