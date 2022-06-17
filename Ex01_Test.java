package pack04.odjbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex01_Test {
	//Oracle<-> DataBase Java Connection 두개를 연결하는 거야 
	//DAO, DTO
	
	//Connection <= 연결로를 만드는 객체 (연결 객체) 
	//PreparedStatement <= 어떤 데이터를 전송하기 위한 객체 (연결된 연결객체를 통해서 전송함)
	//ResultSet <= 전송하고 나서 응답을 받으면 그결과를 담는 객체( 결과 객체)
	
	
	public static void main(String[] args) {
		 Ex01_Test et = new Ex01_Test();
		// et.connTest();
		 et.connTest2();
		 et.connTest3();
		}//main()

	
	//■Connection 연결 객체 사용해서 통신 되는지 체크
	public boolean connTest() { //url, user , password, Ojdbc Class( 동적 로딩 = 자주 안씀)
		
		//■oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";  //코트번호. 1521 항상 열려있다
		String user ="hanul";
		String password ="0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//필요한 드라이버를 동적으로 로딩함.
			Connection conn = DriverManager.getConnection(url, user, password); 
			if(conn.isClosed()) { //is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = 
						conn.prepareStatement(" select 1 num from dual ");//new 하지마! 쓸데없는거 쫙 나와버려/ select111이렇게 해서 오류 나오는지도 확인해!
															//세미콜론 하지마!
				ResultSet rs= ps.executeQuery(); //sql이야! 그리고 ResultSet으로 결과 받아주는것 까지하면 오퀘이
				while(rs.next()) {
					System.out.println(rs.getInt("num")); //String 이름을 직접 써주는 방식,  이 방법은 밑에 방법보단 안전해 왜?
					System.out.println(rs.getInt(1)); //int로 1이 두번 나오게 해보기... 오라클이 행 0번을 쓰고 있어 1번을 넣으면 0,1해서 1이 두번 찍힘 근데 이 방식은 많이 위험하대
				}
				
				conn.close(); //통신을 열었으니 닫아줘야지! ★동시에 접속할수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)"); //닫아졌는지 확인하는거야
			}
		} catch (Exception e) { //모든 예외 처리하게 Exception으로 바꿔줘
			e.printStackTrace();
		}
		return false;
	}//
	
	
	public boolean connTest2() { //url, user , password, Ojdbc Class( 동적 로딩 = 자주 안씀)
		
		//■oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";  //코트번호. 1521 항상 열려있다
		String user ="hanul";
		String password ="0000";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");//필요한 드라이버를 동적으로 로딩함.
			Connection conn = DriverManager.getConnection(url, user, password); 
			if(conn.isClosed()) { //is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = 
						conn.prepareStatement(" select 'KJK' name from dual ");//new 하지마! 쓸데없는거 쫙 나와버려/ select111이렇게 해서 오류 나오는지도 확인해!
															//세미콜론 하지마!
				ResultSet rs= ps.executeQuery(); //sql이야! 그리고 ResultSet으로 결과 받아주는것 까지하면 오퀘이
				while(rs.next()) {
					System.out.println(rs.getString("name")); //String 이름을 직접 써주는 방식,  이 방법은 밑에 방법보단 안전해 왜?
					//System.out.println(rs.getInt(1)); //int로 1이 두번 나오게 해보기... 오라클이 행 0번을 쓰고 있어 1번을 넣으면 0,1해서 1이 두번 찍힘 근데 이 방식은 많이 위험하대
				}
				
				conn.close(); //통신을 열었으니 닫아줘야지! ★동시에 접속할수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)"); //닫아졌는지 확인하는거야
			}
		} catch (Exception e) { //모든 예외 처리하게 Exception으로 바꿔줘
			e.printStackTrace();
		}
		return false;
	}//
	
	
	public boolean connTest3() {
		
		 Scanner sc = new Scanner(System.in);
		 System.out.print("아무거나 입력하세요 :");
		 String name = sc.nextLine();
		 
		//■oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";  //코트번호. 1521 항상 열려있다
		String user ="hanul";
		String password ="0000";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");//필요한 드라이버를 동적으로 로딩함.
			Connection conn = DriverManager.getConnection(url, user, password); 
			if(conn.isClosed()) { //is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = 
						conn.prepareStatement(" select '" + name + "'as result from dual ");//new 하지마! 쓸데없는거 쫙 나와버려/ select111이렇게 해서 오류 나오는지도 확인해!
															//세미콜론 하지마!
				ResultSet rs= ps.executeQuery(); //sql이야! 그리고 ResultSet으로 결과 받아주는것 까지하면 오퀘이
				while(rs.next()) {
					System.out.println(rs.getString("result")); //String 이름을 직접 써주는 방식,  이 방법은 밑에 방법보단 안전해 왜?
					//System.out.println(rs.getString(1)); //String로 1이 두번 나오게 해보기... 오라클이 행 0번을 쓰고 있어 1번을 넣으면 0,1해서 1이 두번 찍힘 근데 이 방식은 많이 위험하대
				}
				
				conn.close(); //통신을 열었으니 닫아줘야지! ★동시에 접속할수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)"); //닫아졌는지 확인하는거야
			}
		} catch (Exception e) { //모든 예외 처리하게 Exception으로 바꿔줘
			e.printStackTrace();
		}
		return false;
		
		
	}//connTest3
}//class
