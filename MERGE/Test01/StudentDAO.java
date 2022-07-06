package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
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
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		
		return dto;
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