
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBCon;
import dto.MenuDTO;
import dto.SalesDTO;

public class MenuDAO {
	
	public ArrayList<MenuDTO> getAllInfo(){
		ArrayList<MenuDTO> list = new ArrayList<MenuDTO>();
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		
		try {
			String sql = "select id, prod_name, prod_price, prod_stock, prod_cnt from menulist order by id";	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO vo= new MenuDTO(rs.getInt("id"), rs.getString("prod_name"),rs.getInt("prod_price"),rs.getInt("prod_stock"),rs.getInt("prod_cnt"));
				list.add(vo);				
			}
			
		}catch(SQLException e) {
			System.out.println("select 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt, rs);
		}								
		return list;				
	}
	

	public int InsertInfo(MenuDTO menu){		
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = null;
		int rows =0;
		
		try {
			String sql = "insert into menulist(id, prod_name, prod_price, prod_stock) values(menulist_seq.nextval,?,?,?)";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, menu.getProd_name());
			pstmt.setInt(2, menu.getProd_price());
			pstmt.setInt(3, menu.getProd_stock());
			
			rows = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println("insert 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt);
		}	
		return rows;
	}
	
	public int DeleteInfo(int id){		

		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			String sql = "delete from menulist where id = ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);

			
			rows = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println("delete 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt);
		}	
		return rows;
	}
	
	
	public int UpdateInfo(MenuDTO menu){		
		
		PreparedStatement pstmt = null;
		Connection con = DBCon.getConnection();
		int rows = 0;
		
		try {
			String sql = "update menulist set prod_name=?,prod_price=?,prod_stock=? where id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, menu.getProd_name());
			pstmt.setInt(2, menu.getProd_price());
			pstmt.setInt(3, menu.getProd_stock());
			pstmt.setInt(4, menu.getId());
			
			rows = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println("update 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt);
		}	
		return rows;
	}
	
	public int UpdateStockInfo(ArrayList<SalesDTO> menu){		
		
		PreparedStatement pstmt = null;
		Connection con = DBCon.getConnection();
		int rows = 0;
		//(String sold_name, int sold_price, int sold_cnt, int sold_totprice)

		try {
			String sql = "update menulist set prod_stock=prod_stock-?, prod_cnt= ? where prod_name =?";
					
			pstmt= con.prepareStatement(sql);
			
			for(int i=0; i<menu.size(); i++) {
			pstmt.setInt(1, menu.get(i).getSold_cnt());
			pstmt.setInt(2, menu.get(i).getSold_cnt());
			pstmt.setString(3, menu.get(i).getSold_name());
			pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
			
		}catch(SQLException e) {
			System.out.println("update 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt);
		}	
		return rows;
	}
	
	
	public ArrayList<MenuDTO> getSearchInfo(String name){
		ArrayList<MenuDTO> list = new ArrayList<MenuDTO>();
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, prod_name, prod_price, prod_stock, prod_cnt from menulist where prod_name like '%'||?||'%' order by id";	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO vo= new MenuDTO(rs.getInt("id"), rs.getString("prod_name"),rs.getInt("prod_price"),rs.getInt("prod_stock"),rs.getInt("prod_cnt"));
				list.add(vo);				
			}
			
		}catch(SQLException e) {
			System.out.println("search 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt, rs);
		}								
		return list;				
	}
	
	public ArrayList<MenuDTO> getHambeger(int id){
		ArrayList<MenuDTO> list = new ArrayList<MenuDTO>();
		
		Connection con = DBCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, prod_name, prod_price, prod_stock, prod_cnt from menulist where id = ?";	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO vo= new MenuDTO(rs.getInt("id"), rs.getString("prod_name"),rs.getInt("prod_price"),rs.getInt("prod_stock"),rs.getInt("prod_cnt"));
				list.add(vo);				
			}
			
		}catch(SQLException e) {
			System.out.println("search 오류가 발생했습니다"+e.getMessage());
		}finally {
			DBCon.close(con, pstmt, rs);
		}								
		return list;				
	}

}
