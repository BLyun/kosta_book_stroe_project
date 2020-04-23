package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Levels;
import kbs.mvc.util.DBUtil;

public class LevelDAOImpl implements LevelDAO {
	
	List<Levels> selectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Levels> list = new ArrayList<Levels>();
		
		try {
		
			String sql = "select * from levels";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Levels levels = new Levels(rs.getInt(levels), rs.getInt(discount), rs.getInt(min), rs.getInt(max));
				
				list.add(levels);
				
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
	}
	
	Levels selectByLevels() throws SQLException{
		
				
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Levels levels=null;	
		try {
			String sql ="select * from levels where levels=?";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				levels = new Levels(rs.getInt(levels), rs.getInt(discount), rs.getInt(min), rs.getInt(max));
							
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return levels;
	}
	
	
	int update() throws SQLException{
			
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="insert into QnA values ( ?,sysdate,?,?,?,?)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbclose(con, ps);
		}		
		return result;
	}
	
	int delete() throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="insert into QnA values ( ?,sysdate,?,?,?,?)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbclose(con, ps);
		}		
		return result;
	}
	
	
	int insert() throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="insert into QnA values ( ?,sysdate,?,?,?,?)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbclose(con, ps);
		}		
		return result;
	}
	
	
}
