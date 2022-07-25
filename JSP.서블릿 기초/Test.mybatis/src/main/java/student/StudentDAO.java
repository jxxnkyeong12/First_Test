package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

	Connection conn;
	PreparedStatement ps; //질의문객체
	ResultSet rs ;
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
			System.out.println("연결안됐어!");
		}
		return conn;
	}

	public void dbClose() {
		try { 
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();// 2
			}
			if (conn != null) {
				conn.close();// 1
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectOne() { //잘 가져왔나 확인용!
		getConn();
		String sql = " select 1 as num1 from dual ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("num1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//selectOne
	
	
	public ArrayList<StudentDTO> getList(){
		getConn();
		String sql = " select u.*, s.student_name from user_info u left outer join student s on u.student_no = s.student_no ";
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			ps =conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			/*	String student_name, String user_id, String user_pw, String first_name, String last_name,
				int student_no) */
				list.add(new StudentDTO(
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getInt("student_no"))
						);
			}//while
		} catch (Exception e) {
			System.out.println("getList학생목록 리스트에서 에러남");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}//getList조회
	

	public StudentDTO getStudentInfo(String student_no , String user_id) {// 해당하는 메소드가 실행될때 필요한 변수를 어떤곳에 입력받아서 사용하기.
		StudentDTO dto =null;
		getConn();
		String sql = " SELECT u.* , s.student_name  FROM USER_INFO u left outer join STUDENT s on u.STUDENT_NO = s.STUDENT_NO "
				+ " where  u.STUDENT_NO= ? AND u.USER_ID=? ";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			
		//	ps.setString(1, req.getParameter("studentno")); req를 이용하면 항상 req.getparamter가 있는경우에만 이용이가능
														  //재활용이나 여러 플랫폼에서 활용하기엔 불편함
		//	ps.setString(2, req.getParameter("user_id"));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new StudentDTO(
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
				        rs.getInt("student_no")
						);
				dto.setAdmin_yn(rs.getString("admin_yn"));
			//	dto.setMoney(rs.getInt("money"));
				dto.setCreate_ymd(rs.getString("create_ymd"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
		
		return dto;
	}
	
	public int modify(StudentDTO dto) { //수정이야
		getConn();
		String sql = " update user_info set first_name =?,  last_name =?"
				+ " where student_no = ? AND user_id =? "; //
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFirst_name());
			ps.setString(2, dto.getLast_name());
			ps.setInt(3, dto.getStudent_no());
			ps.setString(4, dto.getUser_id());
			
		  ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("업데이트 쪽에서 에러났어!");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return 0;
	}//update
	
	public int deleteInfo(String student_no, String user_id) {
		getConn();
		String sql = " DELETE FROM user_info WHERE student_no = ? AND user_id = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			
			
		return	ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("삭제오류");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return 0;
	}//삭제
	
	
}//class
