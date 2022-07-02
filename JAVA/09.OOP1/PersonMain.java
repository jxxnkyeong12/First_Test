public class PersonMain {
	//3명의 개인정보(이름, 나이, 키, 체중, 성별 ▶ PersonDTO.java)를 저장할
	//객체배열(person[])을 선언 및 생성하고 값을 할당
	public static void main(String[] args) {
		PersonDTO[] person = new PersonDTO[3];
		person[0] = new PersonDTO("홍길동", 33, 175.5, 77, '남');
		person[1] = new PersonDTO("박문수", 30, 180, 65.5, '남');
		person[2] = new PersonDTO("성춘향", 28, 165, 48.5, '여');
		
		//메소드 호출
		PersonDAO dao = new PersonDAO();
		dao.display(person);	//출력
		dao.ageAscSort(person); //나이의 오름차순 정렬
		dao.display(person);    //출력
		dao.heightDescSort(person);
		dao.display(person);
	}//main()
}//class
