package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CouponMapper {

	public String read(String uid) {
		//String url = "jdbc:mysql://localhost:3306/garam?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		//String user = "root";
		//String password = "smart";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String coupon = "0";
		
		try {
			StringBuffer qry = new StringBuffer();
			qry.append(" SELECT coupon FROM g_member ");
			qry.append(" WHERE uid = ? ");			
						
			String sql = qry.toString();
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//conn = DriverManager.getConnection(url, user, password);			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/garam");
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, uid);			
			
			rs = stmt.executeQuery();			
			
			if(rs.next()) {
				coupon = rs.getString("coupon");							
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return coupon;
	}

}
