public class PersonDAO {
	//출력 메소드
	public void display(PersonDTO[] person) {
		System.out.println("=====================================");
		System.out.println("이름\t나이\t키\t체중\t성별");
		System.out.println("=====================================");
		for (int i = 0; i < person.length; i++) {
			System.out.print(person[i].getName() + "\t");
			System.out.print(person[i].getAge() + "\t");
			System.out.print(person[i].getHeight() + "\t");
			System.out.print(person[i].getWeight() + "\t");
			System.out.print(person[i].getGender() + "\n");
		}
		System.out.println("===========================================");
	}//display()
		
	//나이의 오름차순 정렬
	public void ageAscSort(PersonDTO[] person) {
		for (int i = 0; i < person.length; i++) {
			for (int j = i+1; j < person.length; j++) { //j값을 무조건 i+1로 바꿔줘!
				if(person[i].getAge() > person[j].getAge()) {		//알고리즘 프로젝트에서 사용되는 오름차순! i쪽으로 가면 오름차순!
					PersonDTO temp = person[i]; //위에 보면 personDTO로 만들었잖아 그니까 temp타입은 PersonDTO로 해줘
					person[i] = person[j];
					person[j] = temp;
				}//if
			}//for j
		}//for i
		
	}//ageAscSort()
	
	//키의 내림차순 정렬
	public void heightDescSort(PersonDTO[] person) {
		for (int i = 0; i < person.length; i++) {
			for (int j = i+1; j < person.length; j++) {
				if(person[i].getHeight() < person[j].getHeight()) {
					PersonDTO temp = person[i];
					person[i] = person[j];
					person[j] = temp;
				}//if
			
			}//for j
		}//for i
		
	}//display


	
}//class
