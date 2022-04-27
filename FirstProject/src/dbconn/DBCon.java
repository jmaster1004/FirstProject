package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {
	public static Connection getConnection(){
		Connection con= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = ("jdbc:oracle:thin:@localhost:1521:xe");
			String user = "BITUSER";
			String password = "1004";
			
			con = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			System.out.println("[에러]Connection 인스턴스를 생성할 수 없습니다.");
		}
		return con;
	}
	
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		}catch(SQLException e) {
			
		}
	}
	
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			
		}
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			
		}
	}
}
