package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Levels;
import kbs.mvc.model.domain.Review;
import kbs.mvc.util.DBUtil;

public class ReviewDAOImpl implements ReviewDAO {
	
	List<Review> selectAll() throws SQLException{
			
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		String sql = "select * from review";
		List<Review> list = new ArrayList<Review>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Review review = new Review(rs.getInt(reviewNo), rs.getString(isbn), rs.getDate(regDt), rs.getString(content), rs.getString(customer_id), rs.getInt(readNum));
				
				list.add(review);
				
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
		
	}
	
	Review selectByNo() throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		String sql = "select * from review where review_no=?";
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			review = new Review(rs.getInt(reviewNo), rs.getString(isbn), rs.getDate(regDt), rs.getString(content), rs.getString(customer_id), rs.getInt(readNum));
				
						
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
	}
	
	Review selectByIsbn() throws SQLException{
		
		String sql = "select * from review where ISBN =?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			review = new Review(rs.getInt(reviewNo), rs.getString(isbn), rs.getDate(regDt), rs.getString(content), rs.getString(customer_id), rs.getInt(readNum));
							
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
	}
	
	Review selectById() throws SQLException{
		
		String sql = "select * from review where customer_id =?";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			review = new Review(rs.getInt(reviewNo), rs.getString(isbn), rs.getDate(regDt), rs.getString(content), rs.getString(customer_id), rs.getInt(readNum));
				
						
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
		
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
		String sql ="delete from review ";
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
