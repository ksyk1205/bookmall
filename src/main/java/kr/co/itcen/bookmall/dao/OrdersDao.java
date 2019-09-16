package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrdersVo;


public class OrdersDao {
	public Boolean insert(OrdersVo vo1) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs =null;
		Boolean result = false;
		
		try {
			connection = getConnection();
			String sql= "insert into orders values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo1.getPrice());
			pstmt.setString(2, vo1.getDeli_address());
			pstmt.setLong(3, vo1.getUser_no());

			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo1.setNo(no);
			}
			
		} catch (SQLException e) {
			System.out.println("error: "+e);
		}finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	

	}
	public ArrayList getList() {
		ArrayList result = new ArrayList();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select a.no,b.name ,b.email, a.price,a.deli_address from orders a, user b where a.user_no =b.no order by a.no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name =rs.getString(2);
				String email=rs.getString(3);
				Long price =rs.getLong(4);
				String deli_address =rs.getString(5);
				

				ArrayList temp = new ArrayList();
				temp.add(no);
				temp.add(name);
				temp.add(email);
				temp.add(price);
				temp.add(deli_address);


				result.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	private Connection getConnection() throws SQLException {
		Connection connection  =null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.1.73:3306/bookmall?characterEncoding=utf8";
			connection= DriverManager.getConnection(url, "bookmall", "bookmall");

		
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver : "+ e);
		}
		return connection;
		
	}



}
