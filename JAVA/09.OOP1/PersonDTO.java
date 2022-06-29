
public class PersonDTO {
	//① 멤버변수 선언 ▶ 정보은닉 : private
	
	private String name;	//이름
	private int age;		//나이
	private double height;	//키
	private double weight;	//체중	근데 위에랑 같은 타입이니까 , 찍고 한줄로 써도 돼
	private char gender;	//한글자니까 char 타입으로 줘도 돼 - 성별
	
	//② 디폴트 생성자 메소드 : 빈깡통
	

	
	//③생성자 메소드 초기화 : 자동완성
	public PersonDTO(String name, int age, double height, double weight, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}



	//④입력(setter),출력(getter) 메소드를 정의 : 멤버변수에 접근
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	
}
