package kbs.mvc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DB연동에 관련된
 * 로드, 연결, 닫기 기능 담당 클래스
 * */
public class DBUtil {
	private static DataSource dataSource;
	/**
	 * 	로드
	 * */
	
//	static {
//		Class.forName("oracle.jdbc.OracleDriver");
//	} --> 이미 context에서 처리함, context만 가져오면 됨
	
	static {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
			//data source를 얻어오는 과정
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	연결
	 * @throws SQLException 
	 * */
	
	public static Connection getConnection() throws SQLException { 
		//예외를 던지는 이유 : dao 클래스에서 예외처리를 중복하게 된다.
		/* public int insert(){
		 * 	Connection con = Dbutil.getConnection();
		 * 	ty{
		 *  con.prepareStatemet("sql 문장");
		 *  } catch 
		 */
		
		return dataSource.getConnection();
	}
	
	/**
	 * 	닫기(DML전용: insert, update, delete)
	 * */
	public static void dbclose(Connection con, Statement st) {
		
		//역순으로 닫는다.
		try {
			if(st!= null) st.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 닫기 (select 전용)
	 * */
	
	public static void dbclose(Connection con, Statement st, ResultSet rs) {
		
		try {
			if(rs!=null)rs.close();
			dbclose(con, st); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
