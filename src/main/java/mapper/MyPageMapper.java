package mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.LoginVO;
import domain.MyPageDTO;
import service.MyPageService;

public class MyPageMapper implements MyPageService{

	@Override
	public LoginVO read(MyPageDTO dto) {
		String url = "jdbc:mysql://localhost:3306/garam?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer qry = new StringBuffer();
			qry.append(" SELECT * FROM g_member ");
			qry.append(" WHERE uid = ? ");
						
			String sql = qry.toString();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getUid());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				LoginVO vo = new LoginVO();
				
				vo.setNum(rs.getLong("num"));				
				vo.setUname(rs.getString("uname"));
				vo.setSchoolname(rs.getString("schoolname"));
				vo.setGradeclass(rs.getString("gradeclass"));
				vo.setUid(rs.getString("uid"));
				vo.setUpw(rs.getString("upw"));
				vo.setRoute(rs.getString("route"));
				vo.setBoardingplace(rs.getString("boardingplace"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setCoupon(rs.getInt("coupon"));
				
				return vo;
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
		return null;
	}

	@Override
	public void update(LoginVO vo) {
		String url = "jdbc:mysql://localhost:3306/garam?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		
		Connection conn = null;
		PreparedStatement stmt = null;
				
		try {
			StringBuffer qry = new StringBuffer();
			qry.append(" UPDATE g_member ");
			qry.append(" SET uname= ?, schoolname= ?, gradeclass= ?, route= ?, boardingplace= ? ");
			qry.append(" WHERE uid = ? ");
						
			String sql = qry.toString();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUname());
			stmt.setString(2, vo.getSchoolname());
			stmt.setString(3, vo.getGradeclass());
			stmt.setString(4, vo.getRoute());
			stmt.setString(5, vo.getBoardingplace());
			stmt.setString(6, vo.getUid());
			
			stmt.executeUpdate();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {				
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	public void insert(LoginVO vo) {
		String url ="jdbc:mysql://localhost:3306/garam?characterEncoding=utf-8&&serverTimezone=Asia/Seoul";
		String user ="root";
		String password ="smart";
		StringBuffer qry = new StringBuffer();
		qry.append("INSERT INTO g_member (uname, schoolname, gradeclass, uid, upw, route, boardingplace, joindate) VALUES (?, ?, ?, ?, sha1(?), ?, ?,now())");

		String sql = qry.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn = DriverManager.getConnection(url, user, password);
		
		stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, vo.getUname());
		stmt.setString(2, vo.getSchoolname());
		stmt.setString(3, vo.getGradeclass());
		stmt.setString(4, vo.getUid());
		stmt.setString(5, vo.getUpw());
		stmt.setString(6, vo.getRoute());
		stmt.setString(7, vo.getBoardingplace());

		res = stmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
		//닫기
		
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

	@Override
	public LoginVO read(String uid) {
		String url = "jdbc:mysql://localhost:3306/garam?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LoginVO vo = new LoginVO();

		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT * FROM g_member WHERE uid = ? ");
		String sql = qry.toString();

		String route = "";
		String boardingPlace = "";
		String schoolName = "";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt =  conn.prepareStatement(sql);
			
			stmt.setString(1, uid);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				vo = new LoginVO();
				
				vo.setNum(rs.getLong("num"));				
				vo.setUname(rs.getString("uname"));
				vo.setSchoolname(rs.getString("schoolname"));
				vo.setGradeclass(rs.getString("gradeclass"));
				vo.setUid(rs.getString("uid"));
				vo.setUpw(rs.getString("upw"));
				vo.setRoute(rs.getString("route"));
				vo.setBoardingplace(rs.getString("boardingplace"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setCoupon(rs.getInt("coupon"));
				
				return vo;
			}
			
		}catch(Exception e){
			e.getLocalizedMessage();
		}finally{
			
				try {
					if(rs!=null)rs.close();
					if(conn!=null)conn.close();
					if(stmt!=null)stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}   
		return vo;
	}
}
