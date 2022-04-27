package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBCon;
import dto.SalesDTO;


//int id, String sold_name, int sold_price, int sold_cnt, int sold_totprice, Date sold_date
public class SalesDAO {
	public ArrayList<SalesDTO> getAllInfo(){
		ArrayList<SalesDTO> list = new ArrayList<SalesDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBCon.getConnection();
			String sql = "select id, sold_name, sold_price, sold_cnt, sold_totprice, sold_date from sales order by id";	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SalesDTO vo= new SalesDTO(rs.getInt("id"), rs.getString("sold_name"), rs.getInt("sold_price"), rs.getInt("sold_cnt"), rs.getInt("sold_totprice"), rs.getDate("sold_date"));
				list.add(vo);				
			}
			
		}catch(SQLException e) {
			System.out.println("select 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt, rs);
		}								
		return list;				
	}
	//(String sold_name, int sold_price, int sold_cnt, int sold_totprice)

	public void insertSalesInfo(ArrayList<SalesDTO> sales) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows =0;
		
		//int id, String sold_name, int sold_price, int sold_cnt, int sold_totprice, Date sold_date
		
		try {
			
			con = DBCon.getConnection();

			String sql = "insert into sales(id, sold_name, sold_price, sold_cnt, sold_totprice) values(bsale_seq.nextval,?,?,?,?)";
			pstmt= con.prepareStatement(sql);


			for(int i=0; i<sales.size(); i++) {
			pstmt.setString(1, sales.get(i).getSold_name());
			pstmt.setInt(2, sales.get(i).getSold_price());
			pstmt.setInt(3, sales.get(i).getSold_cnt());
			pstmt.setInt(4, sales.get(i).getSold_totprice());
			pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
			
		}catch(SQLException e) {
			System.out.println("insert 오류가 발생했습니다"+e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DBCon.close(con, pstmt);
		}		
	}
	
}
