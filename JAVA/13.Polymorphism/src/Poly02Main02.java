import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main02 {
	public static void main(String[] args) {
		Dog dog = new Dog();		//1.일반적인 객체 생성 방법
		Cat cat = new Cat();		//일반적인 객체 생성. 지금껏 해온 방법
		
		Poly02Main02 poly = new Poly02Main02();  //2. 객체생성
		//poly.display(dog);  	//3.메소드 호출 : 실인수
		//5.poly.display(cat)을 그냥 넣어주면 오류가 나. 왜? 맨 처음 display는 Dog dog로 해둬서야!
		//  그래서 오류를 고쳐 주려면 그 밑에 따로 display(Cat cat)을 만들어 줘야해

		poly.display(cat);	//
		
		
	}//main()					
	 /*
	  public void display(Dog dog) { //메소드 정의 : 가인수 ▶ Dog → Animal 
	   dog.cry(); //③이렇게 하면 일일이 위에 다 넣어줘야 한다는 불편함이 있어.. 그래서 공통된 부모쪽으로 넘겨줘
	  }//display
	 
	  public void display(Cat cat) { //메소드 정의 : 가인수 ▶ Cat → Animal /6.둘다  Animal이니까! 바꿔주자!
	   cat.cry();
	  }//display
	 	*/
	
	public void display(Animal animal) {		//4.메소드 정의 : 가인수 ▶ 다형성 인수/  7.Animal animal 이렇게 해줘!
		animal.cry();
		//animal.night();						//9.오류 : Animal 클래스에는 night() 메소드가 없다.
		//((Cat) animal).night();					//10.DownCasting/ 예외가 발생해버려 Dog해놓고 Cat으로 바꾸려니까 멍멍만 나오고 밑으론 에러가 나지!
		//Cat Class Type 으로 인수값이 전달된 경우에만 night() 메소드가 동작 ▶ Type 비교 : instanceof
		if(animal instanceof Cat) {			//instanceof : 타입(클래스)을 정확하게 비교한다  Dog와 Cat은 같니? - false ->Dog 동작 안돼. 
			((Cat) animal).night();			//   		   다시 Cat과 Cat이 같니? - true
			
		}//if
	}//display()
}//class
