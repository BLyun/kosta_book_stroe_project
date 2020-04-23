package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.domain.Review;
import kbs.mvc.util.DBUtil;

public class QnADAOImpl implements QnADAO {
	
	List<QnA> selectAll() throws SQLException{
		
		String sql = "select * from QnA";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnA> list = new ArrayList<QnA>();
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list = new Review(rs.getInt(reviewNo), rs.getString(isbn),
						rs.getInt(evaluation), rs.getDate(regDt), rs.getString(content),
						rs.getString(customer_id), rs.getInt(readNum));
				
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
		
	}
	
	
	QnA selectByNo() throws SQLException{
		
		
		String sql = "select * from QnA where review_no = ?";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			qna = new QnA(rs.getInt(reviewNo), rs.getDate(regDt), 
					rs.getString(qaContent), rs.getString(customerId),
					rs.getInt(readNum), rs.getString(title);
				
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return qna;
		
	}
	

		
	QnA selectById() throws SQLException{
		
		
		String sql = "select * from QnA where customer_id=?"; 
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			qna = new QnA(rs.getInt(reviewNo), rs.getDate(regDt), 
					rs.getString(qaContent), rs.getString(customerId),
					rs.getInt(readNum), rs.getString(title);
				
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return qna;
	}
	
	List<QnA> selectBytitle() throws SQLException{
		
		String sql = "select * from QnA where title like %?%";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			qna = new QnA(rs.getInt(reviewNo), rs.getDate(regDt), 
					rs.getString(qaContent), rs.getString(customerId),
					rs.getInt(readNum), rs.getString(title);
				
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return qna;
		
	}
	
	/*
	 * 확인완료
	 */
	int increamentByReadnum(int reviewNo) throws SQLException{
		
		String sql = "update QnA set readNum = readNum + 1 where reviewNo=?";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result;
				
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			
				
			}			
		}finally {
			DBUtil.dbclose(con, ps);
		}
		
		return result;
		
	}
	
	
	int update(int reviewNo) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="update QnA set title=?, QA_content=? where reviewNo=?";
		
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbclose(con, ps);
		}		
		return result;
	}
	
	int delete(int reviewNo, String pwd) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="delete from QnA where reviewNo=? ";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbclose(con, ps);
		}		
		return result;
	}
	
	
	int insert(int reviewNo) throws SQLException{
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
