package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconn.DBCon;
import dto.LoginDTO;


public class LoginDAO {
	public ArrayList<LoginDTO> getLoginInfo(){

		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = DBCon.getConnection();
		
		try {
			String sql = "SELECT * FROM PCMANAGER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LoginDTO vo = new LoginDTO();
						vo.setId(rs.getString("id")); 
						vo.setPassword(rs.getString("password"));
						vo.setName(rs.getString("name"));
						vo.setGrade(rs.getString("grade"));

				
				
				list.add(vo);
			}
			
			
				
			}catch(Exception E) {
				System.out.println("[에러 발생]");
			}
		finally {
			DBCon.close(con, pstmt, rs);
		}
		return list;
	}
}
