package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void selectOne() {
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
		
		
	}
	//수동↓
	public ArrayList<StudentDTO> getManualLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("a", "b", "c", "d", "e", i));
		}
		return list;
	}
	//실제 있는 데이터를 가져오는 getList라는 메소드를 만들고 해당하는 메소드를 이용해서
	//실제 데이터를 활용하기
	
	public ArrayList<StudentDTO> getLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		getConn();
		String sql = "SELECT u.* , s.student_name "
				+ " FROM USER_INFO u left outer join STUDENT s on u.STUDENT_NO = s.STUDENT_NO";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				list.add(new StudentDTO(
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getInt("student_no")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return list;
	}
	
	
	// HttpServletRequest req = Controller.req;
	// String abc = Controller."";
	// 1 .String student_no , user_id ; ☆☆☆★★★★★
	public StudentDTO getStudentInfo(String student_no , String user_id) {// 해당하는 메소드가 실행될때 필요한 변수를 어떤곳에 입력받아서 사용하기.
		StudentDTO dto = null;
		getConn();
		String sql = " SELECT u.* , s.student_name  "
				+ "FROM USER_INFO u left outer join STUDENT s "
				+ "on u.STUDENT_NO = s.STUDENT_NO "
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
				dto.setMoney(rs.getInt("money"));
				dto.setCreate_ymd(rs.getString("create_ymd"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
		
		return dto;
	}
	
	//수정 메소드
	public int updateInfo(String first_name, String last_name, String student_no, String user_id) {
		getConn();
		String sql = "UPDATE  user_info "
				+ "SET     first_name = ? , last_name =? "
				+ "WHERE   user_id = ?  AND student_no = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, user_id);
			ps.setString(4, student_no);
			return ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return 0;
	}
	
	//아이디 삭제 메소드
	public int deleteInfo(String student_no, String user_id) {
		getConn();
		String sql = "DELETE  FROM    user_info "
				+ "WHERE   user_id = ? AND student_no = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, student_no);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
