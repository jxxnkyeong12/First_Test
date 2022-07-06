package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.util.ArrayList;


public class StudentDAO {
	
	//수동으로 데이터 입력
	public ArrayList<StudentDTO> getManualList() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();	
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("Hansol", "hhhsss", "ssssss", "hs", "shin", i));
		}//for
		return list;
	}//getManualList()
	
	//오라클 연결
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	StudentDTO dto = new StudentDTO();
	
	//getConn()
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String pw = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return conn;
	}//getConn()
	
	//dbClose()
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}//if
				
			if(ps != null) {
				ps.close();
			}//if
		
			if(conn != null) {
				conn.close();
=======
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



public class StudentDAO {

	
	
	 Connection conn; 
	 PreparedStatement ps ; 
	 ResultSet rs; 
	StudentDTO dto  = new StudentDTO(); 
	 //ArrayList<StudentDTO> 를 10건 리턴하는 메소드 작성
	//getManualList();
	
	
	//접근제한자 리턴타입 메소드 이름() {}
	
	//getConn(), dbClose()
	//를 여기 프로젝트에 가져와서 연결이 되는지 확인하고 dbClose해보기
	
	public Connection getConn() { 
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password); 
		} catch (Exception e) {  
			e.printStackTrace();
			System.out.println("getConn Error !");
		}//try
		return conn;
	}//getConn
	
	
	public void dbClose() {
		try {
		 if(rs !=null) {
			rs.close();  
			}//if
		 if(ps !=null) {  
			ps.close();	
			}//if
		 if(conn != null) {
			conn.close();	
>>>>>>> 84d3a69ade1cfcbf9a17281e4d57b761b1f78cc3
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
<<<<<<< HEAD
	}//dbClose()
	
	public void selectOne() {
		getConn();
		String sql = "SELECT 1 as num1  FROM dual";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				//1 출력
				System.out.println(rs.getInt("num1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//try
	}//selectOne()
	
	//실제 있는 데이터를 가져오는 getList라는 메소드를 만들고 해당하는 메소드를 이용해서 활용하기
	//(학생번호, 학생이름, 아이디, 이름, 성)
	public ArrayList<StudentDTO> info() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		getConn();
		String sql = "select u.student_no, u.user_id, u.user_pw, u.first_name, u.last_name, student_name from user_info u LEFT OUTER JOIN student s ON u.student_no = s.student_no";
=======
   }//dbClose()
	
	
	 public void selectOne() {
		 getConn();
		 String sql = "SELECT 1 as num1 FROM dual ";
		 try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("num1")); //as num1 안해도 나오긴 한다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		 
	 }
	 
	public ArrayList<StudentDTO> getManualList(){
		ArrayList<StudentDTO> list2  = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) { //지금은 선생님이 10건을 줬으니까 size() 
			list2.add(new StudentDTO(i, "a", "b", "c", "d"));
		}
		
		//null.add <= nullPointer X
		//list.add
		return list2;
	}//
	//실제 있는 데이터를 가져오는 getList라는 메소드를 만들고 해당하는 메소드를 이용해서
	//실제 데이터를 활용하기
	
	public ArrayList<StudentDTO> getList( ) {
		ArrayList<StudentDTO> list = new ArrayList<>();
		getConn();
		String sql = "SELECT u.*, student_name FROM STUDENT s Right OUTER JOIN User_info u ON u.student_no = s.student_no ";
>>>>>>> 84d3a69ade1cfcbf9a17281e4d57b761b1f78cc3
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
<<<<<<< HEAD
			while(rs.next()) {
				StudentDTO dto = new StudentDTO(rs.getString("student_name"), rs.getString("user_id"), rs.getString("user_pw"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("student_no"));
				list.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
		return list;
	}//info()

	//데이터베이스에 접근해서 학생 한 명의 정보를 얻어오는 비즈니스로직을 구현(데이터 한 건 얻어오기)
	//HttpServletRequest request = Controller.req; 는
	//String a = Controller.""; 와 같다
	//String student_no, user_id; 쓰는 것을 더 추천한다!!!!!!!!!!
	//HttpServletRequest request
	public StudentDTO getStudentInfo(String student_no, String user_id) {	//해당하는 메소드가 실행될 때 필요한 변수를 어떤 곳에 입력받아서 사용하기.
		getConn();
		String sql = "SELECT u.*, s.student_name FROM user_info u left outer join student s ON u.student_no = s.student_no WHERE u.student_no = ? AND u.user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			//ps.setString(1, req.getParameter("student_no"));	//req를 이용하면 항상 req.getparamater가 있는 경우에만 이용이 가능하다
			//ps.setString(2, req.getParameter("user_id"));		//재활용이나 여러 플랫폼에서 활용하기에는 불편하다
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new StudentDTO(rs.getString("student_name"), rs.getString("user_id"), rs.getString("user_pw"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("student_no"));
			}//while
=======
			while(rs.next()) { //boolean타입을 리턴한다
				list.add(new StudentDTO(rs.getInt("STUDENT_NO"), rs.getString("STUDENT_NAME"), rs.getString("USER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME")));
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
			dbClose();
		}
		System.out.println(list.size());
		return list;
	}//getList
	
	
	
	
	//2번 방식 HttpServletRequest req = Controller.req;
	//String abc = Controller."";
	//1번 방식 String student_no, user_id;■■■■■■■■■■■■■■■■■■■<-이걸 더 써라
	public StudentDTO getStudentInfo(String student_no, String user_id) { //해당 하는 메소드가 실행될때 필요한 변수를 어떤곳에 입력받아서 사용하기. (String student_no, String user_id)
		//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
		getConn();
		StudentDTO dto= new StudentDTO();
		String sql =  "SELECT u.*, s.*"
				+ " FROM  USER_INFO u LEFT OUTER JOIN STUDENT s "
				+ " ON s.student_no = u.student_no "
				+ " WHERE u.student_no = ? AND u.user_id = ? ";
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			
			//여기가 오라클 0번 부분! 우리는 1부터 사용한다. 이말이야! 
//			ps.setString(1, req.getParameter("student_no"));   req를 이용하면 항상 req.getparamter가 있는 경우에만 이용이 가능
//			ps.setString(2, req.getParameter("user_id"));		//재활이나 여러 플랫폼에서 활용하기엔 불편함
			
			rs = ps.executeQuery();
		
			while ( rs.next()) {
				System.out.println("DAO에서 DTO한건의 내용을 조회중 " + rs.getString("user_id"));
				dto = new StudentDTO(
						rs.getInt("student_no"), 
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name")
						);
				dto.setAdmin_yn(rs.getString("admin_yn"));
				dto.setMoney(rs.getInt("money")); 
				dto.setCreate_ymd(rs.getString("create_ymd")); 
			}
			
>>>>>>> 84d3a69ade1cfcbf9a17281e4d57b761b1f78cc3
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		
		return dto;
<<<<<<< HEAD
	}//getStudentInfo()

	//수정
	public int modifyinfo(StudentDTO dto) {
		getConn();
		String sql = "UPDATE user_info SET first_name = ?, last_name = ? WHERE student_no = ? AND user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFirst_name());
			ps.setString(2, dto.getLast_name());
			ps.setInt(3, dto.getStudent_no());
			ps.setString(4, dto.getUser_id());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return 0;
	}//update()
	
	//삭제
	public StudentDTO deleteInfo(StudentDTO dto) {
		getConn();
		String sql = "DELETE FROM user_info WHERE student_no = ? AND user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getStudent_no());
			ps.setString(2, dto.getUser_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		
		return dto;
	}//deleteInfo()
	
	
}//class
=======
	}//getStudentInfo
	
//   public StudentDTO getUpdate() {
//	   
//	   getConn();
//	   String sql = " UPDATE user_info "
//	   		+ " set user_pw = ? "
//	   		+ " where user_id = ? "; 
//	   
//	   try {
//		ps =conn.prepareStatement(sql);
//		ps.setString(1, "user_pw");
//		ps.setString(2, "user_id");
//		
//		ps.executeUpdate();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		
//	}
//	   
//	   
//	   return dto;
//   }//getUpdate
//   
   public int getModify(StudentDTO dto) { //() 안에 
	   
	   getConn();
	   String sql = " UPDATE user_info "
	   		+ " SET FIRST_NAME = ?, Last_NAME = ? "
	   		+ " WHERE student_no = ? AND user_id = ?"; 
	  
	   try {
		   ps =conn.prepareStatement(sql);
		   ps.setString(1, dto.getFirst_name());
		   ps.setString(2, dto.getLast_name());
		   ps.setInt(3, dto.getStudent_no());
		   ps.setString(4, dto.getUser_id());
		   
//		   ps.setString(1, first_name);  이건 내가 매개변수를 직접 넣어주면 그냥 써도 되는거고  바로 dto를 데려온거면 dto.get~이걸로 데려와야하고!
//		   ps.setString(2, last_name);
//		   ps.setString(3, student_no);
//		   ps.setString(4, user_id);
//		   
		 return ps.executeUpdate();
		   
		   
	   } catch (SQLException e) {
		   System.out.println("수정쪽 오류");
		   e.printStackTrace();
	   }finally {
		dbClose();
	   }
	   
	 return -1;
   }//

   
   public StudentDTO delete(StudentDTO dto) {
	   getConn();
	   String sql = "DELETE FROM user_info WHERE user_id = ? ";
	   
	   try {
		ps= conn.prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		dbClose();
	}
	   
	   
	return dto;   
   }
   
   
}//class
>>>>>>> 84d3a69ade1cfcbf9a17281e4d57b761b1f78cc3
