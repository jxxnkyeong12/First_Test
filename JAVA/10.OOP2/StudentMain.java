import com.hanul.student.StudentDAO;
import com.hanul.student.StudentDTO;

public class StudentMain {
	public static void main(String[] args) {
	
		
		StudentDTO[] s1 = new StudentDTO[3];
		
		s1[0]=new StudentDTO("홍길동", 20220501, "컴공과", 95.4, 90.3);
		s1[1]=new StudentDTO("김길동", 20220502, "전산과", 85, 97.8);
		s1[2]=new StudentDTO("나길동", 20220503, "정통과", 80.7, 85.6);
		
		
		//StudentDAO 객체 생성 시 객체배열(student[])을 매개변수로 전달한 후 메소드 호출
		StudentDAO dao = new StudentDAO(s1);
		
		dao.getSum();		//총점
		dao.getAvg();	 	//평균
		dao.avgDescSort(); //평균의 내림차순
		dao.display();		//출력
		dao.avgAscSort();  //평균의 오름차순
		dao.display();		//출력
		dao.nameAscSort();  //이름의 오름차순
		dao.display(); 		//출력
		dao.nameDesSort(); //이름의 내림차순
		dao.display();		//출력
	}//main
}//class
