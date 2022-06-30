package student;

import java.util.ArrayList;

public class StudentDAO {

	//ArrayList<StudentDTO> 를 10건 리턴하는 메소드 작성
	//getManualList();
	
	
	//접근제한자 리턴타입 메소드 이름() {}
	public ArrayList<StudentDTO> getManualList(){
		ArrayList<StudentDTO> list  = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) { //지금은 선생님이 10건을 줬으니까 size() 
			list.add(new StudentDTO("김", "진", "1234", i));
		}
		
		//null.add <= nullPointer X
		//list.add
		
		
		return list;
	}//
	
	
}
