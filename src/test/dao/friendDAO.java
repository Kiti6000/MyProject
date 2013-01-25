package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import test.dto.friendDTO;
import test.util.DbcpBean;

public class friendDAO {
	private static friendDAO dao;
	
	public static friendDAO getInstance(){
		if(dao == null){
			dao = new friendDAO();
		}
		return dao;
	}
	
	public ArrayList<friendDTO> getListArrayList(){
		Connection conn = new DbcpBean().getConn();
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<friendDTO> list = new ArrayList<friendDTO>();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT num, name, phone, TO_CHAR(regdate, 'YYYY-MM-DD') regdate FROM friend ORDER BY num";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String regdate = rs.getString("regdate");
				
				//DTD 에 넣은 후 ArrayList 에 추가한다.
				list.add(new friendDTO(num, name, phone, regdate));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
		if(list.size() >0){
			return list;
		}else{
			return null;
		}
	}//getListArrayList
	
	//getOneList
	public ArrayList<friendDTO> getOneList(int number){
		Connection conn = new DbcpBean().getConn();
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<friendDTO> list = new ArrayList<friendDTO>();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT num, name, phone, TO_CHAR(regdate, 'YYYY-MM-DD') regdate FROM friend WHERE num = " + number;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String regdate = rs.getString("regdate");
				
				//DTD 에 넣은 후 ArrayList 에 추가한다.
				list.add(new friendDTO(num, name, phone, regdate));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
		if(list.size() >0){
			return list;
		}else{
			return null;
		}
	}//getOneList
	
	public ArrayList<HashMap> getListHashMap(){
		Connection conn = new DbcpBean().getConn();
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT num, name, phone, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate FROM friend ORDER BY num";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String regdate = rs.getString("regdate");
				
				//HashMap 에 넣은 후 ArrayList 에 추가한다.
				HashMap map = new HashMap();
				
				map.put("num", num);
				map.put("name", name);
				map.put("phone", phone);
				map.put("regdate", regdate);
				list.add(map);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
		if(list.size() >0){
			return list;
		}else{
			return null;
		}
	}//getListHashMap
	
	//insert
	public boolean insert(friendDTO dto){
		//필요한 객체 생성
		Connection conn = new DbcpBean().getConn();
		PreparedStatement pstmt = null;
		int flag = 0;
		try{
			//SQL 구문 생성
			String sql = "INSERT INTO friend VALUES(seq_friend.nextval, ?,?,sysdate)";
			
			//PreparedStatement 객체 구해오고 Insert 실행하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			
			flag = pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException se){}
		}
		if(flag > 0){
			return true;
		}else{
			return false;
		}
	}//insert
	
	//update
	public boolean update(friendDTO dto){
		//필요한 객체 생성
		Connection conn = new DbcpBean().getConn();
		PreparedStatement pstmt = null;
		int flag = 0;
		try{
			//SQL 구문 생성
			String sql = "UPDATE friend SET name=?, phone=? WHERE num=?";
			
			//PreparedStatement 객체 구해오고 update 실행하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setInt(3, dto.getNum());
			
			flag = pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException se){}
		}
		if(flag > 0){
			return true;
		}else{
			return false;
		}
	}//update
	
	//delete
	public boolean delete(int num){
		//필요한 객체 생성
		Connection conn = new DbcpBean().getConn();
		Statement stmt = null;
		boolean flag = true;
		try{
			//SQL 구문 생성
			String sql = "DELETE FROM friend WHERE num=" + num;
			
			//Statement 객체 구해오고 delete 실행하기
			stmt = conn.createStatement();			
			flag = stmt.execute(sql);
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(SQLException se){}
		}
		if(flag){
			return true;
		}else{
			return false;
		}
	}//delete
}//friendDAO class
