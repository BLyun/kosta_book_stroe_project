package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Delivery;
import kbs.mvc.util.DBUtil;

public class DeliveryDAOImpl implements DeliveryDAO {

	
	
	
	List<Delivery> selectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Delivery> list = new ArrayList<Delivery>();
		
		String sql= "select * from delivery";
		
		
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			Delivery delivery = new Delivery(rs.getInt(order_no), rs.getString(customerId), rs.getInt(deliveryStaus),
					rs.getString(address);
			
			
			list.add(delivery);
			
		}
		
		}finally{
			DBUtil.dbclose(con, ps, rs);
		}
		
		
		return list; 
		
	}
	
	
	Delivery selectByNo() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Delivery delivery = null;
		String sql= "select * from delivery where order_no =?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					
				Delivery delivery = new Delivery(rs.getString(order_no), rs.getString(customerId), rs.getString(deliveryStaus),
						rs.getString(address);
								
			}
			
			}finally{
				DBUtil.dbclose(con, ps, rs);
			}
			
			
			return delivery; 
			
		}
		
			
}
